package student.com;
//This class will manage the database connection and queries
import java.sql.*;

public class DatabaseHelper {

    private static Connection connection;

    // Connect to the database
    public static Connection connectToDatabase() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Record", "root", "root");
                System.out.println("connected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Validate login credentials
    public static boolean validateLogin(String username, String password) {
        try {
            PreparedStatement ps = connectToDatabase().prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();  // If user found, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
