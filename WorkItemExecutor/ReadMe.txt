Project Name:		WorkItemExecutor

Status:			Complete
Notes			
Frameworks/APIs		Junit.
IDE:			NetBeans IDE
Application Servers	GlassFish/Tomcat
JDK:			Java 7

This is a simple framework to execute a task (called here a Work Item) with multiple threads. 

There are two packages in the framework for the implementation. Each package follows a different possible situation. There are two ways to envision a task that can be executed by multiple threads. Either the task has sub work items that are in itself a complete work item and can be executed independently  in parallel using a thread or it is a task that can be repeated in parallel by a number of threads simultaneously or concurrently.

In order to develop it a new feature of Java 7, ForkJoinPool was used. The project is built through maven 3.0.4, so when running it first time the dependencies might be downloaded. The only external dependencies needed are Junit 4.1.1 and Log4j 1.2.15.

There is a test harness to test the functionality of the framework. The test cases are written in Junit 4.11.

to compile and run the tests, on the project root, just run


$PROJECT_ROOT>mvn clean install

