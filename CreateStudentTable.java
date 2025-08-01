//practical 18 Exercise 2 (Table)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateStudentTable {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/kaudb";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try {
            // 1. Establish a database connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Create the student table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student1 ("
                    + "roll_no INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "percentage DOUBLE)";
            statement.execute(createTableSQL);
            System.out.println("Student table created successfully.");

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
