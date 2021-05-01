# gauge-java-restAssured-test

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

## Estimate QC

| **Descriptions**                                      | **Estimate, h**  |
|:-----------------------------------------------------:|:-----------------|
| **Testing**                                           | **Total Time**   | 
| Data preparation(set up configs, install plugins etc. |        1         |
| Read and investigation application with documentation |        0.5       |
| Preparing module view                                 |         0.5      |
| Smoke Check-list                                      |        0.75      |
| Create test cases                                     |         1.15     |
| Writing code                                          |         3        |
| Refactoring code                                      |          1       |
| Checklist-update                                      |          0.25    |
| Risks (corner case situations, etc)                   |          2       |