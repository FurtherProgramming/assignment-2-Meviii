package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.ForgotPasswordModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChangePasswordController implements Initializable {
    ForgotPasswordModel fpm = new ForgotPasswordModel();

    @FXML
    private Label lblForgPassSecreQuestion;
    @Override
    public void initialize(URL location, ResourceBundle resources){

        UserHolder holder = UserHolder.getInstance();
        User u = holder.getUser();
        String username = u.getUsername();

        try {
            lblForgPassSecreQuestion.setText("NEED TO FIX");
        } catch (Exception e) {
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
