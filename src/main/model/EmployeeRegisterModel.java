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

    /*public Boolean isRegister(String user, String pass, String name, String surname, String age) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;

        String query = "insert into employee(name = ?, surname = ?, age = ?, user = ?, pass = ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, user);
            preparedStatement.setString(5, pass);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){

                return true;
            }else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
    }*/

    public void isRegister(String name, String surname, String age, String username, String password) throws SQLException {

            String query = "INSERT INTO employee(name , surname, age, username, password) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
