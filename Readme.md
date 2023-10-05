# USER MANAGEMENT SYSTEM

**Name: Pankaj Kalra, Batch: FS-11**
[GITHUB](https://github.com/Pankaj-dev98/university-management-system-geekster)

## Frameworks and languages used
- Source code: Java 21
- Base framework: SpringBoot with inbuilt TomCat server
- Dependencies: spring-boot-starter-web, Spring data JPA, Spring-boot-dev-tools, MySQL-jdbc-driver

## Data Flow
- Project implements an MVC architecture alongside a data-access directory to interface with the database.
- Control is first passed onto the enpoint handler in the controllers.
- The calls are delegated to the service layer wherein the business logic of the CRUD application exists.
- The DAO interfaces further are instantiated with standard-JPA entity manager to save and retreive objects from the database.

- Source code is available at: [GITHUB](https://github.com/Pankaj-dev98/university-management-system-geekster)

- Database design: Project uses a local relational MySql database with all required fields and constraints.

## Data structure used
Objects are complex POJO's whereas results are returned as List<T> which are serialized as Json arrays.

## Project Summary
Application is a well tested CRUD application for students and university events.
All required functionalities have been implemented. Fields have been validated thoroughly and errors and exceptions are not ignored.
All dates are in yyyy-MM-dd format and time types are in HH:mm:ss format. 


