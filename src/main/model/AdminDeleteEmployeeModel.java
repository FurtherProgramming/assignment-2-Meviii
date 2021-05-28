package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDeleteEmployeeModel {
    Connection connection;

    public AdminDeleteEmployeeModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }
    public Boolean isCheckUser(String user) throws SQLException {
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
    public void isDeleteUser(String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "delete from employee where username = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
