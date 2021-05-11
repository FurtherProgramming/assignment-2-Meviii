package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.model.LoginModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeePanelController implements Initializable {
    LoginModel epl = new LoginModel();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (epl.isDbConnected()){
            //isConnected.setText("Connected");
        }else{
            //isConnected.setText("Not Connected");
        }

    }

    @FXML
    private Button btnStaffToMainLogin;
    public void StaffToMainLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/login.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnStaffToMainLogin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}