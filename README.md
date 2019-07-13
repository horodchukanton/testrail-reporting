# Overview

Testrail-reporting is a library that provides a common and simplified way of sending results to [TestRail](https://www.gurock.com/testrail).  

The library "attaches" itself on post-test actions and gathers results from tests. At the end of suite results are sent to TestRail.  
Tests are matched with test cases by name.  

Test case format includes FQCN as well as method name and also parameter if needed. Case names can look like:

- `VerifySpockListener[success]`
- `VerifySpockListener[parameterised (1 ?? 1)]`
- `VerifyTestNGListener[parameterised:param1]`
- `VerifyJUnitListener[parameterised:[1] param 1]`

General pattern is: `FQCN[methodName:parameter]`, there are two exceptions:
- Spock parameterised test method name already provides params, so we actually can't use colon as a delimiter

# Building

```bash
./gradlew build
```

# Testing

The only way to test listeners is to use `Verify***Listener` classes to debug if all required method invocations happen.

# Using

## Setup

- add gradle dependency  
```groovy
testCompile('com.jamf:testrail-reporting:0.0.1-SNAPSHOT')
```

- add `@ReportResults` annotation
```java

# Spock example
@ReportSpockResults
class BaseATSpec extends Specification { ... }

## configuration

## testRail.properties
You can use dedicated properties file to configure where test results should be reported.  
Put `testRail.properties` in `test/resources`, and specify below configuration.

```properties
testrail.url= #url to testrail REST api ex: https://sometestrailserver.com/testrail
testrail.projectId= #under which results will be saved
testrail.sectionId= #where tests will be created
testrail.run_name= #what should the test run be named, this parameter is required if testrail.send is true
testrail.run_description= #optional description that should be added to test run
```

# Credentials
TestRail email and password have to be specified in the environment variables
```
export TESTRAIL_USER=
export TESTRAIL_PASS=
export TESTRAIL_SEND=true
```