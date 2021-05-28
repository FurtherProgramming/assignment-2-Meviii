package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AdminDeactivateEmployeeController {

    @FXML
    private Button btnDeactivateEmpToManageEmp;
    public void DeactivateEmpToManageEmp(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManageEmployee.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnDeactivateEmpToManageEmp.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    public void Deactivate(ActionEvent event){

    }
}
