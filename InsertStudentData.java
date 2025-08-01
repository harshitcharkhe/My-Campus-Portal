//practical 18 exercise B inserting data
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertStudentData {

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

            // 3. Insert data into the student table
            String insertSQL1 = "INSERT INTO student1 (name, percentage) VALUES ('John Doe', 85.5)";
            String insertSQL2 = "INSERT INTO student1 (name, percentage) VALUES ('Alice Smith', 72.3)";
            statement.executeUpdate(insertSQL1);
            statement.executeUpdate(insertSQL2);

            System.out.println("Data inserted successfully.");

            // 4. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
