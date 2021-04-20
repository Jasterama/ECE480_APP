# Team16_Capstone
This is a smartphone app design for personalized cancer symptom management. This application alerts users when it is time for their light therapy sessions, helping them more easily stick to a routine that works for them. Patient light therapy data, which includes therapy frequency and duration, is written from the app to a database that researchers from Michigan State University's College of Nursing can access.

![Visor Design](https://github.com/jkal90/Team16_Capstone/blob/44509c984a5c2b07154f853dfebe43d4ba560c9d/Visor%20Design.JPG)

The goal of this project is to design a smartphone application to help monitor and enhance observation of the prescribed light therapy. The application will be programmed for the time of the day the individual is advised to receive the light therapy. A text reminder will be sent through the app at the advised time of the day to notify the user. Real-time data will be provided by a timer that records start and end times of each light therapy session. If the user does not respond within 10 minutes of the advised time, a second text reminder will be sent, and if the user does not respond within 10 minutes of the second reminder, an alert message will be sent. This smartphone app will be programmed to notify and allow the user to record sleep/wake times, naptimes, and levels of fatigue each night for a pre-set timeframe. All the data collected by the application will be sent and stored in a server for future reference. This smartphone application will replace the previously used paper-pencil daily log.

## Program Classes:
![class diagram](https://github.com/jkal90/Team16_Capstone/blob/d7039b2863c8670ba3b7a60f2f141018c1c91958/Class%20diagram.JPG)

### Main Activity

### Database Tool

### Help Activity

### My Info Activity

### Bedtime Questions Activity

### Nap Questions Activity

### Wake Up Questions Activity

### Notification Receiver

### ReEnter Activity

### Reminder Activity
![Reminder Activity Framework](https://github.com/jkal90/Team16_Capstone/blob/8eaaa36056bb4524040992ffe14bb2ca9b5e8e0c/Reminder%20Framework.JPG)


### Repeating Activity

### SetID Activity

### Start Timer Activity

### Thank You Activity

## User Interface

The user interface was designed with the target user in mind. Typical users of this app will most often be cancer patients, who will be suffering from fatigue, nausea, and other cancer-related symptoms. For this, ease of use was our top priority. The application's graphical user interface (GUI) incorporates large buttons, simple navigation paths, and limited input options, specific to the user entry fields.

![User Interface Description](https://github.com/jkal90/Team16_Capstone/blob/44509c984a5c2b07154f853dfebe43d4ba560c9d/UI.JPG)

## Data Extraction

The app writes to the database using a PHP script run through a student CSE Webdev account. None of the database information will need to be stored on the app or local storage, it will all be stored in the cloud. This is done to enhance security to mitigate source code being stored on apps across devices. The medical professionals will have a Python script that retrieves the data from the database and writes it to a CSV. This is also done by accessing the database through PHP.

### Required Software:

- .csv
- python
- MySQL Workspace
- MySQL Python Connector

### Python script for pulling data from a cloud-based .csv file into MS Excel

The python script **patient_data_getter.py** will be stored in a file location which is convenient to the healthcare provider. As long as the healthcare provider has the required software installed, they can generate Excel files with the necessary patient data. The Excel files will be created in the same file location that the **patient_data_getter.py** is saved in.

### Extracted database file format

A seperate Excel file is automatically generated for each database table that exists within the application. For example, a seperate Excel file will be generated for the bedtime questionnaire, the nap time questionnaire, the wake-up questionnaire, and timer usage.
