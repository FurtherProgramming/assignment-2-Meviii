package main.model;

import main.SQLConnection;

import java.sql.*;

public class EmployeeManageBookingModel {

    Connection connection;

    public EmployeeManageBookingModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public String isCheckBooking(String username) throws SQLException {

        String sql = "select * from booking where username = ?";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);{
                while (rs.next()){
                    return rs.getString("seatNum");
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
