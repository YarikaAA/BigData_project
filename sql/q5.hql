USE team18_projectdb;

DROP TABLE IF EXISTS q5_results;

CREATE EXTERNAL TABLE q5_results(time_taken INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'user/team18/project/hive/warehouse/q5'; 

USE team18_projectdb;

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT time_taken FROM food_delivery;

SELECT * FROM q4_results;