package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLockdownSeatModel {
    Connection c;

    public AdminLockdownSeatModel(){

        c = SQLConnection.connect();
        if (c == null)
            System.exit(1);
    }

    public String isCurrentlyLockdown(String seatnum){
        String sql = "select lockdown from booking where seatnum = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, seatnum);

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

    public void isLockdown(String seatNum, Boolean lockdown){
        String sql = "update booking set lockdown = ? where seatnum = ?";
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, seatNum);
            preparedStatement.setBoolean(2, lockdown);
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void isRemoveBooking(String seatnum) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "UPDATE booking set username = null, date = null, status = 'locked' where seatnum = ?";

        try{
            preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1, seatnum);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
