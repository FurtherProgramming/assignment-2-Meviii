package main.model;

import main.SQLConnection;

import java.sql.Connection;

public class AdminManagementModel {
    Connection connection;

    public AdminManagementModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }
}
