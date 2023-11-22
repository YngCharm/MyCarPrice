package com.example.mycarprice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {

    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myCarPrice", "postgres", "admin");
        try {
            Class.forName("org.postgresql.Driver");

            System.out.println("Connection successed!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
        String request = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(request);
        while (resultSet.next()) {
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");

            if (login.equals(loginField.getText()) && password.equals(passwordField.getText())){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("enter.fxml"));
                Stage enterStage = new Stage();
                Scene enter = new Scene(fxmlLoader.load(), 320, 240);
                enterStage.setScene(enter);
                enterStage.show();
            }
        }
    }
}