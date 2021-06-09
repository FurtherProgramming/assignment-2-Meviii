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
import main.model.AdminDeactivateEmployeeModel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;

public class AdminDeactivateEmployeeController {
    AdminDeactivateEmployeeModel ade = new AdminDeactivateEmployeeModel();
    @FXML
    private Button btnDeactivateEmpToManageEmp;
    public void DeactivateEmpToManageEmp(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminManageEmployee.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnDeactivateEmpToManageEmp.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @FXML
    private TextField txtUsername;
    @FXML
    private Label lblStatus;
    public void Deactivate(ActionEvent event){

        try{
            if (ade.isCheckUser(txtUsername.getText())){
                ade.isDeactivate(Boolean.FALSE, txtUsername.getText());
                lblStatus.setText("Deactivated");
            }else{
                lblStatus.setText("Not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
