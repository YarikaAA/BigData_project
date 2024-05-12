#!/bin/bash

password=$(head -n 1 ../../secrets/.psql.pass)

hdfs dfs -put ../output/evaluation_others.csv /user/team18/project/data/evaluation_others.csv
# hadoop fs -put ./AllstarFull.csv /user/bigdataproject/AllstarFull.csv
# hive -f ./AllstarFull.hive
# hive -f ./AllstarFull.hive

# sed 's/"//g' /user/team18/project/data/evaluation_others.csv > /user/team18/project/data/evaluation_others_clean.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/ml_results1.hql
# echo "model, rmse, r2" > ../output/ml_results1.csv 
# hdfs dfs -cat project/output/q1/* >> ../output/ml_results1.csv