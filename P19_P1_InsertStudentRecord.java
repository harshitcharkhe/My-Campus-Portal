import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P19_P1_InsertStudentRecord {

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

            // 3. Insert data into the student table
            String insertSQL = "INSERT INTO student (name, percentage, roll_no) VALUES ('New Name', 85.5, 123)";

            // Execute the insert statement
            int rowsInserted = statement.executeUpdate(insertSQL);

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Insert failed.");
            }

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
