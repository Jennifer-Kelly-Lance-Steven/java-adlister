import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class DatabaseDemo {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());

        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/employees?serverTimezone=UTC",
            "root",
            "codeup"
        );

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees LIMIT 100");

        while(resultSet.next()) {
            System.out.printf(
                "{Employee emp_no=%s, first_name=%s, last_name=%s, hire_date=%s}\n",
                resultSet.getLong("emp_no"), resultSet.getString("first_name"),
                resultSet.getString("last_name"), resultSet.getString("hire_date")
            );
        }

        connection.close();
    }
}
