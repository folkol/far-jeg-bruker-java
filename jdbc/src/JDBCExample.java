import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/webapp", "root", "");
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM Member";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String first = rs.getString("name");
                // Display values
                System.out.print("ID: " + id);
                System.out.println(", First: " + first);
            }
            // STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
    }
}
