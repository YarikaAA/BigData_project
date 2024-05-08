USE team18_projectdb;

DROP TABLE IF EXISTS q2_results;

CREATE EXTERNAL TABLE q2_results(id VARCHAR(10), type_of_order VARCHAR(20), time_taken INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'user/team18/project/hive/warehouse/q2'; 

USE team18_projectdb;

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT id, type_of_order, time_taken 
FROM food_delivery ORDER BY time_taken ASC;

SELECT * FROM q2_results;
