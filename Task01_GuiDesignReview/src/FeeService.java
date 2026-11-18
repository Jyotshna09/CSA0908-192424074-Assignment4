
public class FeeService {

    public String validatePayment(String regNo, String amountText) {

        if (regNo == null || regNo.trim().isEmpty()) {
            return "Registration number cannot be empty.";
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                return "Amount must be greater than zero.";
            }

            return null;

        } catch (NumberFormatException e) {
            return "Please enter a valid amount.";
        }
    }

    public String processPayment(String regNo, double amount) {

        // Demonstration payment processing.
        // No real bank transaction or database is performed.

        return "Payment Successful!\n"
                + "Registration Number: " + regNo
                + "\nAmount Paid: Rs. " + String.format("%.2f", amount);
    }
}
