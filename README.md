<div align="center">

# 🎟️ EVENTO
### Enterprise Event Management & Dynamic Digital Ticketing System

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green.svg)](https://www.thymeleaf.org/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple.svg)](https://getbootstrap.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

An end-to-end full-stack web application engineered to streamline event publishing, user registration workflow, and instant dynamic QR-code ticket generation.

[Key Features](#-key-features) • [Tech Stack](#-technology-stack) • [System Architecture](#-system-architecture) • [Getting Started](#-getting-started) • [Author](#-author)

---

</div>

## 📌 Executive Summary

Evento addresses the operational overhead in modern event organization by providing an automated, role-based web interface. Built on top of the robust Spring Boot framework, the system enforces secure user authentication, transactional ticket purchasing, real-time availability tracking, and automated check-in verification via dynamically generated dynamic QR codes.

---

## ✨ Key Features

### 🔐 Authentication & Access Control
- Role-Based Access Control (RBAC): Strict segregation between USER and ADMIN privileges.
- Account Onboarding: Real-time email validation preventing duplicate registration.
- Automated Routing: Context-aware redirection based on user credentials upon login.

### 👥 User Capabilities
- Event Discovery: Responsive dashboard showcasing active events with live dynamic database rendering.
- Transactional Booking System: Seamless ticket processing with real-time database state persistence.
- Digital QR Receipts: Dynamic generation of unique tracking identifiers (e.g., EVT-1790604298064) paired with scannable QR verification badges for physical check-ins.

### 🛡️ Administrative Portal
- Lifecycle Management: Complete CRUD interface for creating, modifying, and monitoring event details.
- Cascade Data Consistency: One-click event termination with automated database cascade deletion for associated ticket records.

---

## 🛠️ Technology Stack

| Architecture Layer | Technology / Library |
| :--- | :--- |
| Language | Java 17 LTS |
| Backend Framework | Spring Boot 3.x (Spring MVC, Spring Data JPA) |
| Template Engine | Thymeleaf Template Engine |
| Frontend UI | HTML5, CSS3, Bootstrap 5.3, Bootstrap Icons |
| Database Engine | MySQL 8.0 / In-Memory H2 Database |
| Build System | Apache Maven |
| External Integration | RESTful Third-Party QR Code Generation API |

---

## 🏗️ System Architecture

com.example.evento/
├── 📁 controller/        # Application Controller Layer (HTTP Requests & Views)
│   └── EventController.java
├── 📁 model/             # JPA Entities / Database Schema Models
│   ├── Event.java
│   ├── Ticket.java
│   └── User.java
├── 📁 repository/        # Data Access Layer (Spring Data JPA Repositories)
│   ├── EventRepository.java
│   ├── TicketRepository.java
│   └── UserRepository.java
└── EventoApplication.java # Spring Boot Core Entry Point

---

## 🚀 Getting Started

### Prerequisites
Ensure you have the following installed on your environment:
- Java Development Kit (JDK 17+)
- Apache Maven 3.8+
- MySQL Server 8.0+

### Local Installation & Setup

1. Clone the Repository:
   git clone https://github.com/ahmedmohiuddin455/evento.git
   cd evento

2. Database Configuration:
   Navigate to src/main/resources/application.properties and configure your database parameters:
   
   spring.datasource.url=jdbc:mysql://localhost:3306/evento_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true

3. Build & Launch Application:
   mvn clean package
   mvn spring-boot:run

4. Application Access:
   Once the console displays Started EventoApplication, access the web portal at:
   http://localhost:8080

---

## 👨‍💻 Developer & Academic Information

* Student Name: Mohiuddin Ahmed
* Student ID: 2023100000476
* Course Title: Advanced Java Lab
* Course Code: CSE352.2
* Department: Department of Computer Science & Engineering
* Institution: Southeast University

---

<div align="center">
  <sub>Developed for academic review and production demonstration.</sub>
</div>
