package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminUpdateEmployeeDetailsModel {
    Connection connection;

    public AdminUpdateEmployeeDetailsModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }
    public void isUpdate(String name, String surname, String age, String username, String password, String secret_question, String secret_answer, String userInitial) throws SQLException {

        String query = "UPDATE employee SET name=? , surname=? , age=? , username=? , password=? , secret_question=? , secret_answer=? where username =?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, secret_question);
            preparedStatement.setString(7, secret_answer);
            preparedStatement.setString(8, userInitial);
            preparedStatement.executeUpdate();

        }catch(SQLException e){
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

    public String isUserDetail(String username) throws SQLException {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String ret = "";
        int i = 1;

        String query = "select * from employee where username = ?";
        try {

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                for (i = 1; i <= 7; i++){
                    ret += resultSet.getString(i) + "  |  ";
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


}

