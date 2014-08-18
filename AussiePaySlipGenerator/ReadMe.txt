Project Name:		AussiePaySlipGenerator: (Other names that it can be identified with AussieTaxCalculator, 					TaxAndSuperCalculator)

Status:			Complete
Notes			Should auto run on deployment in Tomcat or Glassfish
Frameworks:		SpringMVC, Spring core, Junit, Mockito.
IDE:			NetBeans IDE
Application Servers	GlassFish/Tomcat
JDK:			Java 7


This is an Tax and Super calcultor as per the 2012-2013 ATO given Standards in Australia. A user needs to input an employees data (First name, Last name, annual income, rate for super, payment start date)  and the application computes and generates a payslip that has the pay slip data ( first name, last name, gross income, income tax, net income and super)

I have used SpringWebMVC 3 to implment a small web application that can be run on tomcat or glassfish (a required jstl library that is not present in Tomcat by default is also added in the pom.xml; so it works on both Tomcat and Glassfish without issues). It has two views, one to input the employee data and the second one to generate a payslip.
I have made use of Junit4.1.1 and mockito 1.9 to create testcases. Mockito is a mocking framework, i have used it to mock dependency injections.

The project is built through maven 3.0.4, so when running it first time the dependencies might be downloaded. 	

to compile and run the tests, on the project root, just run

$PROJECT_ROOT>mvn clean install

After delpoyment : the URL to application : localhost:8080/AussiePaySlipGenerator

For more of my projects please visit my GitHub : https://github.com/sarmahdi/GitSVNRepo/tree/master


