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
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDeleteEmployeeController{

    @FXML
    private Button btnDeleteEmployeeToEmpManagement;
    public void DeleteEmployeeToEmpManagement(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManageEmployee.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnDeleteEmployeeToEmpManagement.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    public void Delete(ActionEvent event){

    }
}
