import mysql.connector
import csv
import requests

COL_HEADERS = { "wakeup_questions": 
["Submit Date", "Submit Time", "Wake-Up Time", "Difficulty Sleeping", "Waking Up During Night", "Woke Up Too Early", "User ID"],
"nap_questions": 
["Submit Date", "Submit Time", "Did you take a nap during the day?", "1st Nap Start",
"1st Nap End", "2nd Nap Start", "2nd Nap End", "3rd Nap Start", "3rd Nap End", "User ID"],
"bedtime_questions": 
["Submit Date", "Submit Time", "Bed Time", "24-Hour Fatigue Level:", "Average Level of Sleepiness:", "User ID"],
"timer_usage":
["Start Date", "Start Time", "End Date", "End Time", "User ID"] }

BASE_REQUEST = 'https://webdev.cse.msu.edu/~rumptzja/ece480/ece480app/retrieve_data.php?table='

def main():
    for table in COL_HEADERS:
        query = BASE_REQUEST + table
        req = requests.get(query)
        response = req.text
        if response == "Failed":
            print("Failed to retrieve from table ", table)
            continue
        response = response.split('\n')
        response.pop()
        for i in range(len(response)):
            response[i] = response[i].split('|')
            response[i].pop()
        if table == 'timer_usage':
            for i in range(len(response)):
                response[i] += [None, None]
                response[i][4] = response[i][2]
                splitter = response[i][1].split()
                response[i][2], response[i][3] = splitter[0], splitter[1]

                splitter = response[i][0].split()
                response[i][0], response[i][1] = splitter[0], splitter[1]
        else:
            for i in range(len(response)):
                response[i] += [None]
                for j in range(len(response[i]) - 1, 1, -1):
                    response[i][j] = response[i][j - 1]
                splitter = response[i][0].split()
                response[i][0], response[i][1] = splitter[0], splitter[1]
                print(response)
        filename = "TABLE" + table + ".csv"
        with open(filename, 'w', newline='') as csvfile:
            csvwriter = csv.writer(csvfile)
            csvwriter.writerow(COL_HEADERS[table])
            csvwriter.writerow([])
            csvwriter.writerows(response)

main()
