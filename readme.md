# Papaya Pay - Android Automation POC
This is a POC example of how we can use Appium to test a native Android App with a single base scenario.

We are specifically testing functionality where the built-in camera is used without any vendor-specific code.

## Features
Although we are only supporting 2 related tests, the current code supports the following:
1. Pre-setup to deal with the AVD camera. There are provider specific implementations (e.g. saucelabs, etc) that handle this differently, this would likely reliably work on ci/cd but may require a little tweaking.
2. semi-customized so it would be relatively easy to support IOS locators and platform, if needed
3. logging and listeners to output status of tests
4. page object model pattern with separate validation classes where appropriate

## Suites / Scenarios
There is only one suite which is compromised of 1 data-driven test that uses 2 different sets of inputs.
1. capture a non-medical bill, add payment, and pay
2. capture a medical bill, add payment, and pay

## Installation
1. Configure an AVD with Android studio; recommended version 10 as I've seen periodic issues with version 11
2. Confirm that ANDROID_HOME is set, as to seed the test images into AVD this path is required
3. Install Appium and make sure that the server is running

## Run Instructions
1. Clone down this repo
2. You can run these tests in a bunch of different ways.
   1. Via Maven <--- This is the preferred option
      1. Run `mvn test -DdeviceName=<your device here> -Dudid=<your udid here> -DplatformVersion=<your version here>`
         NOTE: Make sure to replace the parameters with your actual info
   2. Via IDE (e.g. Intellij)
      1. Add your deviceName and UDID for your device into E2E.xml under "suites"
      2. Right click to run the suite

## Known Issues
1. The AVD image setting has not been tested on multi-platform, should work on MacOS but possibly not on Linux or Docker
