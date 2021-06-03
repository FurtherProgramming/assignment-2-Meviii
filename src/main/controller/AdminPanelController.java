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

public class AdminPanelController {



    @FXML
    private Button btnAdminSignOutMainLogin;
    public void AdminSignOutMainLogin(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader();
        String address = "src/main/ui/login.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = load.load(fxmlStream);


        Stage stage = (Stage) btnAdminSignOutMainLogin.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Button btnAdminPanelToLockdown;
    public void AdminPanelToLockdown(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader();
        String address = "src/main/ui/adminLockdownSeat.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = load.load(fxmlStream);


        Stage stage = (Stage) btnAdminPanelToLockdown.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Button btnAdminPanelToManagement;
    public void AdminPanelToManagement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManagement.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminPanelToManagement.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Button btnAdminPanelToGenReport;
    public void AdminPanelToGenReport(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminGenerateReports.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminPanelToGenReport.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
