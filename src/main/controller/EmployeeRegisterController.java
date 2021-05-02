package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.model.EmployeeRegisterModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeRegisterController implements Initializable {

    EmployeeRegisterModel erc = new EmployeeRegisterModel();

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }
    @FXML
    private Button btnRegToMainLogin;
    public void RegToMainLogin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/login.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnRegToMainLogin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    @FXML
    private TextField txtRegName;
    @FXML
    private TextField txtRegSurname;
    @FXML
    private TextField txtRegAge;
    @FXML
    private TextField txtRegUser;
    @FXML
    private TextField txtRegPass;
    @FXML
    private TextField txtRegRepPass;
    public void Register(ActionEvent event) throws SQLException {
        try {
            erc.isRegister(txtRegUser.getText(), txtRegPass.getText(), txtRegName.getText(), txtRegSurname.getText(), txtRegAge.getText());
        /*if (erc.isRegister(txtRegUser.getText(), txtRegPass.getText(), txtRegName.getText(), txtRegSurname.getText(), txtRegAge.getText())) {


            }*/
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}