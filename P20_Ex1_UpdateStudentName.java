import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P20_Ex1_UpdateStudentName {

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

            // 3. Update the student name from Jack to John
            String updateSQL = "UPDATE student SET name = 'John' WHERE name = 'Jack'";

            // Execute the update statement
            int rowsUpdated = statement.executeUpdate(updateSQL);

            if (rowsUpdated > 0) {
                System.out.println("Name updated successfully.");
            } else {
                System.out.println("Update failed or no matching records found.");
            }

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
