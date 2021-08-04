# Team16_Capstone
This is a smartphone app design for personalized cancer symptom management. This application alerts users when it is time for their light therapy sessions, helping them more easily stick to a routine that works for them. Patient light therapy data, which includes therapy frequency and duration, is written from the app to a database that researchers from Michigan State University's College of Nursing can access.

![Visor Design](https://github.com/jkal90/Team16_Capstone/blob/44509c984a5c2b07154f853dfebe43d4ba560c9d/Visor%20Design.JPG)

The goal of this project is to design a smartphone application to help monitor and enhance observation of the prescribed light therapy. The application will be programmed for the time of the day the individual is advised to receive the light therapy. A text reminder will be sent through the app at the advised time of the day to notify the user. Real-time data will be provided by a timer that records start and end times of each light therapy session. If the user does not respond within 10 minutes of the advised time, a second text reminder will be sent, and if the user does not respond within 10 minutes of the second reminder, an alert message will be sent. This smartphone app will be programmed to notify and allow the user to record sleep/wake times, naptimes, and levels of fatigue each night for a pre-set timeframe. All the data collected by the application will be sent and stored in a server for future reference. This smartphone application will replace the previously used paper-pencil daily log.

*Development software used:*

The operating system used for the app is Android 11 and was designed using Android Studio. The backend was written using mostly Java 8 and the front end will be written using XML.  Information gathered by the app will be stored in a database hosted by the Michigan State University department of computer science.

## Program Classes:
![class diagram](https://github.com/jkal90/Team16_Capstone/blob/d7039b2863c8670ba3b7a60f2f141018c1c91958/Class%20diagram.JPG)

### Main Activity

This is the screen of the app when lauched.  Each of the icons and the text below them serve as buttons that redirect to other pages.

### Database Tool

This class is responsible for all internet-based activities in the app.  It contains methods for writing to the various database tables and verifying the legitimacy of the user.  Anytime responses are detected from the other question pages in the app, a DatabaseTool will be created and the appropriate write method is called.  The methods generate the correct HTTP link to store the data and then performs the HTTP request.  The tool is constructed around the preferences of the user, since instances of the class need to know the user_id and birthday of the user to verify whether the user is legitimate.

### Help Activity

This class represents the screen that is visible after selecting the "help" icon on the home screen.  Once you click on the help button off the home screen, you will be prompted three buttons. One button labeled "Introduction Video" will lead you to an Introduction Video provided by the College of Nursing. The second button labeled "How To Video" will lead you to a How to Video provided by the College of Nursing. Lastly, there is a "Back To Home" button that will take you back to the Home Screen.

### My Info Activity

This class represents the screen that is visible after selecting the "my info" icon on the home screen.  This page will show the user his or her unique id number, and have a button to enter a new id number, if his or her current one is incorrect.

### Bedtime Questions Activity

This class holds the questions that the user must complete before going to sleep at night.  Upon clicking submit, the class will create a DatabaseTool and store the responses in the database.

### Nap Questions Activity

This class holds the questions that the user must complete regarding his or her naps.  Upon clicking submit, the class will create a DatabaseTool and store the responses in the database.

### Wake Up Questions Activity

This class holds the questions that the user must complete upon waking up in the morning.  Upon clicking submit, the class will create a DatabaseTool and store the responses in the database.

### Notification Receiver

This class creates the notification that shows on the user's device at the time specified by the user.

### ReEnter Activity

This class contains the screen that informs users that they must re-enter their id and birthday, as the current entry is invalid.

### Reminder Activity

The reminder alert function is reliable and effectively notifies the user for when light therapy should be administered. The reminder function must reliably send a second notification if the app user does not respond to the first notification within 10 minutes. The graphical user interface (GUI) is easy to navigate and understand. The app should allow the patient to record sleep/wake times, naptimes, and levels of fatigue each night for a pre-set timeframe. The user input data should be stored on a database that is easy to access by the user/care provider

![Reminder Activity Framework](https://github.com/jkal90/Team16_Capstone/blob/8eaaa36056bb4524040992ffe14bb2ca9b5e8e0c/Reminder%20Framework.JPG)


### Repeating Activity

This screen is the screen shown when the notification is interacted with

### SetID Activity

This screen is the screen in which the user enters his or her id and birthday.

### Start Timer Activity

This screen has the timer.  It contains options for the user to pause the timer and end the session early if desired.

### Thank You Activity

This screen is shown after a submission has been successfully logged.  It has a button to return to the home screen of the app.

## User Interface

The user interface was designed with the target user in mind. Typical users of this app will most often be cancer patients, who will be suffering from fatigue, nausea, and other cancer-related symptoms. For this, ease of use was our top priority. The application's graphical user interface (GUI) incorporates large buttons, simple navigation paths, and limited input options, specific to the user entry fields.

![User Interface Description](https://github.com/jkal90/Team16_Capstone/blob/44509c984a5c2b07154f853dfebe43d4ba560c9d/UI.JPG)

## Data extraction for healthcare providers

The app writes to the database using a PHP script run through a student CSE Webdev account. None of the database information will need to be stored on the app or local storage, it will all be stored in the cloud. This is done to enhance security to mitigate source code being stored on apps across devices. The medical professionals will have a Python script that retrieves the data from the database and writes it to a CSV. This is also done by accessing the database through PHP.

### Python script for pulling data from a cloud-based .csv file into MS Excel

The python script **patient_data_getter.py** will be stored in a file location which is convenient to the healthcare provider. As long as the healthcare provider has the required software installed, they can generate Excel files with the necessary patient data. The Excel files will be created in the same file location that the **patient_data_getter.py** is saved in.

### Extracted database file format

A seperate Excel file is automatically generated for each database table that exists within the application. For example, a seperate Excel file will be generated for the bedtime questionnaire, the nap time questionnaire, the wake-up questionnaire, and timer usage.

### Required Software:

- .csv
- python
- MySQL Workspace
- MySQL Python Connector

### Install Python 3.7.9
Python 3.7.9 can easily be installed by visiting the link: https://www.python.org/downloads/release/python-379/
Choose from the following installer files that best suits your operating system and click through the easy to follow steps in the installation wizard:
![python 3.7.9](https://github.com/jkal90/Team16_Capstone/blob/bd88ce00d4ab12be2819d774233c7867a86cfb24/python379.JPG)

### Installing software from PowerShell terminal

1. Open Windows Powershell from the windows start menu
2. From command line enter the following commands

```
> mkdir patient_light_therapy [enter] 
# This creates a folder directory named "patient_light_therapy"

> cd .\patient_light_therapy\ [enter]
# This navigates you into the folder you had just created

> pip3 install mysql [enter]
> pip3 install mysql-connector [enter]
> pip3 install mysql-connector-python3 [enter]
> pip3 install requests [enter]
# You have now installed all the required software to run the patient_data_getter.py script
```

### Download the script

1. Open the following link: https://github.com/MaHuCS/PatientDataGetter
2. Download script by selecting the green "Code" button in the upper right and then selecting "Download ZIP"
![Screenshot of Download ZIP](https://github.com/jkal90/Team16_Capstone/blob/master/GithubScreenshot.png)

3. Extract the **patient_data_getter.py** from the ZIP and add it to the new folder you created
4. Now you may exit the windows powershell terminal and navigate to the folder you have created in the file explorer
5. You should see the script named **patient_data_getter.py**. To run the python script and generate excel files with the patient light therapy data, double-click **patient_data_getter.py** to run. The excel files should be generated in the same file location.

![patient data getter](https://github.com/jkal90/Team16_Capstone/blob/c4bee5952066fa59a2caf5a966f00a4b5a1489ea/patient_data_getter.jpg)

### How to Install App

**Download Android Studio**

First you need to make sure you have Android Studio Installed on your computer. Android Studio can be downloaded from the following link: https://developer.android.com/studio/?gclid=EAIaIQobChMIrpXjhvKS8AIViWtvBB06uAe9EAAYASAAEgJvo_D_BwE&gclsrc=aw.ds
![Android Studio download](https://github.com/jkal90/Team16_Capstone/blob/03ebb46d8923315c899568eb30cea44c938fd27b/ASdownload.JPG)

**Download Light Therapy Smartphone Application**

Download the app from the link using an Android device: https://github.com/MaHuCS/LightTherapyLog


1. Download the APK from the link – you should then be able to see it downloading on the top bar of your device
2. Once it's downloaded, open Downloads, tap on the APK file, and tap Yes when prompted
3. The app will begin installing on the device

### Development

**MySQL**

The following statements must be run on the new database:

CREATE TABLE bedtime_questions (submit_time TEXT, bedtime TEXT, fatigue_level INTEGER, sleepiness_level INTEGER, user_id INTEGER);

CREATE TABLE nap_questions (submit_time TEXT, nap_taken TEXT, first_nap_start TEXT, first_nap_end TEXT, second_nap_start TEXT, second_nap_end TEXT, third_nap_start TEXT, third_nap_end TEXT, user_id INTEGER);

CREATE TABLE wakeup_questions (submit_time TEXT, time TEXT, difficulty_sleeping TEXT, waking_up_during TEXT, woke_up_early TEXT, user_id INTEGER);

CREATE TABLE timer_usage (start_time TEXT, end_time TEXT, user_id INTEGER);

CREATE TABLE users (user_id INTEGER,  birthday TEXT);

The college of nursing must provide a list of the user IDs and all of the users’ birthdays to be stored in the database.  These must be inserted into the “users” table for that app to work properly.

**PHP**

Change the database information in all of the .php files to match the new database information
