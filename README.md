# Food Delivery Microservices

A Spring Boot based microservices backend application for a food delivery system. The project follows a distributed service architecture using Eureka Server for service discovery, API Gateway for centralized routing, and JWT based authentication for secure user access.

## Project Overview

This project demonstrates how a food delivery backend can be designed using microservices. Each major business module is developed as an independent service, making the system modular, scalable, and easier to maintain.

The application supports user authentication, restaurant/menu management, order creation, dummy payment processing, service discovery, centralized API routing, and inter-service communication.

## Microservices Included

| Service           | Description                                                 | Default Port |
| ----------------- | ----------------------------------------------------------- | ------------ |
| Eureka Server     | Service registry for all microservices                      | 8761         |
| API Gateway       | Central entry point for all client requests                 | 8080         |
| User Service      | Handles user registration, login, and JWT authentication    | 8081         |
| Restraunt Service | Manages restraunt and menu related APIs                     | 8082         |
| Order Service     | Handles order creation and communicates with other services | 8083         |
| Payment Service   | Handles dummy payment processing                            | 8084         |

## Tech Stack

* Java
* Spring Boot
* Spring Cloud
* Spring Cloud Netflix Eureka
* Spring Cloud Gateway
* Spring Security
* JWT Authentication
* OpenFeign
* Maven
* H2 Database
* REST APIs

## Key Features

* User registration using email and password
* Secure login with JWT token generation
* API Gateway based routing
* Eureka based service discovery
* Inter-service communication using OpenFeign
* Order creation with user, restraunt, and payment service calls
* Dummy payment processing
* Modular microservices structure
* Postman collection included for API testing

## Project Architecture

```text
Client / Postman
      |
      v
API Gateway
      |
      |---------------- User Service
      |---------------- Restraunt Service
      |---------------- Order Service
                              |
                              |---- User Service
                              |---- Restraunt Service
                              |---- Payment Service

Eureka Server is used for service registration and discovery.
```

## Folder Structure

```text
food-delivery-microservices
├── api-gateway
├── eureka-server
├── user-service
├── restraunt-service
├── order-service
├── payment-service
├── FoodDelivery.postman_collection.json
├── pom.xml
└── run-all-windows.bat
```

## API Flow

### 1. Register User

```http
POST /api/users/register
```

Sample request:

```json
{
  "name": "Priyansh Mathur",
  "email": "priyansh@example.com",
  "password": "password123"
}
```

### 2. Login User

```http
POST /api/users/login
```

Sample request:

```json
{
  "email": "priyansh@example.com",
  "password": "password123"
}
```

After successful login, a JWT token is returned. This token is required for protected APIs.

### 3. Access Protected APIs

Use the JWT token in the request header:

```http
Authorization: Bearer <token>
```

### 4. Create Order

```http
POST /api/orders
```

The Order Service communicates with User Service, Restraunt Service, and Payment Service to complete the order flow.

## How to Run Locally

### Prerequisites

* Java 17 or above
* Maven
* Git
* Postman or any API testing tool

### Run Using Batch File

For Windows, run:

```bash
run-all-windows.bat
```

### Run Manually

Run services in the following order:

```bash
cd eureka-server
mvn spring-boot:run
```

```bash
cd api-gateway
mvn spring-boot:run
```

```bash
cd user-service
mvn spring-boot:run
```

```bash
cd restraunt-service
mvn spring-boot:run
```

```bash
cd payment-service
mvn spring-boot:run
```

```bash
cd order-service
mvn spring-boot:run
```

## Service URLs

| Service           | URL                   |
| ----------------- | --------------------- |
| Eureka Dashboard  | http://localhost:8761 |
| API Gateway       | http://localhost:8080 |
| User Service      | http://localhost:8081 |
| Restraunt Service | http://localhost:8082 |
| Order Service     | http://localhost:8083 |
| Payment Service   | http://localhost:8084 |

## API Testing

A Postman collection is included in the repository:

```text
FoodDelivery.postman_collection.json
```

Import this file into Postman and test the complete API flow.

## Main Learning Outcomes

* Designing backend systems using microservices
* Implementing service discovery with Eureka
* Routing requests through API Gateway
* Securing APIs using JWT authentication
* Communicating between services using OpenFeign
* Structuring a real-world Spring Boot backend project

## Future Enhancements

* Add PostgreSQL or MySQL database support
* Add Docker and Docker Compose setup
* Add centralized configuration using Spring Cloud Config Server
* Add centralized logging and monitoring
* Add real payment gateway integration
* Add order tracking and delivery partner service
* Add role-based authentication for users, admins, and restaurant owners

## Conclusion

This project represents a scalable backend architecture for a food delivery platform using Spring Boot microservices. It includes the core backend modules required in a distributed food delivery system and demonstrates important microservices concepts such as API Gateway, service discovery, authentication, and inter-service communication.
