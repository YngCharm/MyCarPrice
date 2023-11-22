package com.example.mycarprice;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBConnector dbConnector = new DBConnector();
        dbConnector.connect();
    }
}
