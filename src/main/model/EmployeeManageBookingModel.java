package main.model;

import javafx.fxml.FXML;
import main.SQLConnection;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.sql.*;

public class EmployeeManageBookingModel {

    Connection connection;

    public EmployeeManageBookingModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public String isCheckBooking(String username) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String ret = "";
        int i = 1;

        String query = "select seatNum, date, status from booking where username = ?";
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

    public void isRemoveBooking(String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "UPDATE booking set username = null, date = null where username = ?";

        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
