# CSA09 – Programming in Java
## Assignment 4 – CO4: Event-Driven GUI Design

---

## Student Details

| Field | Details |
|---|---|
| Student Name | Jyotshna Singamsetty |
| Register Number | 192424074 |
| Department | Artificial Intelligence and Data Science |
| Batch | 2024–2028 |
| Course Code | CSA09 |
| Assignment | Assignment 4 – CO4 |
| Programming Language | Java |

---

## 1. Project Overview

This repository contains the implementation of Assignment 4 – CO4, focusing on Event-Driven GUI Design using Java.

The assignment explores graphical user interface development, event handling mechanisms, layout managers, event-driven programming concepts, and desktop application development.

Each task is organized into a separate folder containing its source code, documentation, and execution screenshots wherever applicable.

## 2. Assignment Objectives

- Understand Java GUI components and interface design.
- Implement event-driven programming using Java listeners.
- Explore different event-handling techniques.
- Apply Java layout managers to create responsive interfaces.
- Identify and correct event-handling errors.
- Develop a desktop application using Java Swing.
- Practice program organization, documentation, and GitHub version control.

## 3. Repository Structure

```text
CSA0908-192424074-Assignment4/
│
├── Task01_GuiDesignReview/
│   ├── src/
│   ├── output/
│   └── README.md
│
├── Task02_EventDrivenDesign/
│   ├── design/
│   ├── output/
│   └── README.md
│
├── Task03_LayoutManagers/
│   ├── src/
│   ├── output/
│   ├── LayoutManagerAnalysis.md
│   └── README.md
│
├── Task04_EventHandlingForensics/
│   ├── src/
│   ├── output/
│   ├── Forensics.md
│   └── README.md
│
├── Task05_EventHandlingStyles/
│   ├── src/
│   ├── output/
│   ├── EventHandlingComparison.md
│   └── README.md
│
├── Task06_EventRegistration/
│   ├── src/
│   │   └── ui/
│   ├── sql/
│   ├── output/
│   └── README.md
│
└── README.md
```

## 4. Task Description

### Task 1 – GUI Design Review
Designed a fee payment interface using Java Swing. The interface demonstrates input handling, payment actions, receipt generation, and background processing.

### Task 2 – Event-Driven Design
Prepared the event-driven design for a hospital appointment desk, including component hierarchy, event tables, handler pseudocode, and event-flow analysis.

### Task 3 – Layout Managers
Developed a campus library search interface using Java Swing layout managers, including BorderLayout and GridBagLayout. Implemented book searching and category filtering.

### Task 4 – Event-Handling Forensics
Developed a mouse-event-based drawing application. Explored MouseAdapter, MouseEvent, paintComponent(), repaint(), and event-handling corrections.

### Task 5 – Event-Handling Styles
Implemented a currency converter demonstrating four event-handling approaches:
- ActionListener
- Named Inner Class
- Anonymous Inner Class
- Lambda Expression

### Task 6 – Campus Event Registration Desktop Application
Developed a Java Swing application with:
- Student registration form
- Input and email validation
- Duplicate registration prevention
- Event selection and filtering
- JTable registration display
- Pagination
- CSV export
- SwingWorker background loading

**Note:** The current Task 6 implementation uses in-memory storage. Registration data is not retained after the application closes. The SQL folder is included for the database design reference.

## 5. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| Java Swing | GUI development |
| AWT | Layout and event handling |
| Java Collections | Data management |
| SwingWorker | Background processing |
| JDBC / SQL concepts | Database-related study |
| Git and GitHub | Version control and submission |
| Visual Studio Code | Development environment |

## 6. How to Run

Each task can be executed independently.

For Java source files, open the respective task's `src` folder and compile the required Java file.

Example – Task 3:

```bash
cd Task03_LayoutManagers/src
javac LibrarySearchScreen.java
java LibrarySearchScreen
```

Example – Task 4:

```bash
cd Task04_EventHandlingForensics/src
javac DrawPad.java
java DrawPad
```

Example – Task 5:

```bash
cd Task05_EventHandlingStyles/src
javac CurrencyConverter.java
java CurrencyConverter
```

Example – Task 6:

```bash
cd Task06_EventRegistration
javac -d out src/ui/EventRegistrationApp.java
java -cp out ui.EventRegistrationApp
```

## 7. Output Screenshots

The `output` folder inside each task contains screenshots of the application interface, program execution, and relevant test cases.

These screenshots serve as visual evidence of implementation and testing.

## 8. Version Control

The project is maintained using Git and GitHub.

Each task is organized separately, with commits made to track implementation progress and updates.

## 9. Conclusion

This assignment provided practical exposure to Java GUI development and event-driven programming. It helped demonstrate the use of Swing components, event listeners, layout managers, validation, background processing, and desktop application development.

---

**Course:** Programming in Java (CSA09)  
**Assignment:** Assignment 4 – CO4: Event-Driven GUI Design
