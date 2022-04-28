**Description**


- This project was desinged to automate some functionalities and testcases in 
FACEBOOK Login & Register modules

****Concepts Included****
- Page object Module
- Data Driven Framwork
- BDD 

**Tools**

- Selenium WebDriver
- Cucumber
- Junit
- Maven

**Requirements**

To use the project you need to have the following :
 
- Maven 8
- Java SDK 1.8

the project is using WebDriverManager there is no need to install any drivers for a particular browser

**Usage**

- The project has 2 Features (login & Register)
- Login feature has 3 testCases 1 is positive, and the other 2 are negative
- To run the login feature use the "login.feature" path in cucumber options in TestRunner with one of the Tags ["Negative", "Positive"] 
- Register feature has 3 testCases 2 is positive, and the other 1 is negative
- To run the Register feature use the "register.feature" path in cucumber options in TestRunner with one of the Tags ["Negative", "Positive"]