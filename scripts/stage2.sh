#!/bin/bash

# set password
password=$(head -n 1 ../../secrets/.psql.pass)

# create warehouse directory in hdfs if not exists and put avsc files
hdfs dfs -mkdir -p /user/team18/project/warehouse/avsc
hdfs dfs -put *.avsc /user/team18/project/warehouse/avsc

# run db.hql and save the output to hive_results.txt
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/db.hql > ../output/hive_results.txt

# run q1.hql, q2.hql, q3.hql, q4.hql, q5.hql
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/q1.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q1.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/q2.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q2.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/q3.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q3.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/q4.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q4.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team18 -p $password -f ../sql/q5.hql --hiveconf hive.resultset.use.unique.column.names=false > ../output/q5.csv

# quality rate hive_exec.py
pylint hive_exec.py