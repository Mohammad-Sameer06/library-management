# 📚 Library Management System

A full-stack web application built with Spring Boot to manage library books, secure user roles, and track borrowing records.

## ✨ Features
* **Role-Based Access Control:** Distinct permissions for Admins (Librarians) and Users (Students) using Spring Security.
* **Book Management:** Admins can easily add new books to the library database.
* **Interactive Borrowing:** Users can borrow and return books with a single click.
* **Real-time Status:** Dynamic UI badges showing whether a book is "Available" or "Borrowed".
* **Automated Data Seeding:** The database comes pre-loaded with sample books on startup.

## 🛠️ Tech Stack
* **Backend:** Java, Spring Boot, Spring Data JPA, Spring Security
* **Frontend:** HTML5, Thymeleaf, Bootstrap 5
* **Database:** H2 (In-Memory Database)
* **Tools:** Maven, Lombok

## 🚀 How to Run the Application
1. Clone this repository to your local machine.
2. Open the project in IntelliJ IDEA (or your preferred Java IDE).
3. Run the `LibraryApplication.java` main class.
4. Open your web browser and navigate to `http://localhost:8080/home`.

## 🔐 Default Login Credentials
The application includes two default accounts to test the role-based security:

**Administrator (Can add books):**
* **Username:** `admin`
* **Password:** `admin123`

**Student (Can only view, borrow, and return books):**
* **Username:** `student`
* **Password:** `password123`