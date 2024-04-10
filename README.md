# Appium Java Selenium README
Training Helper application > project for running tests using Java/TestNG/Appium 

## Setting up 
### Prerequisites before running the script for Appium setup 
* Set `JAVA_HOME` as an environment variable

* Set `ANDROID_HOME` as an environment variable - pointing to the directory where Android SDK should be setup

* Execute the following scripts to setup your Mac [setup_mac.sh](setup_mac.sh) or Ubuntu [setup_linux.sh](setup_linux.sh) machine automatically 
> The above script will install all dependencies required for implementing / running tests on Android devices. To do the setup for iOS devices, run `appium-doctor` and see the list of dependencies that are missing, and install the same.

> You may be prompted for password or confirmations along the way 

## Running the tests
### Prerequisites:
* Start appium server manually (and update the url/port if not using the default)
* Have devices connected / emulators started. Accordingly, update the (.*Test.java) test file with the relevant information about the devices

### Tests
This project includes the following tests implemented for Android & iOS devices:

#### Android
* [AppiumNativeAndroidMessagesTest.java](src/test/java/com/eot/sample/android/AppiumNativeAndroidMessagesTest.java) - run an Appium test against the Messages app
* [AppiumNativeAndroidParallelCalcTest.java](src/test/java/com/eot/sample/android/AppiumNativeAndroidParallelCalcTest.java) - run 2 Appium tests, in parallel, using testng
* [AppiumWebAndroidHelloWorldTest.java](src/test/java/com/eot/sample/android/AppiumWebAndroidHelloWorldTest.java) - runs an appium test against a Chrome browser (mobile-web) in the connected device

#### iOS
* [AppiumNativeiOSHelloWorldTest.java](src/test/java/com/eot/sample/ios/AppiumNativeiOSHelloWorldTest.java) - run an Appium test against the Messages app
* [AppiumWebiOSHelloWorldTest.java](src/test/java/com/eot/sample/ios/AppiumWebiOSHelloWorldTest.java) - run 2 Appium tests, in parallel, using testng

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

