package main.model;

import main.SQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManageAccountModel {
    Connection connection;

    public EmployeeManageAccountModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public void isUpdate(String name, String surname, String age, String password, String secret_question, String secret_answer, String userInitial) throws SQLException {

        String query = "UPDATE employee SET name=? , surname=? , age=? , password=? , secret_question=? , secret_answer=? where username =?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, secret_question);
            preparedStatement.setString(6, secret_answer);
            preparedStatement.setString(7, userInitial);
            preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public String isPassword(String username) throws SQLException{
        String query = "select password from employee where username = ?";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            rs = preparedStatement.executeQuery();

            if (rs.next()){
                return rs.getString("password");
            }else{
                return null;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
