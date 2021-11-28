# Papaya Pay - Android Automation POC
This is a POC example of how we can use Appium to test a native Android App.

## Suites
There is only one suite which is compromised of 1 data-driven test that uses 2 different sets of inputs.
1. capture a non-medical bill and pay
2. capture a medical bill and pay

## Installation
1. Configure an AVD with Android studio; recommended version 10 as I've seen periodic issues with version 11
2. Confirm that ANDROID_HOME is set, as to seed the test images into AVD this path is required
3. Install Appium and make sure that the server is running
4. Make sure the Papaya Pay android app is installed on your AVD

## Run Instructions
1. Clone down this repo
2. Execute the tests, there are different ways to run them
   1. 
