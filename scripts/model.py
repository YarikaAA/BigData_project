# import nessasery libraries
import math
import os
from pprint import pprint
from pyspark.sql import SparkSession
from pyspark.ml.feature import StringIndexer, OneHotEncoder
from pyspark.ml.feature import VectorAssembler, VectorIndexer
from pyspark.ml import Pipeline
from pyspark.ml.regression import LinearRegression, RandomForestRegressor
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator
from pyspark import keyword_only
from pyspark.ml import Transformer
from pyspark.ml.param.shared import HasInputCol, HasOutputCol, Param
from pyspark.ml.param.shared import Params, TypeConverters
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.sql import DataFrame
import pyspark.sql.functions as F


def gps_to_ecef_custom(location):
    # taken from
    # https://danceswithcode.net/engineeringnotes/geodetic_to_ecef/geodetic_to_ecef.html
    '''
    convert geospatial coordinates (lat, lng) into xyz system
    params:
        x: struct<x: double, y: double, z: double>
    return:
        x, y, z: int - xyz coordinates
    '''
    lat, lon = location
    alt = 0

    rad_lat = lat * (math.pi / 180.0)
    rad_lon = lon * (math.pi / 180.0)

    a = 6378137.0
    finv = 298.257223563
    f = 1 / finv
    e2 = 1 - (1 - f) * (1 - f)
    v = a / math.sqrt(1 - e2 * math.sin(rad_lat) * math.sin(rad_lat))

    x = (v + alt) * math.cos(rad_lat) * math.cos(rad_lon)
    y = (v + alt) * math.cos(rad_lat) * math.sin(rad_lon)
    z = (v * (1 - e2) + alt) * math.sin(rad_lat)

    return x, y, z


# custum transformer for converting geospatial coordinates (lat, lng) into xyz
class CustomTransformer(Transformer, HasInputCol, HasOutputCol,
                        DefaultParamsReadable, DefaultParamsWritable):
    '''
    transformer that converts geospatial coordinates (lat, lng) into xyz system
    '''
    input_col = Param(Params._dummy(), "input_col", "input column name.",
                      typeConverter=TypeConverters.toString)
    output_col = Param(Params._dummy(), "output_col", "output column name.",
                       typeConverter=TypeConverters.toString)

    @keyword_only
    def __init__(self, input_col: str = "input", output_col: str = "output"):
        self._setDefault(input_col=input_col, output_col=output_col)
        kwargs = self._input_kwargs
        self.set_params(**kwargs)
        super().__init__()

    @keyword_only
    def set_params(self):
        '''set params'''
        kwargs = self._input_kwargs
        self._set(**kwargs)

    def get_input_col(self):
        '''return input columns'''
        return self.getOrDefault(self.input_col)

    def get_output_col(self):
        '''return output columns'''
        return self.getOrDefault(self.output_col)

    def _transform(self, dataset: DataFrame):
        '''transform function'''
        input_col = self.get_input_col()
        output_col = self.get_output_col()
        # Define a UDF that transforms GPS to ECEF and returns a structure
        transform_udf = F.udf(gps_to_ecef_custom,
                              "struct<x: double, y: double, z: double>")
        dataset = dataset.withColumn(output_col,
                                     transform_udf(F.col(input_col)))
        # Split into separate columns
        dataset = dataset.withColumn(output_col + "_x",
                                     dataset[output_col]['x'])
        dataset = dataset.withColumn(output_col + "_y",
                                     dataset[output_col]['y'])
        dataset = dataset.withColumn(output_col + "_z",
                                     dataset[output_col]['z'])
        return dataset.drop(output_col)


# A function to run commands
def run(command):
    '''execute the command'''
    return os.popen(command).read()


# Add here your team number teamx
TEAM = 18

# location of your Hive database in HDFS
WAREHOUSE = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName(f"{TEAM} - spark ML")\
        .master("yarn")\
        .config("hive.metastore.uris",
                "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", WAREHOUSE)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()


# spark.sql("SHOW DATABASES").show()
# spark.sql("USE team18_projectdb").show()
# spark.sql("SHOW TABLES").show()
# spark.sql("SELECT * FROM team18_projectdb.food_delivery").show()


# run it on Spark using spark-submit tool as follows:

#     spark-submit --master yarn scripts/model.py

# print(spark.catalog.listDatabases())

# print(spark.catalog.listTables("team18_projectdb"))

food_delivery_df = spark.read.format("avro") \
                        .table('team18_projectdb.food_delivery')

# Creates a temporary view
# food_deliv.createOrReplaceTempView('food_delivery')


food_delivery_df.printSchema()

# spark.sql("SELECT * FROM food_delivery WHERE Delivery_person_Ratings>4").show()

# spark.sql("SELECT AVG(Delivery_person_Age) FROM food_delivery;").show()

