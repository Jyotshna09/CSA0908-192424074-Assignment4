
package service;

import dao.RegistrationDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class RegistrationService {

    private final RegistrationDAO dao = new RegistrationDAO();

    public void register(String name, String regNo,
                         String email, String event)
                         throws Exception {

        if (name.isBlank() || regNo.isBlank() ||
            email.isBlank() || event.isBlank()) {
            throw new Exception("All fields are required.");
        }

        if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                             email)) {
            throw new Exception("Enter a valid email address.");
        }

        try {
            dao.register(name.trim(), regNo.trim(),
                         email.trim(), event);
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new Exception("This register number is already registered.");
            }
            throw ex;
        }
    }

    public List<String[]> getRegistrations(String filter,
                                            int limit, int offset)
                                            throws Exception {
        return dao.getRegistrations(filter, limit, offset);
    }
}
