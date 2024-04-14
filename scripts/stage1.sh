#!/bin/bash
mkdir ../data/

# Download the data from Yandex Disk
wget "$(yadisk-direct 'https://disk.yandex.com/d/IbqajjuvJ93o3A')" -O ../data/archive.zip

# Unzip the downloaded file
unzip ../data/archive.zip  -d ../data/

# Clean up by removing the extracted directory and the original ZIP file
rm ../data/archive.zip

python build_projectdb.py