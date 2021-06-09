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
import main.User;
import main.UserHolder;
import main.model.EmployeeManageAccountModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class EmployeeManageAccountController {
    EmployeeManageAccountModel ema = new EmployeeManageAccountModel();
    UserHolder holder = UserHolder.getInstance();
    User u = holder.getUser();
    String username = u.getUsername();

    @FXML
    private Button btnManageAccToEmployeePanel;
    public void ManageAccToEmployeePanel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/employeePanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnManageAccToEmployeePanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private TextField txtName, txtSurname, txtAge, txtCurrPass, txtNewPass, txtSQuestion, txtSAnswer;
    @FXML
    private Label lblStatus;
    public void Update(ActionEvent event) throws Exception {
        try {
            if (!(txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtAge.getText().isEmpty() || txtCurrPass.getText().isEmpty() || txtNewPass.getText().isEmpty() || txtSQuestion.getText().isEmpty() || txtSAnswer.getText().isEmpty())) {
                if (txtCurrPass.getText().equals(ema.isPassword(username))) {
                    ema.isUpdate(txtName.getText(),txtSurname.getText(), txtAge.getText(), txtNewPass.getText(), txtSQuestion.getText(), txtSAnswer.getText(), username);
                    lblStatus.setText("Updated!");
                }else{
                    lblStatus.setText("Incorrect Pass");
                }
            } else if (txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtAge.getText().isEmpty() || txtCurrPass.getText().isEmpty() || txtNewPass.getText().isEmpty() || txtSQuestion.getText().isEmpty() || txtSAnswer.getText().isEmpty()) {
                lblStatus.setText("Empty Fields");
            }else {
                lblStatus.setText("Error");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
