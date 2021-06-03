package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import main.SQLConnection;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminGenerateBookingModel {
    Connection c;

    public AdminGenerateBookingModel(){

        c = SQLConnection.connect();
        if (c == null)
            System.exit(1);

    }

    public String isCurrentBookings() {
        try{
        String sql = "select * from booking";
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
            int seatNum = rs.getInt("seatNum");
            String status = rs.getString("status");
            Boolean lockdown = rs.getBoolean("lockdown");
            String date = rs.getString("date");
            String username = rs.getString("username");

            String line = String.format("\"%x\", %s, %b, %s, %s", seatNum, status, lockdown, date, username);
            return line;
        }
        statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void isBookingInfo(){
        try{
            String csvFilePath = "src/main/booking.csv";
            String sql = "select * from booking";

            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            BufferedWriter fw = new BufferedWriter(new FileWriter(csvFilePath));

            fw.write("seatNum  ||  status ||  lockdown  ||  date  ||  username  ");

            while (rs.next()){
                int seatNum = rs.getInt("seatNum");
                String status = rs.getString("status");
                Boolean lockdown = rs.getBoolean("lockdown");
                String date = rs.getString("date");
                String username = rs.getString("username");

                String line = String.format("\"%x\", %s, %b, %s, %s", seatNum, status, lockdown, date, username);

                fw.newLine();
                fw.write(line);
            }
            statement.close();
            fw.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}