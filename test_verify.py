import mysql.connector
import csv
import requests


BASE_REQUEST = 'https://webdev.cse.msu.edu/~rumptzja/ece480/ece480app/verify_user.php?user_id=4&birthday=\"7/14/1999\"'

def main():
    query = BASE_REQUEST
    req = requests.get(query)
    response = req.text
    print(response)
    print(len(response))

main()
