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
import main.model.AdminCreateAdminModel;
import main.model.EmployeeRegisterModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminCreateAdminController implements Initializable {
    AdminCreateAdminModel aca = new AdminCreateAdminModel();

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    @FXML
    private Button btnCreateAdminToAdminManagement;
    public void CreateAdminToAdminManagement(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManagement.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnCreateAdminToAdminManagement.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    @FXML
    private TextField txtAdminName;
    @FXML
    private TextField txtAdminSurname;
    @FXML
    private TextField txtAdminAge;
    @FXML
    private TextField txtAdminUsername;
    @FXML
    private TextField txtAdminPassword;
    @FXML
    private TextField txtAdminSecretQuestion;
    @FXML
    private TextField txtAdminSecretAnswer;
    @FXML
    private Label labelAdminCreateAdmin;
    public void Create(ActionEvent event) throws SQLException {
        try {
            Boolean regNameIsEmpty = txtAdminName.getText().isEmpty();
            Boolean regSurnameIsEmpty = txtAdminSurname.getText().isEmpty();
            Boolean regAgeIsEmpty = txtAdminAge.getText().isEmpty();
            Boolean regUsernameIsEmpty = txtAdminUsername.getText().isEmpty();
            Boolean regPasswordIsEmpty = txtAdminPassword.getText().isEmpty();
            Boolean regSecretQuestionIsEmpty = txtAdminPassword.getText().isEmpty();
            Boolean regSecretAnswerIsEmpty = txtAdminPassword.getText().isEmpty();

            if (!aca.isCheckUser(txtAdminUsername.getText())) {
                if (!regSecretQuestionIsEmpty && !regSecretAnswerIsEmpty && !regNameIsEmpty && !regSurnameIsEmpty && !regAgeIsEmpty && !regUsernameIsEmpty && !regPasswordIsEmpty) {
                    aca.isCreate(txtAdminName.getText(), txtAdminSurname.getText(), txtAdminAge.getText(), txtAdminUsername.getText(), txtAdminPassword.getText(), txtAdminSecretQuestion.getText(), txtAdminSecretAnswer.getText());
                    labelAdminCreateAdmin.setText("Account Created");
                } else if (regNameIsEmpty && regSurnameIsEmpty && regAgeIsEmpty && regUsernameIsEmpty && regPasswordIsEmpty) {
                    labelAdminCreateAdmin.setText("Incorrect Details");
                }
            }else{
                labelAdminCreateAdmin.setText("Username in use");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
