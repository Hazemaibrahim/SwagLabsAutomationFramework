**SwagLabs Web Automation framework**

An end to end automated test suite designed for the SwagLabs website (https://www.saucedemo.com/) using Java, TestNG, Maven and Selenium WebDriver. The purpose of this automation framework is to showcase the implementation of key testing functionalities such as login, Logout, cart management, error handling and checkout processes.

**Pre-requisites**

Before running the tests, ensure that you have the following set up:

**Java JDK installed.

**Maven installed.

**IDE (e.g., Eclipse, IntelliJ)

**Selenium WebDriver compatible with your browser.

**TestNG (usually included in Eclipse IDE)

**ExtentReports 

**Framework Structure**

The framework follows a Page Object Model(POM) structured framework to maintain code readability and scalability.

**Key components include**

**src/main/java: Contains utility classe and Page Objects.

**src/test/java: Contains test scripts for the specified test cases and test utility classes.

**reports: Stores HTML report.

**pom.xml: Maven configuration file for managing dependencies.

**testng.xml:test suite which contains all test cases.

**Running the Test**

**You can run the tests by doing a right click on testng.xml file and choose Run as TestNG suite and it will run the test cases sequentially and will create an Extent(HTML) report.
