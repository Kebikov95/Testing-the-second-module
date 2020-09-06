# Testing-the-second-module
Repository for storing homework of the second automated testing module.

## This repository consists of the following tasks:
* Java
    - Error and Exceptions
    - Input/Output
    - Multythreading
* WebDriver
    - Tests https://pastebin.com page
    - Tests https://cloud.google.com page
* Framework
    - Test https://cloud.google.com page

## Setup Framework
To run Framework project from command line:

```
mvn -Dbrowser=${browser} -Dsurefire.suiteXmlFiles=${file.xml} -Denvironment=${environment} clean test
```

## Default values:
* browser
    - chrome
    - firefox
* surefire.suiteXmlFiles
    - src/test/resources/testng-smoke.xml
    - src/test/resources/testng-all.xml
* environment
    - dev
    - qa
    - staging