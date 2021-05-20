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

public class EmployeeManageAccountController {

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
}
