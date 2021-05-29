package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.ForgotPasswordModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class ChangePasswordController implements Initializable {
    ForgotPasswordModel fpm = new ForgotPasswordModel();
    UserHolder holder = UserHolder.getInstance();
    User u = holder.getUser();
    String username = u.getUsername();

    @FXML
    private Label lblForgPassSecreQuestion;
    @Override
    public void initialize(URL location, ResourceBundle resources){

        try {
            lblForgPassSecreQuestion.setText(fpm.isSecretQuestion(username));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
    public static String RandomPass(String chars, int length)
    {
        Random randomize = new Random();
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<length; i++)
        {
            builder.append(chars.charAt(randomize.nextInt(chars.length())));
        }
        return builder.toString();
    }

    @FXML
    private TextField txtForgPassSecreAnswer;
    @FXML
    private Label labelUpdateStatus;
    @FXML
    private Label lblNewPass;
    public void UpdatePassword(ActionEvent event) throws SQLException {
        String newPass = RandomPass(chars, 7);
        try{
            labelUpdateStatus.setText(fpm.isSecAnswer(username));
            if (txtForgPassSecreAnswer.getText().isEmpty()){
                labelUpdateStatus.setText("Enter Answer");
            }else if (!txtForgPassSecreAnswer.getText().equals(fpm.isSecAnswer(username))){
                labelUpdateStatus.setText("Incorrect");
            }else if (txtForgPassSecreAnswer.getText().equals(fpm.isSecAnswer(username))){
                labelUpdateStatus.setText("Correct!");
                fpm.isNewPass(newPass, username);
                lblNewPass.setText("Your new password is: " + newPass +".");
            }else{
                labelUpdateStatus.setText("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private Button btnForgPassToMainLogin;
    public void BackToMainLoginFromForgotPass(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/Login.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnForgPassToMainLogin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
