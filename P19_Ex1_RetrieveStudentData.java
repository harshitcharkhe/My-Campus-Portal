import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P19_Ex1_RetrieveStudentData {

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

            // 3. Query the database to retrieve data
            String query = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(query);

            // 4. Display the retrieved data
            while (resultSet.next()) {
                int rollNo = resultSet.getInt("roll_no");
                String name = resultSet.getString("name");
                double percentage = resultSet.getDouble("percentage");

                System.out.println("Roll No: " + rollNo);
                System.out.println("Name: " + name);
                System.out.println("Percentage: " + percentage);
                System.out.println();
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
