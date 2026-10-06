# 🎟 Evento – Event Management & Ticket Booking System

A full-stack Spring Boot application for event management, dynamic ticket booking, dynamic QR code generation, and administrative control.

---

## 🌐 Live Application & Infrastructure
- **Live URL:** [https://evento-6kkv.onrender.com](https://evento-6kkv.onrender.com)
- **Deployment:** Render Web Service (Multi-stage Docker)
- **Production Database:** Aiven MySQL (Cloud Managed)

---

## ⚙️ Requirements & Prerequisites

Ensure the following tools are installed before running the project:
- Java Development Kit (JDK 21)
- Apache Maven (v3.8+)
- MySQL Community Server (v8.0+) or Aiven MySQL
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## 🗄️ Database Setup & Configuration

1. Open MySQL Workbench or Command Line and create a new database (for local testing):
   CREATE DATABASE evento_db;

2. Open `src/main/resources/application.properties` and update your database credentials:

   server.port=8080

   spring.datasource.url=jdbc:mysql://localhost:3306/evento_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

---

## 🚀 How to Run the Application

### Option 1: Terminal / Command Line
1. Clone the repository:
   git clone https://github.com/ahmedmohiuddin455/evento.git

2. Navigate to project directory:
   cd evento

3. Build the application:
   .\mvnw clean package -DskipTests

4. Run the application:
   .\mvnw spring-boot:run

### Option 2: IntelliJ IDEA / Eclipse
1. File -> Open -> Select the project root folder.
2. Allow Maven to import all dependencies automatically.
3. Locate `src/main/java/com/example/evento/EventoApplication.java`.
4. Right-click `EventoApplication.java` and select **Run**.

---

## 🌐 Endpoints & Feature Walkthrough

Once started, access the application at: `http://localhost:8080` or `https://evento-6kkv.onrender.com`

| Route | Functionality | Access Level |
| :--- | :--- | :--- |
| `/` | Browse all active events | Public |
| `/register` | Account registration (USER / ADMIN selection) | Public |
| `/login` | User authentication | Public |
| `/events` | Main dashboard to view and book tickets | USER / ADMIN |
| `/book-ticket` | View ticket receipt with EVT-Tracking ID & Scannable QR Code | USER / ADMIN |
| `/admin` | Create new events and delete existing ones | ADMIN Only |

---

## 🧪 Testing Workflow for Reviewers

1. Go to `/register` and create two accounts:
   - One with role **ADMIN**
   - One with role **USER**
2. Log in as **ADMIN** -> Navigate to `/admin` -> Create a new event.
3. Log in as **USER** -> Navigate to `/events` -> Select an event and book a ticket.
4. Verify ticket details and dynamic QR code generated at `/book-ticket`.
