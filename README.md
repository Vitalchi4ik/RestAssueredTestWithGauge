# java-restAssured-test

This is a test project, illustrating how I do API test automation using [Gauge](https://github.com/getgauge/gauge) test automation framework, with Java, REST Assured  support.

This project uses

- [Gauge](http://getgauge.io/)
- Gauge Java plugin
- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or above
- [REST Assured ](http://rest-assured.io/)
- [Gradle](https://gradle.org/)

# Concepts covered

- REST Assured usage
- Specs

# Prerequisites

- [Install Gauge](http://getgauge.io/download.html)
- [Install Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Refer REST Assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)
- Install Gauge-Java plugin by running
  ````
  gauge install java
  ````
  
- Install Gauge-other plugins by running [Using Gauge plugins](https://docs.gauge.org/plugin.html?os=windows&language=java&ide=vscode)

##  How I would apply test automation to "List Breweries" endpoint

- Use BDD approach, Gauge framework (for more information see documentation [Gauge](https://docs.gauge.org/writing-specifications.html?os=windows&language=java&ide=vscode))
- Boundary Value Analysis technique test design
  <br>_for example:_
   ````
  end point: https://api.openbrewerydb.org/breweries?per_page=25
  
  default per page is 20. Max per page is 50
  
  1. Test Scenario Enter 50 into path parameters ...?per_page=50 - valid parameter 
  2. Test Scenario Enter 49 into path parameters ...?per_page=49 - valid parameter 
  3. Test Scenario Enter 49 into path parameters ...?per_page=51 - invalid parameter
  4. Test Scenario Enter
  ...etc.
  
  ````
  
- Equivalence Class Partitioning technique test design
  <br>_for example:_
  ````
  end points: https://api.openbrewerydb.org/breweries?by_postal=44107 
  https://api.openbrewerydb.org/breweries?by_postal=44107-4020
  
  Filter breweries by postal code

  May be filtered by basic (5 digit) postal code or more precisely filtered by postal+4 (9 digit) code.
  
  1. Test Scenario - Enter 5 digit postal code into path parameters ...?by_postal=44107 - valid parameter 
  2. Test Scenario - Enter 6 into path parameters ...?by_postal=441055 - invalid parameter 
  3. Test Scenario - Enter 9 into path parameters ...?by_postal=44107-4020 - valid parameter 
  4. Test Scenario - Enter 10 into path parameters ...?by_postal=44107-40205 - invalid parameter 
  ...etc.
  
  ````
- Error Guessing technique test design
  <br>_for example:_
  ````
   Error Guessing is a software testing technique based on guessing the error which can prevail in the code
   The technique is heavily based on the experience where the test analysts use their experience to guess the problematic part of the testing application.
   
   use endpoint https://api.openbrewerydb.org/breweries?by_city=san_diego
   for example change parameter name to wrong
   https://api.openbrewerydb.org/wrong?by_city=san_diego
   Scenario expected 404 error code status
  ````

## Estimate QC

| **Descriptions**                                      | **Estimate, h**  |
|:-----------------------------------------------------:|:-----------------|
| **Testing**                                           | **Total Time**   | 
| Data preparation(set up configs, install plugins etc. |1                 |
| Read and investigation application with documentation |0.5               |
| Preparing module view                                 |0.5               |
| Smoke Check-list                                      |0.75              |
| Create test cases                                     |1.15              |
| Writing code                                          |3                 |
| Refactoring code                                      |1                 |
| Checklist-update                                      |0.25              |
| Risks (corner case situations, etc)                   |2                 |

