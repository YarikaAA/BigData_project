#!/bin/bash
# create data directory if not exists
mkdir -p ../data/

# Download the data from Yandex Disk
wget "$(yadisk-direct 'https://disk.yandex.com/d/IbqajjuvJ93o3A')" -O ../data/archive.zip

# Unzip the downloaded file
unzip ../data/archive.zip  -d ../data/

# Clean up by removing the extracted directory and the original ZIP file
rm ../data/archive.zip

# run build_projectdb
python build_projectdb.py

# set password
password=$(head -n 1 ../../secrets/.psql.pass)

sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team18_projectdb \
 --username team18 --password $password --compression-codec=snappy --compress --as-avrodatafile \
 --warehouse-dir=../output --m 1
 
# quality rate build_projectdb.py
pylint build_projectdb.py