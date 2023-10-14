# spring-boot-rest-crud-api
Demo Project To Perform Crud Operation Using Spring Boot

Creating a CRUD (Create, Read, Update, Delete) API with Spring Boot in Java is a common task for building web applications. Below, I'll provide a step-by-step tutorial on how to create a simple CRUD API for a simple banking system to create users and accounts for users using Spring Boot:

## Prerequisites
### 1. Set Up Our Development Environment → Make sure we have the following tools installed:
```
Java Development Kit (JDK)
Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse
Maven
```
### 2. Create a Spring Boot Project

We can use Spring Initializr to quickly bootstrap a Spring Boot project.
Visit the [Spring Initializr website](https://start.spring.io/) and configure your project with the following settings:

```
Project: Choose "Maven Project"
Language: Choose "Java"
Spring Boot: Choose a version (e.g., 3.1.4)
Group: Your package name (e.g., com.example)
Artifact: Your project name (e.g., spring-boot-crud-api)
Dependencies: Add "Spring Web," "Spring Data JPA," and "H2" (in-memory database for this example)
Click "Generate" to download the project structure as a zip file. Extract it to your preferred directory.
```
## CRUD Operations
Here is a list of the API endpoints provided by the implementation in this application:

### USER:

```
GET /api/users --> Get all users: Retrieve a list of all users.
GET /api/users/{id} --> Get user by ID: Retrieve a user by their unique user ID.
POST /api/users --> Create a new user: Register a new user.
PUT /api/users/{id} --> Update user details: Update an existing user's details by their user ID.
DELETE /api/users/{id} --> Delete user: Delete a user by their user ID.
```

### ACCOUNT:

```
GET /api/accounts/{userId} --> Get user accounts: Retrieve a list of accounts associated with a user.
POST /api/accounts --> Create an account: Create a new account for a user.
GET /api/accounts/{accountId} --> Get account by ID: Retrieve an account by its unique account ID.
PUT /api/accounts/{accountId} --> Update account details: Update an existing account's details by its account ID.
DELETE /api/accounts/{accountId} --> Delete account: Delete an account by its unique account ID.
```

## Request and Response Sample
### 1. Create An User

```
Request:

curl --location 'http://localhost:8080/api/users' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=38791665E82367A7614237357CFC7855' \
--data-raw '{
    "username": "reetesh 4",
    "password": "password123",
    "email": "reet.test@test.com",
    "name": "Spring Boot Crud Demo"
}'

Response:
{
    "id": 1,
    "username": "reetesh 4",
    "password": "password123",
    "email": "reet.test@test.com",
    "name": "Spring Boot Crud Demo"
}
```
### 2. Get A User By ID

```
Request:

curl --location 'http://localhost:8080/api/users/1' \
--header 'Cookie: JSESSIONID=38791665E82367A7614237357CFC7855'

Response:

{
    "id": 1,
    "username": "reetesh 4",
    "password": "password123",
    "email": "reet.test@test.com",
    "name": "Spring Boot Crud Demo"
}
```

### 3. Get All Users

```
Request:

curl --location 'http://localhost:8080/api/users' \
--header 'Cookie: JSESSIONID=38791665E82367A7614237357CFC7855'

Response:

[
    {
        "id": 1,
        "username": "reetesh 2",
        "password": "password123",
        "email": "reet.test@test.com",
        "name": "Spring Boot Crud Demo"
    },
    {
        "id": 2,
        "username": "reetesh 3",
        "password": "password123",
        "email": "reet.test@test.com",
        "name": "Spring Boot Crud Demo"
    },
    {
        "id": 3,
        "username": "reetesh 4",
        "password": "password123",
        "email": "reet.test@test.com",
        "name": "Spring Boot Crud Demo"
    }
]

```

### 4. Create An Account For A User

```
Request:

curl --location 'http://localhost:8080/api/accounts' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=38791665E82367A7614237357CFC7855' \
--data '{
  "userId": 1, 
  "balance": 1000.00
}'

Response:

{
    "id": 1,
    "userId": 1,
    "balance": 1000.0
}
```

### 5. Get Account By AccountId

```
Request:

curl --location 'http://localhost:8080/api/accounts/1' \
--header 'Cookie: JSESSIONID=38791665E82367A7614237357CFC7855'

Response:

{
    "id": 1,
    "userId": 1,
    "balance": 1000.0
}
```

### 5. Update Account By AccountId

```
Request:

curl --location --request PUT 'http://localhost:8080/api/accounts/1' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=38791665E82367A7614237357CFC7855' \
--data '{
  "balance": 2000.00
}'

Response:

{
    "id": 1,
    "userId": 1,
    "balance": 2000.0
}
```


