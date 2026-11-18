# 4. Event Trace and Design Comparison

## 4.1 Event Trace

An event trace describes the sequence of events that occur when a user books a hospital appointment.

| Step | User Action | Event Generated | System Response |
|---|---|---|---|
| 1 | Enters patient name | Text input | Name is stored in the field |
| 2 | Enters patient ID | Text input | Patient ID is stored |
| 3 | Selects department | ItemEvent | Doctor options are updated |
| 4 | Selects doctor | ItemEvent | Selected doctor is recorded |
| 5 | Selects appointment date | Date selection event | Date is recorded |
| 6 | Clicks Book Appointment | ActionEvent | Input details are validated |
| 7 | Booking is successful | Handler completion | Confirmation message is displayed |
| 8 | Opens appointment list | User action | Appointment details are displayed |

### Event Flow

```text
User Interaction
       |
       v
GUI Component
       |
       v
Event Generated
       |
       v
Event Listener
       |
       v
Event Handler
       |
       v
Validation and Processing
       |
       v
System Response
```

## 4.2 Event-Driven GUI and Applet Lifecycle Comparison

| Event-Driven GUI Application | Java Applet |
|---|---|
| Uses event listeners to respond to user actions | Uses lifecycle methods to manage execution |
| Commonly uses JFrame and Swing components | Traditionally uses the Applet class |
| Handles events such as button clicks and selections | Uses methods such as init(), start(), stop(), and destroy() |
| Runs as a standalone desktop application | Was designed to run inside a browser or applet viewer |
| Application logic is controlled by user events | Execution is influenced by the applet lifecycle |

### Explanation

An event-driven GUI application waits for user interactions and responds through event listeners. For example, clicking the Book Appointment button invokes its ActionListener.

A Java Applet follows a lifecycle consisting of init(), start(), stop(), and destroy(). These methods control initialization, execution, suspension, and termination.

Modern Java desktop applications commonly use Swing or JavaFX instead of browser-based applets, which are obsolete.

## 4.3 Map vs Database Fetching

A Map and database fetching are two different approaches for retrieving appointment information.

| Map-Based Storage | Database Fetching |
|---|---|
| Stores records as key-value pairs | Stores records in database tables |
| Fast access for data held in memory | Retrieves persistent records from a database |
| Suitable for small or temporary data | Suitable for large and permanent records |
| Data is generally lost when the application closes unless saved separately | Data remains available after the application closes |
| Simple to implement | Requires database connection and queries |

### Preferred Approach

For a Hospital Appointment Desk, database fetching is preferred because patient and appointment records must be stored permanently. A database also supports searching, updating, cancelling, and managing a large number of appointments.

A HashMap can be used for temporary in-memory storage or caching, but it should not replace a permanent database in a real hospital system.

### Conclusion

Event-driven programming provides an effective way to build interactive hospital applications. Event listeners handle user actions, component hierarchy organizes the interface, and database connectivity supports reliable appointment management.