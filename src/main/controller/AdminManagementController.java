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

public class AdminManagementController {

    @FXML
    private Button btnAdminAccManagementToAdminPanel;
    public void AdminAccManagementToAdminPanel(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader();
        String address = "src/main/ui/adminPanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = load.load(fxmlStream);


        Stage stage = (Stage) btnAdminAccManagementToAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Button btnAdminAccManaToWhitelist;
    public void AdminAccManaToWhitelist(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminWhitelist.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminAccManaToWhitelist.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private Button btnAdminAccManaToCreateAdmin;
    public void AdminAccManaToCreateAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminCreateAdmin.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminAccManaToCreateAdmin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private Button btnAdminAccManaToDelAdmin;
    public void AdminAccManaToDelAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminDeleteAdmin.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminAccManaToDelAdmin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Button btnAdminAccManaToManEmployee;
    public void AdminAccManaToManEmployee(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManageEmployee.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminAccManaToManEmployee.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }


}
