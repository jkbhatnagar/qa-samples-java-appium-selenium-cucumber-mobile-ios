# Mobile Automation - Java - Appium - Selenium - Cucumber - Extent Reports

## USAGE
    
### Pre-requisites:
 - java version 13, jdk version 13, maven (optional), internet access
 - Python

        brew install python3

 - Carthage

        sudo chown -R $(whoami) /usr/local/share/man/man5 /usr/local/share/man/man7
        chmod u+w /usr/local/share/man/man5 /usr/local/share/man/man7
        
        brew install carthage
        open ~/.bash_profile
        export PATH=$PATH:/usr/local/bin/carthage
        source ~/.bash_profile
        echo $PATH

 - Appium

        npm init
        sudo npm install -g appium --unsafe-perm=true --allow-root
        sudo npm install appium-doctor -g
        appium-doctor --ios
        appium --address 127.0.0.1 --port 4723

- Sample Capability for iOS

        {
          "platformName": "iOS",
          "platformVersion": "12.4.1",
          "automationName": "XCUITest",
          "udid": "32507487e3b0a86158bb5e4d3da6d861d00f6b61",
          "deviceName": "Jatin's iPhone",
          "app": "/Users/jatin/projects/automation/appium/appium-ios-auto/apps/Rates.ipa",
          "useNewWDA": true,
          "xcodeOrgId": "CHP25BGU6A",
          "xcodeSigningId": "iPhone Developer"
        }

### Run Locally:
 - Download or clone the 'master' branch locally. Open Terminal and "cd" to branch directory.
 - Run all TCs : Running locally without installing maven : 
 
     ```./mvnw clean test -Dcucumber.options="--tags @RegressionTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs"```
 
 - Run all TCs : Running locally from local maven installation: 
 
    ```mvn clean test -Dcucumber.options="--tags @RegressionTest --plugin com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:output --glue stepdefs"```

### Reports:
 - Extent report is generated at testreport/HtmlReport/ExtentHtml.html
 - Report provides detailed scenarios and step execution summary, with passed - failed - skipped results

### Maintenance:
- Don't change RunCucumberTest, extent.properties, extent-config.xml
- Add global constants to src/test/java/utils/UtilConstants.
- Add new Cucumber feature files to src/test/features.
- Add new Step Definition files to src/test/java/stepdefs.
- Add page objects to src/test/java/pages.

## TASK LIST

### Completed
- [x] Add Cucumber support
- [x] Add Cucumber Table support
- [x] Add Selenium support
- [x] Add Extent Report support
- [x] Use Cucumber @Tags to categorize Test Scenarios into @SmokeTest and @RegressionTest
- [x] Read constants and globals from Constants.java or a .properties file

### Pending
- [ ] Add Selenium grid support
- [ ] Add AWS Device Farm Support
- [ ] Add more Test scenarios and negative checks and failed TCs.
- [ ] Add more descriptive comments.
- [ ] Export json and extent reports to S3 buckets.
- [ ] Clear App cache
- [ ] Change App settings
- [ ] Add screenshots for execution and attach to report
- [ ] Use cucumber-picocontainer to add Dependency Injection to share in-flight test objects between test cases
- [ ] Split Step definition and feature for different services to separate files
- [ ] Add assertion failure comments (if required)
- [ ] Generate a log file
- [ ] Use YAML or Properties file based test data
- [ ] Add test data in Cucumber steps as "Example" and then use <placeholder> tags to avoid repeating same data in Given and Then (must if reading data from external file)
- [ ] Add Environment changer so that same code and assertions can be used with different data for different Test Environments (SIT/UAT/PROD)

        https://www.coveros.com/using-dependency-injectors-simplify-code-cucumber/
        http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer

- Move common tasks and assertions to utility class

## RESOURCE REFERENCES
- Cucumber base

    - https://github.com/cucumber/cucumber-java-skeleton
    - https://www.toolsqa.com/cucumber/cucumber-hooks/
    - https://www.toolsqa.com/cucumber/execution-order-hooks/
    - https://www.toolsqa.com/cucumber/background-in-cucumber/

- Samples

     - https://github.com/angiejones/restassured-with-cucumber-demo
     - https://github.com/raghwendra-sonu/REST-assured_Cucumber

- References

    - https://medium.com/rpdstartup/running-automated-tests-on-aws-devicefarm-in-custom-environment-934d4ab41f28
    
    - https://medium.com/onefootball-locker-room/distributed-parallel-execution-of-appium-tests-with-selenium-grid-4c29b8600baf
    
    - http://appium.io/docs/en/advanced-concepts/grid/
    
    - http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/