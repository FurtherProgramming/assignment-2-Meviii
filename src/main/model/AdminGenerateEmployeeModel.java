package main.model;

import main.SQLConnection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminGenerateEmployeeModel {
    Connection c;

    public AdminGenerateEmployeeModel(){

        c = SQLConnection.connect();
        if (c == null)
            System.exit(1);
    }

    public void isEmployeeInfo(){
        try{
            String csvFilePath = "src/main/employees.csv";
            String sql = "select * from employee";

            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            BufferedWriter fw = new BufferedWriter(new FileWriter(csvFilePath));

            fw.write("id  ||  name  ||  surname  ||  age  ||  username  ||  password  ||  secret_question  ||  secret_answer  ||  active  ");

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String secret_question = rs.getString("secret_question");
                String secret_answer = rs.getString("secret_answer");
                Boolean active = rs.getBoolean("active");

                String line = String.format("\"%x\", %s, %s, %x, %s, %s, %s, %s, %b", id, name, surname, age, username, password, secret_question, secret_answer, active);

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
