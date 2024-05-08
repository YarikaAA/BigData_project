-- the query q1
USE team18_projectdb;
SELECT id, delivery_person_id, delivery_person_ratings, time_taken 
FROM food_delivery ORDER BY time_taken ASC;

-- the query q2
USE team18_projectdb;

DROP TABLE IF EXISTS q1_results;

CREATE EXTERNAL TABLE q1_results(id VARCHAR(10), delivery_person_id VARCHAR(20), delivery_person_ratings FLOAT, time_taken INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'user/team18/project/hive/warehouse/q1'; 

USE team18_projectdb;

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT id, delivery_person_id, delivery_person_ratings, time_taken 
FROM food_delivery ORDER BY time_taken ASC;

SELECT * FROM q1_results;
