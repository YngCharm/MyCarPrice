package com.example.mycarprice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.*;

public class EnterController {
    @FXML
    public ListView carList;
    ObservableList<String> prices = FXCollections.observableArrayList();

    public void printPrice() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myCarPrice", "postgres", "admin");
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
            String price = resultSet.getString("price");

            prices.add(model);
            prices.add(price);
        }
    }
}
