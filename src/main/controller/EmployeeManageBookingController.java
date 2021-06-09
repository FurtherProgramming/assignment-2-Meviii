package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.EmployeeManageBookingModel;
import main.model.LoginModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeManageBookingController implements Initializable {
    public EmployeeManageBookingModel emb = new EmployeeManageBookingModel();
    UserHolder holder = UserHolder.getInstance();
    User u = holder.getUser();
    String username = u.getUsername();

    @FXML
    private Label labelAccManagBookingInfo;
    @Override
    public void initialize(URL location, ResourceBundle resources){

        try {
            if(emb.isCheckBooking(username).isEmpty()){
                labelAccManagBookingInfo.setText("            No Current Booking");
            }else{
                labelAccManagBookingInfo.setText(emb.isCheckBooking(username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    private Label lblBookingCancelText;
    public void AccManagCancelBooking(ActionEvent event) throws Exception{
        try{
            emb.isRemoveBooking(username);
            lblBookingCancelText.setText("Booking Cancelled");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
