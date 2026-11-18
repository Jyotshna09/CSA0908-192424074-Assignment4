
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibrarySearchScreen extends JFrame {

    private JTextField searchField;
    private JComboBox<String> categoryBox;
    private JTable bookTable;

    public LibrarySearchScreen() {

        setTitle("Campus Library Search System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Header
        JLabel title = new JLabel(
                "CAMPUS LIBRARY SEARCH",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        // Search panel
        JPanel searchPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanel.add(new JLabel("Book Title:"), gbc);

        searchField = new JTextField(18);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        searchPanel.add(searchField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        searchPanel.add(new JLabel("Category:"), gbc);

        categoryBox = new JComboBox<>(
                new String[]{"All", "Computer Science",
                        "Mathematics", "Electronics", "General"}
        );
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        searchPanel.add(categoryBox, gbc);

        JButton searchButton = new JButton("Search");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        searchPanel.add(searchButton, gbc);

        JButton clearButton = new JButton("Clear");
        gbc.gridx = 1;
        searchPanel.add(clearButton, gbc);

        add(searchPanel, BorderLayout.WEST);

        // Book table
        String[] columns = {
                "Book ID", "Book Title", "Author", "Category", "Availability"
        };

        Object[][] data = {
                {"B101", "Java Programming", "Herbert Schildt",
                        "Computer Science", "Available"},
                {"B102", "Data Structures", "Mark Allen Weiss",
                        "Computer Science", "Issued"},
                {"B103", "Discrete Mathematics", "Kenneth Rosen",
                        "Mathematics", "Available"},
                {"B104", "Digital Electronics", "Morris Mano",
                        "Electronics", "Available"},
                {"B105", "Database Systems", "Ramez Elmasri",
                        "Computer Science", "Available"}
        };

        DefaultTableModel model =
                new DefaultTableModel(data, columns) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

        bookTable = new JTable(model);
        bookTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

        // Footer
        JLabel footer = new JLabel(
                "Library Management System | Search and View Books",
                SwingConstants.CENTER
        );
        add(footer, BorderLayout.SOUTH);

        // Search action
        searchButton.addActionListener(e -> {
            String keyword = searchField.getText().trim().toLowerCase();
            String category = categoryBox.getSelectedItem().toString();

            model.setRowCount(0);

            for (Object[] book : data) {
                String titleText = book[1].toString().toLowerCase();
                String categoryText = book[3].toString();

                boolean titleMatch = titleText.contains(keyword);
                boolean categoryMatch =
                        category.equals("All") ||
                        category.equals(categoryText);

                if (titleMatch && categoryMatch) {
                    model.addRow(book);
                }
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(
                        this, "No books found."
                );
            }
        });

        // Clear action
        clearButton.addActionListener(e -> {
            searchField.setText("");
            categoryBox.setSelectedIndex(0);
            model.setRowCount(0);

            for (Object[] book : data) {
                model.addRow(book);
            }
        });

        setSize(1100, 700);
        setMinimumSize(new Dimension(500, 350));
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LibrarySearchScreen().setVisible(true);
        });
    }
}
