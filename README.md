# Individual Automation Project
This project is to automate the webpage https://automationexercise.com/ using Selenium WebDriver and different browsers 
## Browsers Versions Used
-  Edge Versión 110.0.1587.56 (64 bits)
- Chrome Versión 110.0.5481.178 (64 bits)
- FireFox 110.0 (64-bit)
## Tools
The next tools were used to develop the project:

- [Selenium Webdriver](https://www.selenium.dev/documentation/) - To automate the test cases
- [Cucumber](https://cucumber.io/docs/) - To pose scenarios
- [Gradle](https://gradle.org/) - To install the dependencies
- [Test NG](https://testng.org/doc/) - To make the assertions of the tests

## Features to be tested

- Products
![image](https://user-images.githubusercontent.com/86843637/221449747-14bb2535-d1ab-42ff-b0f8-6aeeed8d8d3e.png)
- Cart
![image](https://user-images.githubusercontent.com/86843637/221449707-c84c668a-2f8f-4596-acd1-e2a44a50b075.png)

## Gradle variables to be configured
- **envId**: The environment where the tests will be run " (e.g: local) by default is "user
- **browser**: The browser where the test can be run (edge, firefox or chrome) by default is "chrome"
- **headlessMode**: Headless mode is to hide the browser (true or false) by default is "false"
- **buildNumber**: To put it in the cucumber report by default is "0"
- **cucumberOpdtions(required)**: To run only the selected label (e.g: @UI, @Cart, @Products ect)
- **email(required)**: The email to login in the page by default is "gonzalo@hotmail.com"
- **password(required)**: The password to login in the page by default is "Gonzalo123"

## Example
#### Gradle command:
> gradle clean executeFeatures -PcucumberOptions="@Test" -Pbrowser="edge" -PbuildNumber="11" 

#### Execution in Edge
![image](https://user-images.githubusercontent.com/86843637/221453589-2b6ce6ee-d6f0-456c-8e6f-29ae970578c8.png)
#### Report of Cucumber
![image](https://user-images.githubusercontent.com/86843637/221453648-80963ef6-ef77-4354-bb79-3322c5dd6900.png)

## IMPORTANT NOTE
> Some of the Tests are failing, hence
> they are consider as bugs