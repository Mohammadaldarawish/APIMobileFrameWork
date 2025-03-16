# API Mobile Framework

## Overview

API Mobile Framework is a test automation framework designed for testing web services, including both REST and SOAP APIs. It supports keyword-driven and data-driven testing approaches, allowing users to separate test data in Excel sheets with predefined schemas and utilize keywords to validate responses. The framework is built using Java and leverages tools like Rest-Assured, TestNG, and Maven for efficient test automation.

## Features

- **Hybrid Framework**: Combines keyword-driven and data-driven testing methodologies.
- **Supports REST and SOAP**: Capable of testing both RESTful and SOAP web services.
- **Zero Coding Required**: Allows testers to define test cases in Excel without writing code.
- **Integration with CI/CD**: Can be integrated into DevOps pipelines for continuous testing.
- **Reusable Test Steps**: Supports the reuse of data from previous test steps in subsequent ones.

## Tools and Technologies Used

- **Programming Language**: Java
- **Testing Framework**: TestNG
- **API Testing**: Rest-Assured
- **Build Tool**: Maven
- **Data Management**: JXL for Excel integration

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher
- **Maven**: Version 3 or higher
- **TestNG**: Integrated via Maven dependencies
- **Excel Data Files**: Test data should be prepared in Excel format following the predefined schema.

## Installation and Setup

1. **Clone the Repository**:
      git clone https://github.com/Mohammadaldarawish/APIMobileFrameWork.git
2. Navigate to the Project Directory:
      cd APIMobileFrameWork
3. Build the Project Using Maven:
      mvn clean install

4. Prepare Test Data:
Create Excel files containing your test data following the predefined schema.
Place these files in the designated directory (e.g., src/test/resources/testdata).


Running Tests
- Using Maven:
mvn test
- Using TestNG:
Open the TestNG XML file (e.g., testng.xml).
Execute the tests through your preferred IDE or command line.

Reporting
After test execution, reports are generated in the target directory:

HTML Reports: Detailed reports with test execution results.
JUnit XML Reports: Can be integrated with CI tools like Jenkins for continuous integration.

Continuous Integration
To integrate the framework with Jenkins:

Configure Jenkins Job:
Set up a Maven project in Jenkins.
Configure the repository URL and branch.
Post-Build Actions:
Publish JUnit test result reports by specifying the path to the XML reports.
Optionally, configure email notifications for test results.

   
