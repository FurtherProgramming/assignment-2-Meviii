package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.AdminLoginModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {
    public AdminLoginModel alm = new AdminLoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (alm.isDbConnected()){
            isConnected.setText("Connected");
        }else{
            isConnected.setText("Not Connected");
        }

    }

    @FXML
    private Button adminLogin;
    public void Login(ActionEvent event) throws Exception {

        try {
            if (alm.isLogin(txtUsername.getText(),txtPassword.getText())){
                User u = new User(txtUsername.getText());
                UserHolder holder = UserHolder.getInstance();
                holder.setUser(u);

                FXMLLoader loader = new FXMLLoader();
                String address = "src/main/ui/adminPanel.fxml";
                InputStream fxmlStream = new FileInputStream(address);
                Parent root = loader.load(fxmlStream);

                Stage stage = (Stage) adminLogin.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

            }else{
                isConnected.setText("Incorrect Login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private Button btnBackMainLogin;
    public void BackToMainLogin(ActionEvent event) throws Exception {
        try {
            FXMLLoader load = new FXMLLoader();
            String address = "src/main/ui/login.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = load.load(fxmlStream);


            Stage stage = (Stage) btnBackMainLogin.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}