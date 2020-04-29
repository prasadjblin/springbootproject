<img align="left" width="48" height="48" src="./spring-boot-logo.jpg">

# Spring Boot Application Example
This is a sample Java / Maven / Spring Boot application which provides RESTful services. Compiled in Java 11. Currently it is designed to get two sample GET services `{domain}/api/getproductdetails` and `{domain}/api/getconfigdetails` 

## Installation Instructions
 Open eclipse IDE and import project as existing maven project. I made this project using eclipse-jee-oxygen-3a-win32-x86_64.
  
  If lombok is not installed in your eclipse IDE install it by referring [this answer](https://stackoverflow.com/a/22332248/4130569), you can install lombok just by its jar file. For getting additional knowledge on lombok refer [this tutorial](https://www.vogella.com/tutorials/Lombok/article.html)

POSTMAN is used to test the REST apis. If you dont have install it [from here](https://www.postman.com/downloads/) 

### Dependency Details
- Spring Boot 2.1.2.RELEASE
- Spring 5.1.4.RELEASE
- Spring Security 5.1.3.RELEASE
- Spring Data JPA 2.1.4.RELEASE
- H2 In-memory Database 1.4.197
- Tomcat Embed 9.0.14
- Lombok 1.18.4
- Maven 3
- Java 11

### Build jar file
1. Right click on the Project name from project explorer in the Eclipse IDE.
2. Goto `Run as` ->`Maven build...` option and in **Goals** texbox give `clean install` and wait for the build success status.

### Running Rest API
- **Running from IDE**
1. Right click on the Project name from project explorer in the Eclipse IDE.
2. Goto `Run as` ->`Maven build...` option and in **Goals** texbox give `spring-boot:run` and wait till server is up and running.
- **Running from jar**
1. Open command prompt.
2. use the command `java -jar <jar file localtion>/productservice-0.0.1-SNAPSHOT.jar` and wait till the server is up and running


### Test API request and response
1. Open POSTMAN tool
2. From the middle panel click on the plus '+' icon
3. Choose **GET** from drop down and enter the url. Rest services are running in the local server in the port 8090 so domain ip as localhost port as 8090, so give the apis URI like this `http://localhost:8090/api/getproductdetails`
4.  We have used basic authentication with two user credentials in H2inmemory database.
	+ username  **admin** and password as **password**
	+ username **user** and password as **password**
for sending request use any one of credentials
5. Click on the **Authorization** tab and in the **TYPE** dropdown choose **Basic Auth** use any one of the above credentials in username and password text boxes
6. Click on **Send** button, we will get response like below
 		{ 
		"isSuccess":true,
		"message": "product details api responded",
		"internalCode": 1,
		"response": [
				{
				"id": 101,
				"name": "Ms Office",
				"manufacturer": "Microsoft",
				"price": 1500
				},
				{
				"id": 102,
				"name": "Norton Antivirus",
				"manufacturer": "Norton",
				"price": 899
				},
				{
				"id": 103,
				"name": "Maya 3D",
				"manufacturer": "Autodesk",
				"price": 5500
				}
			]
		}


