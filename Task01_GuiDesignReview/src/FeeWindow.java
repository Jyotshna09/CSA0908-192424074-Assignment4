
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeeWindow extends JFrame {

    private JTextField regNoField;
    private JTextField amountField;
    private JButton payButton;
    private JButton clearButton;
    private JButton receiptButton;
    private JLabel statusLabel;

    private FeeService feeService;
    private String lastReceipt = "";

    public FeeWindow() {

        super("Student Fee Payment");

        feeService = new FeeService();

        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel regLabel = new JLabel("Registration Number:");
        regNoField = new JTextField(15);

        JLabel amountLabel = new JLabel("Amount (Rs.):");
        amountField = new JTextField(15);

        payButton = new JButton("Pay");
        clearButton = new JButton("Clear");
        receiptButton = new JButton("Receipt");

        statusLabel = new JLabel("Enter payment details.");

        add(regLabel);
        add(regNoField);

        add(amountLabel);
        add(amountField);

        add(payButton);
        add(clearButton);

        add(receiptButton);
        add(statusLabel);

        add(new JLabel(""));
        add(new JLabel(""));

        // Separate event handling for each button
        payButton.addActionListener(e -> makePayment());

        clearButton.addActionListener(e -> clearFields());

        receiptButton.addActionListener(e -> showReceipt());

        // Handle window closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(450, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    private void makePayment() {

        String regNo = regNoField.getText().trim();
        String amountText = amountField.getText().trim();

        String error = feeService.validatePayment(regNo, amountText);

        if (error != null) {
            JOptionPane.showMessageDialog(
                    this, error, "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        double amount = Double.parseDouble(amountText);

        payButton.setEnabled(false);
        statusLabel.setText("Processing payment...");

        // Background thread keeps the GUI responsive
        SwingWorker<String, Void> worker =
                new SwingWorker<String, Void>() {

            @Override
            protected String doInBackground() {
                return feeService.processPayment(regNo, amount);
            }

            @Override
            protected void done() {
                try {
                    lastReceipt = get();

                    statusLabel.setText("Payment completed.");

                    JOptionPane.showMessageDialog(
                            FeeWindow.this,
                            lastReceipt,
                            "Payment Receipt",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                } catch (Exception ex) {
                    statusLabel.setText("Payment failed.");
                    JOptionPane.showMessageDialog(
                            FeeWindow.this,
                            "Unable to process payment."
                    );
                }

                payButton.setEnabled(true);
            }
        };

        worker.execute();
    }

    private void clearFields() {

        regNoField.setText("");
        amountField.setText("");
        statusLabel.setText("Fields cleared.");
        regNoField.requestFocus();
    }

    private void showReceipt() {

        if (lastReceipt.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No payment receipt available."
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    lastReceipt,
                    "Payment Receipt",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FeeWindow window = new FeeWindow();
            window.setVisible(true);
        });
    }
}
