
package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EventRegistrationApp extends JFrame {

    private final List<String[]> registrations = new ArrayList<>();
    private final int PAGE_SIZE = 10;
    private int page = 0;
    private int nextId = 1;

    private JTextField nameField, regField, emailField;
    private JComboBox<String> eventBox, filterBox;
    private DefaultTableModel model;
    private JTable table;

    public EventRegistrationApp() {
        setTitle("Campus Event Registration System");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(4, 2, 8, 8));
        form.setBorder(BorderFactory.createTitledBorder("Student Registration"));

        nameField = new JTextField();
        regField = new JTextField();
        emailField = new JTextField();

        eventBox = new JComboBox<>(new String[]{
            "Tech Fest", "Cultural Fest", "Sports Meet", "Workshop"
        });

        form.add(new JLabel("Student Name:"));
        form.add(nameField);
        form.add(new JLabel("Register Number:"));
        form.add(regField);
        form.add(new JLabel("Email:"));
        form.add(emailField);
        form.add(new JLabel("Select Event:"));
        form.add(eventBox);

        JButton registerButton = new JButton("Register");
        JButton clearButton = new JButton("Clear");

        JPanel formButtons = new JPanel();
        formButtons.add(registerButton);
        formButtons.add(clearButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(form, BorderLayout.CENTER);
        topPanel.add(formButtons, BorderLayout.SOUTH);

        model = new DefaultTableModel(
            new String[]{"ID", "Name", "Register Number", "Email", "Event"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);

        filterBox = new JComboBox<>(new String[]{
            "All Events", "Tech Fest", "Cultural Fest",
            "Sports Meet", "Workshop"
        });

        JButton filterButton = new JButton("Apply Filter");
        JButton previousButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        JButton exportButton = new JButton("Export CSV");

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Event Filter:"));
        bottom.add(filterBox);
        bottom.add(filterButton);
        bottom.add(previousButton);
        bottom.add(nextButton);
        bottom.add(exportButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        registerButton.addActionListener(e -> registerStudent());
        clearButton.addActionListener(e -> clearForm());

        filterButton.addActionListener(e -> {
            page = 0;
            loadData();
        });

        previousButton.addActionListener(e -> {
            if (page > 0) page--;
            loadData();
        });

        nextButton.addActionListener(e -> {
            if ((page + 1) * PAGE_SIZE < getFilteredData().size()) {
                page++;
            }
            loadData();
        });

        exportButton.addActionListener(e -> exportCSV());

        loadData();
    }

    private void registerStudent() {
        String name = nameField.getText().trim();
        String reg = regField.getText().trim();
        String email = emailField.getText().trim();
        String event = (String) eventBox.getSelectedItem();

        if (name.isEmpty() || reg.isEmpty() || email.isEmpty()) {
            showMessage("Please fill in all fields.");
            return;
        }

        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            showMessage("Please enter a valid email address.");
            return;
        }

        for (String[] row : registrations) {
            if (row[2].equalsIgnoreCase(reg)) {
                showMessage("This register number is already registered.");
                return;
            }
        }

        registrations.add(new String[]{
            String.valueOf(nextId++), name, reg, email, event
        });

        JOptionPane.showMessageDialog(this,
            "Registration successful!");

        clearForm();
        page = 0;
        loadData();
    }

    private List<String[]> getFilteredData() {
        List<String[]> filtered = new ArrayList<>();
        String selected = (String) filterBox.getSelectedItem();

        for (String[] row : registrations) {
            if ("All Events".equals(selected) || row[4].equals(selected)) {
                filtered.add(row);
            }
        }
        return filtered;
    }

    private void loadData() {
        new SwingWorker<List<String[]>, Void>() {
            @Override
            protected List<String[]> doInBackground() {
                List<String[]> filtered = getFilteredData();
                int start = page * PAGE_SIZE;
                int end = Math.min(start + PAGE_SIZE, filtered.size());

                if (start >= filtered.size()) {
                    return new ArrayList<>();
                }

                return new ArrayList<>(filtered.subList(start, end));
            }

            @Override
            protected void done() {
                try {
                    model.setRowCount(0);
                    for (String[] row : get()) {
                        model.addRow(row);
                    }
                } catch (Exception ex) {
                    showMessage("Unable to load registrations.");
                }
            }
        }.execute();
    }

    private void clearForm() {
        nameField.setText("");
        regField.setText("");
        emailField.setText("");
        eventBox.setSelectedIndex(0);
    }

    private void exportCSV() {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(
            new java.io.File("CampusRegistrations.csv"));

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try (FileWriter writer =
                    new FileWriter(chooser.getSelectedFile())) {

                writer.write("ID,Name,Register Number,Email,Event\n");

                for (String[] row : getFilteredData()) {
                    for (int i = 0; i < row.length; i++) {
                        writer.write("\"" +
                            row[i].replace("\"", "\"\"") + "\"");

                        if (i < row.length - 1) {
                            writer.write(",");
                        }
                    }
                    writer.write("\n");
                }

                JOptionPane.showMessageDialog(this,
                    "CSV file exported successfully!");

            } catch (Exception ex) {
                showMessage("CSV export failed.");
            }
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            new EventRegistrationApp().setVisible(true));
    }
}
