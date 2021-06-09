package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminWhitelistModel {
    Connection connection;

    public AdminWhitelistModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public void isWhitelist(String username) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "UPDATE employee set prev_Seat = null where username = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
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
            e.printStackTrace();
            return false;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
}
