//practical 18 exercise B
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudentsWithPercentageAbove70 {

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

            // 3. Query the database to retrieve students with percentage > 70
            String query = "SELECT name, roll_no FROM student1 WHERE percentage > 70";
            ResultSet resultSet = statement.executeQuery(query);

            // 4. Display the students with percentage > 70
            System.out.println("Students with Percentage > 70:");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int rollNo = resultSet.getInt("roll_no");
                System.out.println("Name: " + name + ", Roll No: " + rollNo);
            }

            // 5. Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
