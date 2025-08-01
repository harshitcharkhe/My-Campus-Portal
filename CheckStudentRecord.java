//practical 18 program code 1
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckStudentRecord {

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

            // 3. Query the database to retrieve the inserted record
            String query = "SELECT * FROM student WHERE name = 'John Wick' AND age = 40";
            ResultSet resultSet = statement.executeQuery(query);

            // 4. Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
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
