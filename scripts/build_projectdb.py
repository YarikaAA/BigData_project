""" This script creates the project database and imports data into it. """

import os
import io
from pprint import pprint
import psycopg2 as psql

# Read password from secrets file
password_file = os.path.join("..", "..", "secrets", ".psql.pass")

with io.open(password_file, "r", encoding='utf-8') as file:
    password = file.read().rstrip()

# Build connection string
CONN_STRING = "host=hadoop-04.uni.innopolis.ru port=5432 user=team18 \
                    dbname=team18_projectdb password=" + str(password)

# Connect to the remote DBMS
with psql.connect(CONN_STRING) as conn:
    cur = conn.cursor()

    # Execute SQL commands to create tables
    with io.open(os.path.join("..", "sql", "create_tables.sql"), encoding='utf-8') as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    # Import data into the database
    with io.open(os.path.join("..", "sql", "import_data.sql"), encoding='utf-8') as file:
        command = file.readlines()[0].strip()
        with io.open(os.path.join("..", "data", "deliverytime.csv"), "r",
                     encoding='utf-8') as deliv:
            cur.copy_expert(command, deliv)
    conn.commit()

    pprint(conn)

    # Test the database
    with io.open(os.path.join("..", "sql", "test_database.sql"), encoding='utf-8') as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command.strip())
            pprint(cur.fetchall())
