# To do list application

To do list application developed with Spring Boot and React.js

## Technologies and Tools used: 🛠️

* [MySQL Server 8.0.26](https://www.mysql.com/downloads/)
* [Apache Maven 3.6.3](https://maven.apache.org/)
* [Spring Boot 2.6.1](https://spring.io/projects/spring-boot)
* [Java version 1.8](https://www.oracle.com/java/technologies/downloads/)
* [Spring Boot Dev Tools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [Spring Web](https://mvnrepository.com/artifact/org.springframework/spring-web)
* [Spring Web Services](https://spring.io/projects/spring-ws)
* [Spring Data JPA 2.6.1](https://spring.io/projects/spring-data-jpa)
* [MySQL Driver 8.0.27](https://dev.mysql.com/downloads/connector/j/)
* [Node.js v16.13.1](https://nodejs.org/en/)
* [npm 8.3.0](https://docs.npmjs.com/)
* [React.js version 17.0.2](https://reactjs.org/)
* [React Router Dom version 6.1.1](https://reactrouter.com/)
* [Bootstrap version 5.1.3](https://getbootstrap.com/)


**Download project**

```
git clone https://github.com/rbayarri/todolistapplication.git
```

## Backend local setup

**Step 1: Create database 'todoapplication':**
```
CREATE DATABASE todoapplication;
```

**Step 2: Upate file application.properties**

Update file application.properties with your mysql credentials.


**Step 2: Run the project**
```
cd backend
mvn spring-boot:run
```

## Frontend local setup

**Step 1: The npm install installs all modules that are listed on package.json file and their dependencies**
```
cd ../frontend/
npm install
```

**Step 2: Run the Frontend application**
```
npm start
```
Access the URL via browser - http://localhost:3000

