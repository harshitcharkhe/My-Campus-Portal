//practical 18 program code 1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDatabaseApp {

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

            // 3. Create a student table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(255), "
                    + "age INT)";
            statement.execute(createTableSQL);
            System.out.println("Student table created successfully.");

            // 4. Insert a record into the student table
            String insertSQL = "INSERT INTO student (name, age) VALUES ('John Doe', 20)";
            String insertSQL1 = "INSERT INTO student (name, age) VALUES ('John Wick', 40)";
            int rowsAffected = statement.executeUpdate(insertSQL);
            int rowsAffected1 = statement.executeUpdate(insertSQL1);
            if (rowsAffected > 0 && rowsAffected1 > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert the record.");
            }

            // 5. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
