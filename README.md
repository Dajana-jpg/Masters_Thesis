# Appium Java Selenium README
Training Helper application > project for running tests using Java/TestNG/Appium 

## Setting up 
### Prerequisites before running the script for Appium setup 
* Set `JAVA_HOME` as an environment variable

* Set `ANDROID_HOME` as an environment variable - pointing to the directory where Android SDK should be setup

## Running the tests
### Prerequisites:
* Start appium server manually (and update the url/port if not using the default)
* Have devices connected / emulators started. Accordingly, update the (.*Test.java) test file with the relevant information about the devices

### Tests
This project includes the following tests implemented for Android devices:

#### Android
> Test classes:
* src/test/java/com/radic/masterthesis/sample/android/PlayersTest/FunctionalTestPlayers.java - Tests regarding Players screen.
* src/test/java/com/radic/masterthesis/sample/android/PlayersTest/SmokeTestPlayers.java - Tests regarding Players screen.
* src/test/java/com/radic/masterthesis/sample/android/SurveyListTest/FunctionalTestSurvey.java - Tests regarding Survey screen.
* src/test/java/com/radic/masterthesis/sample/android/SurveyListTest/SmokeTestSurvey.java - Tests regarding Survey Screen.
* src/test/java/com/radic/masterthesis/sample/android/TeamStatsTest/FunctionalTestTeamStats.java - Tests regarding Team statistics screen
* src/test/java/com/radic/masterthesis/sample/android/TeamStatsTest/SmokeTestTeamStats.java - Tests regarding Team statistics screen

  > Helper classes:
  * src/test/java/com/radic/masterthesis/sample/android/Declaration.java - Declaration helper class
  * src/test/java/com/radic/masterthesis/sample/android/Message.java - Message helper class
  * src/test/java/com/radic/masterthesis/sample/android/TestManager.java - Test Manager helper class
> Test data:
* src/test/java/com/radic/masterthesis/sample/android/DataProvider/PlayerProvider.java
* src/test/java/com/radic/masterthesis/sample/android/DataProvider/SurveyProvider.java
* src/test/java/com/radic/masterthesis/sample/android/DataProvider/TeamStatsProvider.java
 
## Starting with the project

* first step is 
      > npm install
      > setup configuration files or environment variables
      > uploading pom.xml dependencies
      > build project
      > run a test

  
## About the project

> Important directories

![image](https://github.com/Dajana-jpg/Masters_Thesis/assets/80062808/7fc48215-4f50-43d3-b9aa-748c983f5a54)



* android -> the most important package. Has all the tests and helper classes in itself.
* resources > TestNG file which has the test execution organized. It is linked within pom.xml file and determines how the tests should run when started by maven clean test.
* pom.xml > contains dependencies

  ## Additional notes
  ![image](https://github.com/Dajana-jpg/Masters_Thesis/assets/80062808/1e8ee48a-c637-4cf9-a1f0-9916646b4456)
  * String udid is physical device. The information on this number can be found from person's own device by:
>Downloading Device info application on the phone to test with
>>Android Device ID number = udid

>If not, an emulator is a second good choice -> Android Studio

