#!/bin/bash

spark-submit --master yarn scripts/model.py

# uncomment to save models
# hdfs dfs -copyToLocal project/models/modelLR_rmse models/modelLR_rmse
# hdfs dfs -copyToLocal project/models/modelLR_r2 models/modelLR_rmse
# hdfs dfs -copyToLocal project/models/modelRF_rmse models/modelLR_rmse
# hdfs dfs -copyToLocal project/models/modelRF_r2 models/modelLR_rmse

# quality rate hive_exec.py
pylint scripts/model.py