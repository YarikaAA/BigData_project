USE team18_projectdb;

DROP TABLE IF EXISTS ml_results1;

CREATE EXTERNAL TABLE ml_results1(
  model VARCHAR(50),
  RMSE FLOAT,
  R2 FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
LOCATION '/user/team18/project/results/';

LOAD DATA INPATH '/user/team18/project/data/evaluation_others.csv' OVERWRITE INTO TABLE ml_results1;

SELECT * FROM ml_results1;
