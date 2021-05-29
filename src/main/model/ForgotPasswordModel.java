package main.model;

import javafx.scene.control.Label;
import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgotPasswordModel {

    Connection connection;

    public ForgotPasswordModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected(){
        try {
            return !connection.isClosed();
        }
        catch(Exception e){
            return false;
        }
    }

    public String isSecretQuestion(String username) throws SQLException{
        String query = "select secret_question from employee where username = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            rs = preparedStatement.executeQuery();

            if (rs.next()){
                return rs.getString("secret_question");
            }else{
                return null;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public String isSecAnswer(String username) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String query = "select secret_answer from employee where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("secret_answer");
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

    public Boolean isCheck(String user ) throws SQLException {
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

    public void isNewPass(String password, String username) throws SQLException {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE employee SET password=? where username =?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
