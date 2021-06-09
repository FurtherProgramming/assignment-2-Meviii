package main.model;

import main.SQLConnection;

import java.sql.Connection;

public class AdminPanelModel {
    Connection connection;

    public AdminPanelModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }
}
