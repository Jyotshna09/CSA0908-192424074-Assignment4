# 2. Component Hierarchy

The Hospital Appointment Desk is designed using Java Swing components. A JFrame acts as the main window and contains panels, labels, text fields, combo boxes, buttons, and a table.

### Component Structure

```text
HospitalAppointmentDesk (JFrame)
│
├── HeaderPanel (JPanel)
│   └── TitleLabel (JLabel)
│
├── PatientDetailsPanel (JPanel)
│   ├── PatientNameLabel (JLabel)
│   ├── PatientNameField (JTextField)
│   ├── PatientIDLabel (JLabel)
│   └── PatientIDField (JTextField)
│
├── AppointmentPanel (JPanel)
│   ├── DepartmentLabel (JLabel)
│   ├── DepartmentComboBox (JComboBox)
│   ├── DoctorLabel (JLabel)
│   ├── DoctorComboBox (JComboBox)
│   └── AppointmentDatePicker
│
├── ButtonPanel (JPanel)
│   ├── BookButton (JButton)
│   ├── SearchButton (JButton)
│   ├── CancelButton (JButton)
│   └── ClearButton (JButton)
│
└── AppointmentTable (JTable)
    └── Displays appointment details
```

### Description of Components

1. **JFrame:** Provides the main application window.
2. **JPanel:** Groups related components into separate sections.
3. **JLabel:** Displays field names and instructions.
