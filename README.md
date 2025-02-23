Book Application
This application is a Spring Boot project designed to manage a collection of books.
The API will allow users to perform CRUD (Create, Read, Delete) operations on a collection of resources.

Structure
•	BookApplication: Main entry point for the Spring Boot application.
•	Book:POJO (Plain Old Java Object) class
•	BookController: REST controller for handling API requests.
•	BookRepository
•	pom.xml

Features
•	Add a new book
•	Retrieve all books
•	Retrieve a book by ID
•	Retrieve books by title
•	Retrieve books by category
•	Delete a book by ID


Software Required:
•	Java Development Kit JDK 17 or 21
•	IntelliJ IDEA Community Edition https://www.jetbrains.com/idea/download/?section=windows
•	Spring boot Initializer project https://start.spring.io/ - this allows to create a Spring boot enabled project that we will open in IntelliJ IDE
•	Postman tool to view REST API end points: https://www.postman.com/downloads/?utm_source=postman-home

To test the API

Open Spring boot Initializer at https://start.spring.io/, and create a project as below:
Project:Maven
Language:Java
Spring Boot:3.2.2
Packaging:Jar
Java:21

Add dependencies:
•	Spring Boot DevTools
•	Spring Web
•	Spring Web Services
•	Spring Data JPA
•	H2 Database
•	Lombok

Download the created project, unzip it and open it in IntelliJ IDEA Community Edition.

Installation
Clone the repository Book Application
https://github.com/arotun/RestAPI_book_project

Run the BookApplication:
Go to the following adress and connect bookdb.
http://localhost:8080/h2

In order to examine the REST API end points open Postman.
Add some book for testing purpose:

Check if the books are inserted in the database. You can check it by visiting the REST API GET end point http://localhost:8080/h2/books in your browser:
Check the same on Postman tool as well as in the H2 database.

API Endpoints

Get All Books
•	URL: /books
•	Method: GET
•	Response Codes:
o	200 OK
o	204 No Content
o	500 Internal Server Error

Get Book by ID
•	URL: /books/{id}
•	Method: GET
•	Response Codes:
o	200 OK
o	404 Not Found

Get Books by Title
•	URL: /books/title/{title}
•	Method: GET
•	Response Codes:
o	200 OK
o	404 Not Found

Get Books by Category
•	URL: /books/category/{category}
•	Method: GET
•	Response Codes:
o	200 OK
o	404 Not Found

Add a New Book
•	URL: /books
•	Method: POST
•	Response Codes:
o	201 Created
o	500 Internal Server Error

Delete a Book by ID
•	URL: /books/{id}
•	Method: DELETE
•	Response Codes:
o	204 No Content
o	404 Not Found
o	500 Internal Server Error