# spark.sql("SELECT * from food_delivery where Type_of_order is NULL;").show()

# Selecting features
assembler_rest = VectorAssembler(
    inputCols=['restaurant_latitude', 'restaurant_longitude'],
    outputCol="restaurant_location")

food_delivery_df = assembler_rest.transform(food_delivery_df)

assembler_rest = VectorAssembler(
    inputCols=['delivery_location_latitude', 'delivery_location_longitude'],
    outputCol="delivery_location")

food_delivery_df = assembler_rest.transform(food_delivery_df)

t = CustomTransformer(input_col='restaurant_location',
                      output_col='restaurant_location_1')
food_delivery_df = t.transform(food_delivery_df)

t = CustomTransformer(input_col='delivery_location',
                      output_col='delivery_location_1')
food_delivery_df = t.transform(food_delivery_df)


assembler_rest = VectorAssembler(
    inputCols=['restaurant_location_1_x', 'restaurant_location_1_y',
               'restaurant_location_1_z'],
    outputCol="restaurant_location_1")

food_delivery_df = assembler_rest.transform(food_delivery_df)

assembler_rest = VectorAssembler(
    inputCols=['delivery_location_1_x', 'delivery_location_1_y',
               'delivery_location_1_z'],
    outputCol="delivery_location_1")
food_delivery_df = assembler_rest.transform(food_delivery_df)


# output.select("name", "marks").show(truncate=False)

categoricalCols = ['type_of_order', 'type_of_vehicle']
others = ['delivery_person_age', 'delivery_person_ratings',
          'restaurant_location_1', 'delivery_location_1']

# Preprocessing: Convert categorical features to numerical
indexers = [
    StringIndexer(inputCol=c,
                  outputCol=f"{c}_indexed").setHandleInvalid("skip")
    for c in categoricalCols
]
indexer = StringIndexer(inputCols=['type_of_order', 'type_of_vehicle'],
                        outputCols=['type_of_order_index',
                                    'type_of_vehicle_index'])
encoders = [
    OneHotEncoder(inputCol=indexer.getOutputCol(),
                  outputCol=f"{indexer.getOutputCol()}_encoded")
    for indexer in indexers
]

# Assemble features into a single vector
assembler = VectorAssembler(inputCols=[
    encoder.getOutputCol() for encoder in encoders] + others,
                            outputCol="features")

# Create a pipeline
pipeline = Pipeline(stages=indexers+encoders+[assembler])

# Fit and transform the data
model = pipeline.fit(food_delivery_df)
data = model.transform(food_delivery_df)

data_transform = data.select(["features", "time_taken"])

featureIndexer = VectorIndexer(inputCol="features",
                               outputCol="indexedFeatures",
                               maxCategories=4).fit(data)
transformed = featureIndexer.transform(data)

#  split the data into 60% training and 40% test (it is not stratified)
(train_data, test_data) = transformed.randomSplit([0.6, 0.4], seed=10)

