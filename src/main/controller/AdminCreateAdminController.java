package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.model.AdminCreateAdminModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;


public class AdminCreateAdminController{
    AdminCreateAdminModel aca = new AdminCreateAdminModel();

    @FXML
    private Button btnCreateAdminToAdminManagement;
    public void CreateAdminToAdminManagement(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminManagement.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnCreateAdminToAdminManagement.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private TextField txtAdminName, txtAdminSurname, txtAdminAge, txtAdminUsername, txtAdminPassword, txtAdminSecretQuestion, txtAdminSecretAnswer;
    @FXML
    private Label labelAdminCreateAdmin;
    public void Create(ActionEvent event) {
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
