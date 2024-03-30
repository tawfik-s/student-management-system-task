# student-management-system-task
***
Develop a backend-only web application using Java Spring MVC to manage student, teacher,  quiz, and course data for the current semester. 


<a href="http://localhost:8080/swagger-ui/index.html#">Swagger-UI</a>

`http://localhost:8080/swagger-ui/index.html#` don't forget to change the port in the url if you modify it in the properties file

## Fully functional quiz API
I built a fully functional quiz system last year it's open source 
and available at my GitHub <a href="https://github.com/tawfik-s/classroom-api">Classroom-API-GitHub</a>
***

## Evaluation criteria
- ability to configure spring
- create service layers
- handle data persistence using xml configuration
- implement CRUD operations
- optionally integration swagger for API documentation

## Configuration
- configure spring beans, hibernate/jpa, and other necessary configurations using xml

## Assessment Criteria:
- evaluation based on functionality
- code quality
- effective use of springMVC
- proper Configuration of hibernate or jba
- successful implementation of curd operations
- optionally swagger integration



## Note 
I can't find on the web how to configure springMVC REST using xml configuration I try to use configurations from the web, but it's not working, so I leave springBoot to scan RestController components, and it's work properly. all other beans is registered using xml configuration.


***
## Installation steps


### Configure database

I use mysql database that run on docker, this is the command to run mysql container.

```docker run --name='my_sql_container' -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql```

<br>

## How to Run Using Maven
To run the Spring Boot application using Maven, follow these steps:

1. Open a terminal (command prompt) window or a terminal within your IDE.

2. Navigate to the root directory of the Spring Boot project, where the `pom.xml` file is located.

3. Build the project using Maven by executing the following command:

   ```bash
   mvn clean package
   ```

   This command will compile the Java code, run tests, and package the application into a JAR file.

4. Once the build is successful, you can run the Spring Boot application using the following command:

   ```bash
   mvn spring-boot:run
   ```

   Maven will start the embedded Tomcat server and deploy your application. You should see logs indicating that the application is running.

5. By default, the application will be accessible at `http://localhost:8080`. Open your web browser and navigate to this URL to access the application.

6. If you need to stop the running application, you can press `Ctrl + C` in the terminal where the application is running. This will terminate the Spring Boot application.

**Note:** Ensure that you have properly configured the properties, such as the database URL, username, and password, in the `application.yml` file before running the application. Also, make sure that your PostgreSQL database is running and accessible before starting the Spring Boot application.

Now, you can interact with your Spring Boot application through the specified endpoints and test its functionality.


