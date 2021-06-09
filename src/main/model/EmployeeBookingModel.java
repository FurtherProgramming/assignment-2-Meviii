package main.model;

import main.SQLConnection;

import java.sql.*;
import java.util.Calendar;

public class EmployeeBookingModel {
    Connection connection;

    public EmployeeBookingModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

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

    public Boolean isBookingNotNull(int seatNum) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select * from booking where status = 'vacant' and seatNum = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, seatNum);

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


    public void isBooking(String date, String username, String status, int seatNum) throws SQLException {
        PreparedStatement preparedStatement = null;
        Calendar calendar = Calendar.getInstance();
        Timestamp ts = new Timestamp(calendar.getTime().getTime());
        Date dte = new Date(ts.getTime());

        String sql = "insert into booking (date, username, status, TIMESTAMP(NOW()) as timestamp) VALUES (?,?,?)";
        String query = "UPDATE booking SET date = ?, username = ?, status = ?, timestamp = ? where seatnum = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, status);
            preparedStatement.setDate(4, dte);
            preparedStatement.setInt(5, seatNum);

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
    public String isPrevSeat(String user) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select prev_seat from employee where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("prev_seat");
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

    public String isCurrentlyLockdown(String username){
        String sql = "select lockdown from booking where username = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            rs = preparedStatement.executeQuery();

            if(rs.next()){
                return rs.getString("lockdown");
            }else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
