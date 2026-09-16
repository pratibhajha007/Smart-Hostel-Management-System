# 🏠 Smart Hostel Management System

A simple Java-based hostel management application developed using Object-Oriented Programming concepts. The project helps manage students, rooms, complaints, and hostel fees through a menu-driven console application.

## 📌 Features

* Student registration
* Add single and shared rooms
* Allocate rooms to students
* Vacate rooms
* View student details
* View room details and availability
* Submit maintenance and electrical complaints
* Resolve complaints
* Calculate monthly hostel fees
* Save and load data using text files
* Basic exception handling for invalid input

## 🛠️ Technologies Used

* **Language:** Java
* **IDE:** Visual Studio Code
* **Data Storage:** Text files
* **Java Concepts:** OOP, ArrayList, Interfaces, Exception Handling, File Handling

## 🧩 OOP Concepts Used

* **Encapsulation** – Private variables with getters and setters
* **Inheritance** – Student extends Person; room and complaint classes use inheritance
* **Polymorphism** – Method overriding for different room and complaint types
* **Abstraction** – `FeeCalculable` interface
* **Classes & Objects** – Used throughout the project

## 📂 Project Structure

```text
SmartHostelManagement
│
├── src
│   ├── Main.java
│   ├── InputHelper.java
│   ├── FileManager.java
│   ├── Person.java
│   ├── Student.java
│   ├── Room.java
│   ├── SingleRoom.java
│   ├── SharedRoom.java
│   ├── Hostel.java
│   ├── Complaint.java
│   ├── MaintenanceComplaint.java
│   ├── ElectricalComplaint.java
│   └── FeeCalculable.java
│
└── data
    ├── students.txt
    ├── rooms.txt
    └── complaints.txt
```

## ▶️ How to Run

### 1. Open the project in VS Code

Open the `SmartHostelManagement` folder in Visual Studio Code.

### 2. Open the terminal

Run:

```bash
javac src\*.java
```

### 3. Start the program

```bash
java -cp src Main
```

## 💰 Hostel Fees

| Room Type   | Monthly Fee |
| ----------- | ----------: |
| Single Room |    Rs. 8000 |
| Shared Room |    Rs. 5000 |

## 💾 Data Storage

The application stores information in the `data` folder:

* `students.txt` – Student information
* `rooms.txt` – Room information
* `complaints.txt` – Complaint information

Saved data can be loaded when the application is started again.

## 🎯 Purpose

The main purpose of this project is to demonstrate how Java and OOP concepts can be applied to a practical real-world problem. It also provides hands-on experience with inheritance, polymorphism, interfaces, collections, exception handling, and file handling.

## 👩‍💻 Project

**Smart Hostel Management System**

Developed as a Java OOP academic project.
