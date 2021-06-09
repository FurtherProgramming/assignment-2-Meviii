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
import main.model.AdminReleaseBookingIdCheckModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class AdminReleaseBookingIdCheckController {
    AdminReleaseBookingIdCheckModel arb = new AdminReleaseBookingIdCheckModel();

    @FXML
    private Button btnIdCheckToReleaseBooking;
    @FXML
    private TextField txtUsername;
    @FXML
    private Label lblStatus;
    public void IdCheckToReleaseBooking(ActionEvent event) throws IOException {
        try {
            if (arb.isCheckUser(txtUsername.getText()) && !txtUsername.getText().isEmpty()) {
                User u = new User(txtUsername.getText());
                UserHolder holder = UserHolder.getInstance();
                holder.setUser(u);

                FXMLLoader load = new FXMLLoader();
                String address = "src/main/ui/adminReleaseBooking.fxml";
                InputStream fxmlStream = new FileInputStream(address);
                Parent root = load.load(fxmlStream);

                Stage stage = (Stage) btnIdCheckToReleaseBooking.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            } else {
                lblStatus.setText("No User");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @FXML
    private Button btnIdCheckToAdminPanel;
    public void IdCheckToAdminPanel(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader();
        String address = "src/main/ui/adminPanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = load.load(fxmlStream);


        Stage stage = (Stage) btnIdCheckToAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
