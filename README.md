# <img height="32" width="32" src="https://unpkg.com/simple-icons@v6/icons/springboot.svg" /> Spring_Boot <img height="32" width="32" src="https://unpkg.com/simple-icons@v6/icons/springsecurity.svg" />
The objective of this project is to make a final MVP for our application using the most current Java-based **Spring Boot** development technology.

**Spring Boot** is a reinterpretation of Spring framework. It allows you to focus solely on the development process, eliminating complex manipulations to customize your application.

This project is a more modern and refined implementation of the projects [FWA](https://github.com/rbiodies/FWA) and [Cinema](https://github.com/rbiodies/Cinema).
## Descriptions
- [ex00: Implementation role-based access to all pages, "remember-me" functionality on /signIn page and protection against csrf attacks using Spring Security framework](https://github.com/rbiodies/Spring_Boot/tree/master/ex00/Cinema)

>[Cross-site request forgery](https://en.wikipedia.org/wiki/Cross-site_request_forgery), also known as one-click attack or session riding and abbreviated as CSRF, is a type of malicious exploit website or web application where unauthorized commands are submitted from a user that the web application trusts
- [ex01: Implementation support for at multiple language and validate a registration](https://github.com/rbiodies/Spring_Boot/tree/master/ex01/Cinema)
- [ex02: Confirmation of a registered account using a link sent to a user’s email shall be implemented](https://github.com/rbiodies/Spring_Boot/tree/master/ex02/Cinema)

>Exercise 02 is a complete project that includes exercises 01 and 00

## Usage
1. Download and run [Postgres](https://www.postgresql.org/download/) (for example, [Postgres.app](https://postgresapp.com/downloads.html)).
2. Connect to the database.
3. Create tables by running [src/main/resources/sql/schema.sql](https://github.com/rbiodies/Spring_Boot/blob/master/ex02/Cinema/src/main/resources/sql/schema.sql) and fill them with test data by running [src/main/resources/sql/data.sql](https://github.com/rbiodies/Spring_Boot/blob/master/ex02/Cinema/src/main/resources/sql/data.sql) (optional).
4. To send an email, you need to use an existing mailbox, e.g., [Gmail](https://www.techmazza.com/solve-java-mail-authentication-failed-exception-in-springboot/) (optional, but logging in without a verified registration will not work).
5. Navigate to the root of the project via command line and execute the command
```
mvn spring-boot:run
```
## Example
### Registration and authorization
[![IMAGE ALT TEXT HERE](https://github.com/rbiodies/Spring_Boot/blob/master/Снимок%20экрана%202023-06-27%20в%2016.34.33.png)](https://youtu.be/lcT5yzhhfGk)
### Protection against csrf attacks
[![IMAGE ALT TEXT HERE](https://github.com/rbiodies/Spring_Boot/blob/master/Снимок%20экрана%202023-06-27%20в%2016.34.50.png)](https://youtu.be/xkegzna4wto)
