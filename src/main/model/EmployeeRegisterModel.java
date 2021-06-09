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
    public Boolean isCheckUser(String user) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from employee where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

}
