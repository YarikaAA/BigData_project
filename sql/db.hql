SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;
SET hive.execution.engine=tez;

DROP DATABASE IF EXISTS team18_projectdb CASCADE;

SHOW DATABASES;

CREATE DATABASE team18_projectdb LOCATION "/user/team18/project/hive/warehouse";

USE team18_projectdb;

SHOW DATABASES;

CREATE EXTERNAL TABLE food_delivery STORED AS AVRO LOCATION '/user/team18/project/warehouse/food_delivery' TBLPROPERTIES ('avro.schema.url'='/user/team18/project/warehouse/avsc/food_delivery.avsc');

SHOW TABLES;

describe food_delivery;


CREATE EXTERNAL TABLE fd_part(id VARCHAR(10), delivery_person_id VARCHAR(20), delivery_person_age INTEGER, delivery_person_ratings float, restaurant_latitude float, restaurant_longitude float, delivery_location_latitude float, delivery_location_longitude float, type_of_vehicle VARCHAR(50), time_taken INT) PARTITIONED BY (type_of_order VARCHAR(20)) STORED AS AVRO LOCATION '/user/team18/project/hive/warehouse/food_delivery_part' TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');


CREATE EXTERNAL TABLE fd_part_buck(id VARCHAR(10), delivery_person_id VARCHAR(20), delivery_person_age INTEGER, delivery_person_ratings FLOAT, restaurant_latitude FLOAT, restaurant_longitude FLOAT, delivery_location_latitude FLOAT, delivery_location_longitude FLOAT, type_of_vehicle VARCHAR(50), time_taken INT)
PARTITIONED BY (type_of_order VARCHAR(20))
CLUSTERED BY (delivery_person_id) INTO 10 BUCKETS
STORED AS AVRO
LOCATION '/user/team18/project/hive/warehouse/food_delivery_part_buck'
TBLPROPERTIES ('avro.output.codec'='snappy');

describe fd_part;
describe fd_part_buck;

INSERT overwrite TABLE fd_part PARTITION (type_of_order)
SELECT id, delivery_person_id, delivery_person_age, delivery_person_ratings, restaurant_latitude, restaurant_longitude, delivery_location_latitude, delivery_location_longitude, type_of_vehicle, time_taken, type_of_order FROM food_delivery;

    
INSERT INTO fd_part_buck 
SELECT id, delivery_person_id, delivery_person_age, delivery_person_ratings, restaurant_latitude, restaurant_longitude, delivery_location_latitude, delivery_location_longitude, type_of_vehicle, time_taken, type_of_order FROM food_delivery;