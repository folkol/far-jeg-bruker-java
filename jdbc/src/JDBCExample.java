import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbcexample", "mart", "mart");
        Statement stmt = conn.createStatement();
        String sql = "SELECT id, data FROM mytable";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String first = rs.getString("data");
            System.out.print("ID: " + id);
            System.out.println(", Data: " + first);
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
