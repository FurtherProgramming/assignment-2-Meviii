package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminReleaseBookingModel {
    Connection connection;

    public AdminReleaseBookingModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public String isCheckBooking(String username) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String ret = "";
        int i = 1;

        String query = "select seatNum, date, status, timestamp from booking where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                for (i = 1; i <= 3; i++){
                    ret += resultSet.getString(i) + "   ";
                }
            }
        } catch (Exception e) {
            return null;
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        return ret;
    }

    public void isDeclineBooking(String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "UPDATE booking set status = 'vacant', timestamp = null, username = null, date = null where username = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void isPrevSeat(int prevSeat, String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "UPDATE employee set prev_Seat = ? where username = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, prevSeat);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public String isSeatNum(String user) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select seatNum from booking where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("seatNum");
            }
            else{
                return null;
            }
        }
        catch (Exception e)
        {
            return null;
        }finally {
            preparedStatement.close();
            resultSet.close();
        }
    }

    public void isAcceptBooking(String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "UPDATE booking set status = 'Confirmed' where username = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
