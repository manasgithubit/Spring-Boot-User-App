# Spring-Boot-User-App
      # User Application of Second Repository

Overview
--------
This is a Spring Boot-based User Management System that provides CRUD operations for managing users, including validation, bulk updates, and manager assignments. The application uses MySQL as the database and JWT for authentication.

Features
--------
User Authentication
Create, Read, Update, Delete (CRUD) operations for users
Bulk updates for user data
Assigning managers to users
API call logging for tracking user interactions

Technologies Used
------------------
Java 17
Spring Boot 3.x
Spring Data JPA
Spring web
Lombok
MySQL
Postman(for testing)

Installation & Setup
---------------------
Prerequisites
Java 17 or later
Maven
MySQL
Postman (optional, for testing API endpoints)

Clone the Repository
--------------------
git clone https://localhost:8080/users/create_user
git clone https://localhost:8080/managers/create

MySQL (Optional)
----------------
spring.datasource.url=jdbc:mysql://localhost:3306/usertable
spring.datasource.username=root
spring.datasource.password=Manas@1999
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Build and Run the Application
-----------------------------
$ mvn spring-boot:run

Running Tests
-------------
$ mvn test

Author
-------
Your Name = Manas Kumar Sahoo
Your GitHub Profile link = https://github.com/manasgithubit
