package main.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.SQLConnection;

import java.sql.*;

public class EmployeeBookingModel {
    Connection connection;

    public EmployeeBookingModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    /*public Boolean checkVacancy(Boolean vacancy) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select vacancy from booking where vacancy = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, vacancy);

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
    }*/
    public Boolean checkBooking(String user) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from booking where username = ?";
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


    public void isBooking(String date, String username, String status) throws SQLException {
        PreparedStatement preparedStatement = null;
        String query = "insert into booking (date, username, status) VALUES (?,?, ?)";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, username);

            preparedStatement.executeUpdate();

        }
        catch (Exception e)
        {
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
