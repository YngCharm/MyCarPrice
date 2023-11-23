package com.example.mycarprice;
import java.sql.*;
public class DBConnector {

    public void connect() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myCarPrice","postgres", "admin");

        try {
            Class.forName("org.postgresql.Driver");

            System.out.println("Connection successed!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        String request = "SELECT * FROM cars";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);
        while (resultSet.next()) {
            String model = resultSet.getString("model");
            String id = resultSet.getString("id");

            System.out.println(model + " " + id);

        }
        }
}
