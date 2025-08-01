import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ShowEmployeeTableStructure {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/kaudb";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try {
            // 1. Establish a database connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Use DatabaseMetaData to retrieve table structure
            DatabaseMetaData metaData = connection.getMetaData();

            // 3. Query the database for table structure
            ResultSet resultSet = metaData.getColumns(null, null, "employee", null);

            // 4. Display the table structure
            System.out.println("Table Structure for 'employee' table:");
            while (resultSet.next()) {
                String columnName = resultSet.getString("COLUMN_NAME");
                String dataType = resultSet.getString("TYPE_NAME");
                int columnSize = resultSet.getInt("COLUMN_SIZE");

                System.out.println("Column Name: " + columnName);
                System.out.println("Data Type: " + dataType);
                System.out.println("Column Size: " + columnSize);
                System.out.println();
            }

            // 5. Close the resources
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
