import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P20_Ex2_DeleteProductsGreaterThan500 {

    // JDBC URL, username, and password for your database
    private static final String URL = "jdbc:mysql://localhost:3306/msbte";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try {
            // 1. Establish a database connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Delete rows where product_price is greater than 500
            String deleteSQL = "DELETE FROM product WHERE product_price > 500.0";

            // Execute the delete statement
            int rowsDeleted = statement.executeUpdate(deleteSQL);

            if (rowsDeleted > 0) {
                System.out.println("Records with product_price > 500 deleted successfully.");
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
