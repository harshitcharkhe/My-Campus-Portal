//practical 18 exercise 1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateEmployeeTable {

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

            // 3. Create the employee table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                    + "emp_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "emp_name VARCHAR(255))";
            statement.execute(createTableSQL);
            System.out.println("Employee table created successfully.");

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
