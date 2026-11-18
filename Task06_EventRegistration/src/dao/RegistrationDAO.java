
package dao;

import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class RegistrationDAO {

    public boolean register(String name, String regNo,
                            String email, String event) throws SQLException {

        String sql = "INSERT INTO registrations " +
            "(student_name, register_number, email, event_name) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, regNo);
            ps.setString(3, email);
            ps.setString(4, event);

            return ps.executeUpdate() > 0;
        }
    }

    public List<String[]> getRegistrations(String filter,
                                            int limit, int offset)
                                            throws SQLException {
        List<String[]> rows = new ArrayList<>();

        String sql = "SELECT registration_id, student_name, register_number, " +
            "email, event_name FROM registrations " +
            "WHERE event_name LIKE ? ORDER BY registration_id " +
            "LIMIT ? OFFSET ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + filter + "%");
            ps.setInt(2, limit);
            ps.setInt(3, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rows.add(new String[] {
                        rs.getString("registration_id"),
                        rs.getString("student_name"),
                        rs.getString("register_number"),
                        rs.getString("email"),
                        rs.getString("event_name")
                    });
                }
            }
        }
        return rows;
    }
}
