import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

public class Test {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String TABLE_NAME = "minions_db";
    private static Connection connection;

    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        connection = getConnection();

        System.out.println("Enter Id: ");
        int id = Integer.parseInt(reader.readLine());

        CallableStatement callableStatement = connection.prepareCall(
                "CALL `usp_get_older`(?)");
        callableStatement.setInt(1, id);
        callableStatement.execute();

        PreparedStatement prepareOutput = connection.prepareStatement(
                "SELECT `name` , `age` FROM minions;");

        ResultSet resultSet = prepareOutput.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter user:");
        String user = reader.readLine();
        System.out.println("Enter password:");
        String password = reader.readLine();
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        return DriverManager.getConnection(CONNECTION_STRING + TABLE_NAME, properties);
    }
}
