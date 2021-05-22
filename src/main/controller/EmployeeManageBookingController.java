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
import main.model.EmployeeManageBookingModel;
import main.model.LoginModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class EmployeeManageBookingController {
    public EmployeeManageBookingModel emb = new EmployeeManageBookingModel();

    @FXML
    private Button btnManageBookToEmployeePanel;
    public void ManageBookToEmployeePanel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/employeePanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnManageBookToEmployeePanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    @FXML
    private TextField txtAccManagUser;
    @FXML
    private Label labelAccManagBookingInfo;
    public void AccManagCheckBooking(ActionEvent event) throws SQLException {
        try {

                labelAccManagBookingInfo.setText(emb.isCheckBooking(txtAccManagUser.getText()));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
