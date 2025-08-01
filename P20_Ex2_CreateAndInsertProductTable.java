import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P20_Ex2_CreateAndInsertProductTable {

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

            // 3. Create the product table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS product ("
                    + "product_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "product_name VARCHAR(255), "
                    + "product_price DECIMAL(10, 2))";
            statement.execute(createTableSQL);
            System.out.println("Product table created successfully.");

            // 4. Insert data into the product table
            String insertSQL1 = "INSERT INTO product (product_name, product_price) VALUES ('Product A', 19.99)";
            String insertSQL2 = "INSERT INTO product (product_name, product_price) VALUES ('Product B', 29.99)";
            statement.executeUpdate(insertSQL1);
            statement.executeUpdate(insertSQL2);
            String insertSQL3 = "INSERT INTO product (product_name, product_price) VALUES ('Product C', 600)";
            String insertSQL4 = "INSERT INTO product (product_name, product_price) VALUES ('Product D', 700)";
            statement.executeUpdate(insertSQL3);
            statement.executeUpdate(insertSQL4);

            System.out.println("Data inserted successfully.");

            // 5. Close the resources
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
