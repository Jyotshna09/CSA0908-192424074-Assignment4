# Task 3 – Campus Library Search Screen
## Layout Manager Analysis

### 1. Introduction

Layout managers in Java Swing arrange GUI components automatically within containers. They help create responsive interfaces that adjust when the application window is resized.

The Campus Library Search Screen uses multiple layout managers to organize the search form, book table, and application header.

### 2. Layout Managers Used

| Layout Manager | Application Area | Purpose |
|---|---|---|
| BorderLayout | Main JFrame | Divides the window into North, South, East, West, and Center regions |
| GridBagLayout | Search Panel | Arranges labels, text fields, and buttons flexibly |
| FlowLayout | Not used in the current implementation | Can arrange components sequentially in a row |

### 3. Nested Layout Design

The application uses BorderLayout as its main layout manager.

- North: Displays the application title.
- West: Contains the search form and category selection.
- Center: Displays the book details in a JTable.
- South: Displays the application footer.

GridBagLayout is used inside the search panel to align labels, text fields, and buttons. This nested layout approach provides better organization and flexibility.

### 4. Window Resize Testing

The application was tested using three different window dimensions.

| Test | Window Size | Observation |
|---|---|---|
| Normal | 850 × 500 | Search form and book table are displayed clearly |
| Small | 550 × 380 | Components remain visible with reduced space |
| Large | 1100 × 700 | Book table receives additional display space |

The application adjusts its component arrangement when the window size changes. The minimum window size prevents excessive shrinking.

### 5. Alternative Layout Approaches

**GridBagLayout**

GridBagLayout provides flexible positioning using rows, columns, weights, and constraints. It is suitable for complex forms containing different component sizes. However, it requires more configuration.

**Absolute Positioning**

Absolute positioning uses fixed coordinates to place components. It may be simple for fixed-size interfaces, but components do not automatically adjust when the window is resized. Therefore, it is not recommended for responsive applications.

### 6. Conclusion

The combination of BorderLayout and GridBagLayout provides a structured and flexible interface for the Campus Library Search Screen. Nested layouts improve component organization and support different window sizes. Layout managers are preferable to absolute positioning because they provide better resizing behavior and maintainability.