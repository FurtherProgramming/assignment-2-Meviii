package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.LoginModel;

import javax.xml.soap.Text;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnAdminPanel;
    @FXML
    private Button mainLogin;

    // Check database connection
    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }else{
            isConnected.setText("Not Connected");
        }

    }
    /* login Action method
       check if user input is the same as database.
     */

    public void Login(ActionEvent event) throws IOException {

        try {
            if (loginModel.isLogin(txtUsername.getText(),txtPassword.getText())){

                FXMLLoader loader = new FXMLLoader();
                String address = "src/main/ui/employeePanel.fxml";
                InputStream fxmlStream = new FileInputStream(address);
                Parent root = loader.load(fxmlStream);

                Stage stage = (Stage) mainLogin.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);

            }else{
                isConnected.setText("Incorrect Login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ChangeToAdminPanel(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminLogin.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

    public void RegisterButtonPushed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/employeeRegister.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }




    //11.2.3 big sur



}
