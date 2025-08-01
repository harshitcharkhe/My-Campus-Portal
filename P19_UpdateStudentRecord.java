import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P19_UpdateStudentRecord {

    // JDBC URL, username, and password for your MSBTE database
    private static final String URL = "jdbc:mysql://localhost:3306/msbte";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try {
            // 1. Establish a database connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Define the SQL update statement
            String updateSQL = "UPDATE student SET name = 'New Name', percentage = 85.5 WHERE roll_no = 123";

            // Execute the update statement
            int rowsUpdated = statement.executeUpdate(updateSQL);

            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Record not found or update failed.");
            }

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
