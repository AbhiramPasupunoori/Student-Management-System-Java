# Student Management System Java

A Java desktop application for managing student records. The project includes a
Swing GUI with login, dashboard, add student, view students, search student,
update student, and delete student screens. It also includes a simple console
version of the student management workflow.

## Software Used

- Java JDK
- Visual Studio Code
- VS Code Java extensions
- Terminal or Command Prompt

## Languages And Technologies Used

- Java
- Java Swing for the desktop user interface
- Java AWT for layouts, colors, fonts, and events
- Java Collections, especially `ArrayList`, for storing student records in
  memory

## Project Structure

Student-Management-System-Java/
|-- README.md
|-- src/
|   |-- App.java
|   |-- Main.java
|   |-- MainFrame.java
|   |-- LoginPanel.java
|   |-- DashboardPanel.java
|   |-- SidebarPanel.java
|   |-- AddStudentPanel.java
|   |-- ViewStudentPanel.java
|   |-- SearchStudentPanel.java
|   |-- UpdateStudentPanel.java
|   |-- DeleteStudentPanel.java
|   |-- Student.java
|   |-- StudentManager.java
|   `-- StudentGUI.java
`-- bin/
    |-- App.class
    |-- Main.class
    |-- Student.class
    `-- StudentManager.class

## Main Files

- `src/App.java` starts the GUI application by opening `MainFrame`.
- `src/MainFrame.java` creates the main desktop window.
- `src/LoginPanel.java` handles login.
- `src/SidebarPanel.java` handles navigation between screens.
- `src/StudentManager.java` contains add, view, search, update, and delete
  logic.
- `src/Student.java` is the student model.
- `src/Main.java` runs a console-based version of the project.

## Requirements

Install Java JDK before running the project.

Check Java:

java -version


Check Java compiler:

javac -version


If both commands show a version number, Java is ready.

## Start The GUI Application

Open a terminal and go to the project folder:

cd /Users/abhiram/Documents/GitHub/Student-Management-System-Java


Compile all Java source files into the `bin` folder:

mkdir -p bin
javac -d bin src/*.java


Run the GUI application:

java -cp bin App


The Student Management System desktop window should open.

## Login Details

Use these credentials on the login screen:

Username: admin
Password: admin123


## Run The Console Version

The project also has a terminal-based version.

Compile the project:

cd /Users/abhiram/Documents/GitHub/Student-Management-System-Java
mkdir -p bin
javac -d bin src/*.java


Run the console app:

java -cp bin Main


## Open The Project

Open the project folder in Finder on macOS:

cd /Users/abhiram/Documents/GitHub/Student-Management-System-Java
open .


Open the project in Visual Studio Code:

cd /Users/abhiram/Documents/GitHub/Student-Management-System-Java
code .


If `code .` does not work, open VS Code manually and choose:

File -> Open Folder -> Student-Management-System-Java


## Run Existing Compiled Files

If the `bin` folder already contains compiled `.class` files, you can run the
GUI without compiling again:

cd /Users/abhiram/Documents/GitHub/Student-Management-System-Java
java -cp bin App


## Rebuild From Scratch

Use this when you want to remove old compiled files and create fresh ones.

On macOS or Linux:

cd /Users/abhiram/Documents/GitHub/Student-Management-System-Java
rm -rf bin
mkdir bin
javac -d bin src/*.java
java -cp bin App


On Windows Command Prompt:

cd path\to\Student-Management-System-Java
rmdir /s /q bin
mkdir bin
javac -d bin src\*.java
java -cp bin App


## Migration

No migration is required for this project.

This is a Java desktop application. It does not use a database, backend server,
or migration tool. Student records are stored in memory using Java collections,
so the data exists only while the program is running.

To update the project, edit the Java files, compile again, and run the app.

## Features

- Login screen
- Dashboard
- Add student
- View students
- Search student by ID
- Update student details
- Delete student
- Console-based student management option

## Notes

- This project does not use Maven or Gradle.
- This project does not require `npm install`, `pip install`, or database setup.
- After changing Java code, run `javac -d bin src/*.java` again before running
  the app.
