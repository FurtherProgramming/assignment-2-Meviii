package main.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
    private TextField txtRegUsername;
    @FXML
    private TextField txtRegPassword;
    @FXML
    private TextField txtRegSecretQuestion;
    @FXML
    private TextField txtRegSecretAnswer;
    @FXML
    private Label labelRegisterEmployee;
    public void Register(ActionEvent event) throws SQLException {
        try {
            Boolean regNameIsEmpty = txtRegName.getText().isEmpty();
            Boolean regSurnameIsEmpty = txtRegSurname.getText().isEmpty();
            Boolean regAgeIsEmpty = txtRegAge.getText().isEmpty();
            Boolean regUsernameIsEmpty = txtRegUsername.getText().isEmpty();
            Boolean regPasswordIsEmpty = txtRegPassword.getText().isEmpty();
            Boolean regSecretQuestionIsEmpty = txtRegPassword.getText().isEmpty();
            Boolean regSecretAnswerIsEmpty = txtRegPassword.getText().isEmpty();

            if (!erc.isCheckUser(txtRegUsername.getText())) {
                if (!regSecretQuestionIsEmpty && !regSecretAnswerIsEmpty && !regNameIsEmpty && !regSurnameIsEmpty && !regAgeIsEmpty && !regUsernameIsEmpty && !regPasswordIsEmpty) {
                    erc.isRegister(txtRegName.getText(), txtRegSurname.getText(), txtRegAge.getText(), txtRegUsername.getText(), txtRegPassword.getText(), txtRegSecretQuestion.getText(), txtRegSecretAnswer.getText());
                    labelRegisterEmployee.setText("Account Created");
                } else if (regNameIsEmpty && regSurnameIsEmpty && regAgeIsEmpty && regUsernameIsEmpty && regPasswordIsEmpty) {
                    labelRegisterEmployee.setText("Incorrect Details");
                }
            }else{
                labelRegisterEmployee.setText("Username in use");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
