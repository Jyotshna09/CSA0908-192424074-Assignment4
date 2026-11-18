
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame {

    private JTextField rupeesField;
    private JLabel resultLabel;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setLayout(new GridLayout(4, 2, 10, 10));

        rupeesField = new JTextField();
        resultLabel = new JLabel("Result: ");

        JButton button1 = new JButton("ActionListener");
        JButton button2 = new JButton("Inner Class");
        JButton button3 = new JButton("Anonymous Class");
        JButton button4 = new JButton("Lambda");

        add(new JLabel("Amount in INR:"));
        add(rupeesField);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(new JLabel("Conversion:"));
        add(resultLabel);

        // 1. ActionListener implementation
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        // 2. Named inner class
        button2.addActionListener(new InnerHandler());

        // 3. Anonymous inner class
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        // 4. Lambda expression
        button4.addActionListener(e -> convert());

        // Enter key support
        rupeesField.addActionListener(e -> convert());

        setSize(550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void convert() {
        try {
            double inr = Double.parseDouble(rupeesField.getText());

            if (inr < 0) {
                throw new NumberFormatException();
            }

            double usd = inr / 83.0;

            resultLabel.setText(
                    String.format("USD: $%.2f", usd)
            );

            JOptionPane.showMessageDialog(
                    this,
                    String.format("Converted Amount: $%.2f", usd),
                    "Conversion Result",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid non-negative amount.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Named inner class
    private class InnerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            convert();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CurrencyConverter().setVisible(true);
        });
    }
}