train_data.select("features", "time_taken")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("features", "time_taken")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/test/*.json > data/test.json")


lr = LinearRegression(featuresCol="features", labelCol="time_taken")
model_lr = lr.fit(train_data)

rf = RandomForestRegressor(featuresCol="features", labelCol="time_taken")
model_rf = rf.fit(train_data)

predictions_lr = model_lr.transform(test_data)
predictions_rf = model_rf.transform(test_data)

evaluator_rmse = RegressionEvaluator(labelCol="time_taken",
                                     predictionCol="prediction",
                                     metricName="rmse")
rmse_lr = evaluator_rmse.evaluate(predictions_lr)
rmse_rf = evaluator_rmse.evaluate(predictions_rf)
print(f"RMSE of LR model on test data = {rmse_lr}")
print(f"RMSE of RF model on test data = {rmse_rf}")

evaluator_r2 = RegressionEvaluator(labelCol="time_taken",
                                   predictionCol="prediction",
                                   metricName="r2")
r2_lr = evaluator_r2.evaluate(predictions_lr)
r2_rf = evaluator_r2.evaluate(predictions_rf)
print(f"R2 of LR model on test data = {r2_lr}")
print(f"R2 of RF model on test data = {r2_rf}")

paramGrid_lr = ParamGridBuilder() \
    .addGrid(lr.regParam, [0.1, 0.01]) \
    .addGrid(lr.elasticNetParam, [0.0, 0.5, 1.0]) \
    .build()

paramGrid_rf = ParamGridBuilder() \
    .addGrid(rf.maxDepth, [2, 5, 10]) \
    .addGrid(rf.numTrees, [2, 5, 7, 10]) \
    .build()

crossval_rmse_lr = CrossValidator(estimator=lr,
                                  estimatorParamMaps=paramGrid_lr,
                                  evaluator=evaluator_rmse,
                                  numFolds=5)
cvModel_rmse_lr = crossval_rmse_lr.fit(train_data)
bestModel_rmse_lr = cvModel_rmse_lr.bestModel
model_rmse_lr = bestModel_rmse_lr
pprint(model_rmse_lr.extractParamMap())
model_rmse_lr.write().overwrite().save("project/models/modelLR_rmse")
# Run it from root directory of the repository
run("hdfs dfs -get project/models/modelLR_rmse \
    models/modelLR_rmse")

crossval_r2_lr = CrossValidator(estimator=lr,
                                estimatorParamMaps=paramGrid_lr,
                                evaluator=evaluator_r2,
                                numFolds=5)
cvModel_r2_lr = crossval_r2_lr.fit(train_data)
bestModel_r2_lr = cvModel_r2_lr.bestModel
model_r2_lr = bestModel_r2_lr
pprint(bestModel_r2_lr.extractParamMap())
model_r2_lr.write().overwrite().save("project/models/modelLR_r2")
# Run it from root directory of the repository
run("hdfs dfs -get project/models/modelLR_r2 models/modelLR_r2")

crossval_rmse_rf = CrossValidator(estimator=rf,
                                  estimatorParamMaps=paramGrid_rf,
                                  evaluator=evaluator_rmse,
                                  numFolds=5)
cvModel_rmse_rf = crossval_rmse_rf.fit(train_data)
bestModel_rmse_rf = cvModel_rmse_rf.bestModel
model_rmse_rf = bestModel_rmse_rf
pprint(bestModel_rmse_rf.extractParamMap())
model_rmse_rf.write().overwrite().save("project/models/modelRF_rmse")
# Run it from root directory of the repository
run("hdfs dfs -get project/models/modelRF_rmse \
    models/modelRF_rmse")

crossval_r2_rf = CrossValidator(estimator=rf,
                                estimatorParamMaps=paramGrid_rf,
                                evaluator=evaluator_r2,
                                numFolds=5)
cvModel_r2_rf = crossval_r2_rf.fit(train_data)
bestModel_r2_rf = cvModel_r2_rf.bestModel
model_r2_rf = bestModel_r2_rf
pprint(bestModel_r2_rf.extractParamMap())
model_r2_rf.write().overwrite().save("project/models/modelRF_r2")
# Run it from root directory of the repository
run("hdfs dfs -get project/models/modelRF_r2 models/modelRF_r2")

predictions_rmse_lr = model_rmse_lr.transform(test_data)
predictions_r2_lr = model_r2_lr.transform(test_data)
predictions_rmse_rf = model_rmse_rf.transform(test_data)
predictions_r2_rf = model_r2_rf.transform(test_data)
# predictions.show()

predictions_rmse_lr.select("time_taken", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/modelLR_predictionsRMSE")
predictions_r2_lr.select("time_taken", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/modelLR_predictionsR2")
predictions_rmse_rf.select("time_taken", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/modelRF_predictionsRMSE")
predictions_r2_rf.select("time_taken", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/modelRF_predictionsR2")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/modelLR_predictionsRMSE/*.csv >\
    output/modelLR_predictionsRMSE.csv")
run("hdfs dfs -cat project/output/modelLR_predictionsR2/*.csv >\
    output/modelLR_predictionsR2.csv")
run("hdfs dfs -cat project/output/modelRF_predictionsRMSE/*.csv >\
    output/modelRF_predictionsRMSE.csv")
run("hdfs dfs -cat project/output/modelRF_predictionsR2/*.csv >\
    output/modelRF_predictionsR2.csv")

# Evaluate the performance of the model
evaluator1 = RegressionEvaluator(labelCol="time_taken",
                                 predictionCol="prediction",
                                 metricName="rmse")
rmse_lr = evaluator_rmse.evaluate(predictions_rmse_lr)
r2_lr = evaluator_r2.evaluate(predictions_r2_lr)
rmse_rf = evaluator_rmse.evaluate(predictions_rmse_rf)
r2_rf = evaluator_r2.evaluate(predictions_r2_rf)

print(f"Root Mean Squared Error (RMSE) of best LR on test data = {rmse_lr}")
print(f"R2 score of best LR on test data = {r2_lr}")
print(f"Root Mean Squared Error (RMSE) of best RF on test data = {rmse_rf}")
print(f"R2 score of best LR on test data = {r2_rf}")


# Create data frame to report performance of the models
models = [[str(bestModel_rmse_lr), rmse_lr, r2_lr],
          [str(bestModel_rmse_rf), rmse_rf, r2_rf]]

# temp = list(map(list, models.items()))
df = spark.createDataFrame(models, ["model", "RMSE", "R2"])
df.show(truncate=False)
# temp

# Save it to HDFS
df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header", "true")\
    .save("project/output/evaluation")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/evaluation/*.csv >\
    output/evaluation.csv")
