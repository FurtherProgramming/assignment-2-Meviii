package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDeleteModel {
    Connection connection;

    public AdminDeleteModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public void isDelete(String username) throws SQLException {

        String query = "DELETE FROM admin where username = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Boolean isCheckUser(String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from admin where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

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
