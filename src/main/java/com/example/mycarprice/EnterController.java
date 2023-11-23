package com.example.mycarprice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EnterController implements Initializable {
    @FXML
    public ListView carList;
    public TextField addField;
    public Button addButton;
    public Button removeButton;
    public Label adminLabel;
    public Button changeButton;
    ObservableList<String> prices = FXCollections.observableArrayList();


    public void printPrice() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myCarPrice", "postgres", "admin");
        try {
            Class.forName("org.postgresql.Driver");
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

            carList.setItems(prices);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        blockAdmin();
        try {
            printPrice();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void blockAdmin(){
       if(!HelloController.isAdmin){
           addButton.setDisable(true);
           addField.setDisable(true);
           adminLabel.setDisable(true);
           removeButton.setDisable(true);
           changeButton.setDisable(true);

           addButton.setVisible(false);
           addField.setVisible(false);
           adminLabel.setVisible(false);
           removeButton.setVisible(false);
           changeButton.setVisible(false);
       }
    }

    public void addButtonClick(ActionEvent actionEvent) {
    }

    public void removeButtonClick(ActionEvent actionEvent) {
    }

    public void changeButtonClick(ActionEvent actionEvent) {
    }
}
