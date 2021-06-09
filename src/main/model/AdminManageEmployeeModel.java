package main.model;

import main.SQLConnection;

import java.sql.Connection;

public class AdminManageEmployeeModel {
    Connection connection;

    public AdminManageEmployeeModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }
}
