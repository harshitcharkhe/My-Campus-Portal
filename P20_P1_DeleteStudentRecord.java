import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P20_P1_DeleteStudentRecord {

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

            // 3. Delete the student record with the name "Jack"
            String deleteSQL = "DELETE FROM student WHERE name = 'Jack'";

            // Execute the delete statement
            int rowsDeleted = statement.executeUpdate(deleteSQL);

            if (rowsDeleted > 0) {
                System.out.println("Record for Jack deleted successfully.");
            } else {
                System.out.println("No matching records found for deletion.");
            }

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
