# 🏥 Patient Management Service

A **microservices-based Patient Management System** built using **Java and Spring Boot**. The project demonstrates a modern distributed system architecture where different business responsibilities are separated into independent services.

The application includes services for patient management, authentication, billing, analytics, API routing, infrastructure provisioning, and integration testing.

---

## 📌 Architecture Overview

The system follows a **microservices architecture**, where each service is responsible for a specific business capability.

```text
                        ┌─────────────────┐
                        │   API Gateway   │
                        └────────┬────────┘
                                 │
              ┌──────────────────┼──────────────────┐
              │                  │                  │
              ▼                  ▼                  ▼
     ┌────────────────┐ ┌────────────────┐ ┌────────────────┐
     │ Patient Service│ │  Auth Service  │ │ Billing Service│
     └────────────────┘ └────────────────┘ └────────────────┘
              │
              ▼
     ┌────────────────┐
     │Analytics Service│
     └────────────────┘
```

---

## 🚀 Services

### 👤 Patient Service

Responsible for managing patient-related operations, including creating, retrieving, updating, and managing patient information.

### 🔐 Authentication Service

Handles authentication and authorization functionality for securing access to the system.

### 💳 Billing Service

Manages billing-related operations associated with patients and healthcare services.

### 📊 Analytics Service

Responsible for processing and analyzing application data to provide useful insights.

### 🌐 API Gateway

Acts as the single entry point for client requests and routes traffic to the appropriate microservices.

### 🏗️ Infrastructure

Contains infrastructure-related configuration and deployment code for provisioning and managing application resources.

### 🧪 Integration Tests

Contains integration tests used to verify that different services work correctly together.

---

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Cloud**
* **Spring Security**
* **Maven**
* **Docker**
* **AWS**
* **AWS CDK**
* **LocalStack**
* **REST APIs**

---

## 📂 Project Structure

```text
Patient-management-service
│
├── Patient-management
│   │
│   ├── analytics-service
│   ├── api-gateway
│   ├── api-requests
│   │   └── patient-service
│   ├── auth-service
│   ├── billing-service
│   ├── infrastructure
│   ├── integration-tests
│   └── patient-service
│
├── README.md
└── .gitignore
```

---

## ⚙️ Prerequisites

Before running the project, make sure you have the following installed:

* Java **21+**
* Maven
* Docker
* AWS CLI
* LocalStack *(for local AWS infrastructure testing)*

You can verify your installations using:

```bash
java --version
mvn --version
docker --version
aws --version
```

---

## ▶️ Running the Services

Navigate to the required service directory.

For example:

```bash
cd Patient-management/patient-service
```

Build the application:

```bash
./mvnw clean package
```

On Windows:

```bash
mvnw.cmd clean package
```

Run the application:

```bash
./mvnw spring-boot:run
```

Repeat the process for other services as required.

---

## 🐳 Running with Docker

Each service can be containerized using its respective `Dockerfile`.

Build a Docker image:

```bash
docker build -t patient-service .
```

Run the container:

```bash
docker run -p <HOST_PORT>:<CONTAINER_PORT> patient-service
```

Make sure to configure the required environment variables and dependent services before starting the containers.

---

## ☁️ Infrastructure

The `infrastructure` module contains the infrastructure configuration for the project.

The infrastructure can be used to provision and manage cloud resources using:

* AWS CDK
* AWS services
* LocalStack for local cloud development and testing

LocalStack allows AWS-compatible services to be tested locally without deploying directly to AWS.

---

## 🧪 Testing

Integration tests are available to verify communication and behaviour across multiple services.

Navigate to the integration test module and run:

```bash
./mvnw test
```

---

## 🔐 Security

Authentication and authorization are handled through the dedicated **Authentication Service**.

The API Gateway acts as the entry point to the system and can be configured to route and secure requests before they reach individual microservices.

---

## 🎯 Learning Objectives

This project was built to explore and practice:

* Microservices architecture
* Spring Boot application development
* API Gateway patterns
* Authentication and authorization
* Docker containerization
* Cloud infrastructure
* AWS CDK
* LocalStack
* Service integration testing
* Distributed application development

---

## 🔮 Future Improvements

Some possible improvements for the project include:

* [ ] Add Docker Compose for running all services together
* [ ] Add centralized logging
* [ ] Add service discovery
* [ ] Add monitoring and observability
* [ ] Add CI/CD pipelines
* [ ] Improve API documentation using Swagger/OpenAPI
* [ ] Add more automated tests
* [ ] Improve error handling and resilience
* [ ] Add Kubernetes deployment configuration



## 👨‍💻 Author

**Ritam Mondal**

---

