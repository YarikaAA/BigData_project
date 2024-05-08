USE team18_projectdb;

DROP TABLE IF EXISTS q4_results;

CREATE EXTERNAL TABLE q4_results(distance FLOAT, time_taken INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'user/team18/project/hive/warehouse/q4'; 

USE team18_projectdb;

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
SELECT ROUND(SQRT(POW((restaurant_latitude - delivery_location_latitude), 2) + POW((restaurant_longitude - delivery_location_longitude), 2)), 4) as distance, time_taken FROM food_delivery;

SELECT distance, time_taken FROM q4_results WHERE distance > 0;