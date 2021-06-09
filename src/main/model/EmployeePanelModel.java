package main.model;

import main.SQLConnection;

import java.sql.Connection;

public class EmployeePanelModel{
    Connection connection;

    public EmployeePanelModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

}
