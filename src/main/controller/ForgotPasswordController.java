package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.AdminLoginModel;
import main.model.ForgotPasswordModel;
import main.model.LoginModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ForgotPasswordController{
    public ForgotPasswordModel fpm = new ForgotPasswordModel();

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

    @FXML
    private Button btnForgPassToChanPass;
    @FXML
    private TextField txtForgPassUsername;
    @FXML
    private Label txtIncorrectUsername;
    public void ForgPassToChanPass(ActionEvent event) throws IOException {
        try {

            if (fpm.isCheck(txtForgPassUsername.getText())) {
                User u = new User(txtForgPassUsername.getText());
                UserHolder holder = UserHolder.getInstance();
                holder.setUser(u);

                FXMLLoader loader = new FXMLLoader();
                String address = "src/main/ui/changePassword.fxml";
                InputStream fxmlStream = new FileInputStream(address);
                Parent root = loader.load(fxmlStream);

                Stage stage = (Stage) btnForgPassToChanPass.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

            }else{
                txtIncorrectUsername.setText("Incorrect Username");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*@FXML
    private Label txtForgPassSecreQuestion;
    public void ForgPassUpdate(ActionEvent event) throws IOException{
        try{

        }catch (SQLException e){
            e.printStackTrace();
        }

    }*/

}
