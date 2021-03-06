'''
RUNNING THIS FILE WILL CLEAR ALL DATA IN ALL DATABASE TABLES
THIS IS MEANT TO BE USED FOR TESTING ONLY
'''

import mysql.connector
import pymysql
import csv

COL_HEADERS = { "wakeup_questions": 
["Wake-Up Time", "Difficulty Sleeping", "Waking Up During Night", "Woke Up Too Early", "User ID"],
"nap_questions": 
["Did you wake up during the day?", "1st Nap Start",
"1st Nap End", "2nd Nap Start", "2nd Nap End", "3rd Nap Start", "3rd Nap End", "User ID"],
"bedtime_questions": 
["Bed Time", "24-Hour Fatigue Level:", "Average Level of Sleepiness:", "User ID"] }

def get_connection():
    connection = pymysql.connect(host="mysql-user.cse.msu.edu",
        user="huangmax",
        passwd="A56081598",
        database="huangmax")
    return connection

def main():
    connection = get_connection()
    cursor = connection.cursor()
    for key in COL_HEADERS:
        query = "DELETE FROM " + key
        cursor.execute(query)
    connection.commit()
    connection.close()

main()