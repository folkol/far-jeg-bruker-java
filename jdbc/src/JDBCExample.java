import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/webapp", "root", "");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, name FROM Member";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String first = rs.getString("name");
                System.out.print("ID: " + id);
                System.out.println(", First: " + first);
            }
            rs.close();
            stmt.close();
            conn.close();
    }
}
