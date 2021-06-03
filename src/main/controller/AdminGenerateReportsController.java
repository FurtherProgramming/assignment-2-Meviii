package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.model.AdminGenerateEmployeeModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AdminGenerateReportsController {
    AdminGenerateEmployeeModel age = new AdminGenerateEmployeeModel();

    @FXML
    private Button btnAdminReportToGenBooking;
    public void AdminReportToGenBooking(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminGenerateBooking.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminReportToGenBooking.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Button btnReportToAdminPanel;
    public void ReportToAdminPanel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminPanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnReportToAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private Label lblIfGenerated;
    public void AdminReportToGenEmployee(ActionEvent event) throws IOException {
        age.isEmployeeInfo();
        lblIfGenerated.setText("Generated!");
    }
}
