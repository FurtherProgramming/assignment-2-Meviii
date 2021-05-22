package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRegisterModel {

    Connection connection;

    public EmployeeRegisterModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected(){
        try {
            return !connection.isClosed();
        }
        catch(Exception e){
            return false;
        }
    }

    public void isRegister(String name, String surname, String age, String username, String password, String secret_question, String secret_answer) throws SQLException {

            String query = "INSERT INTO employee(name , surname, age, username, password, secret_question, secret_answer) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, secret_question);
            preparedStatement.setString(7, secret_answer);
            preparedStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
