package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.AdminReleaseBookingModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminReleaseBookingController implements Initializable {
    AdminReleaseBookingModel arb = new AdminReleaseBookingModel();
    UserHolder holder = UserHolder.getInstance();
    User u = holder.getUser();
    String username = u.getUsername();

    @FXML
    private Label lblBookingStatus;
    @Override
    public void initialize(URL location, ResourceBundle resources){

        try {
            if(arb.isCheckBooking(username).isEmpty()){
                lblBookingStatus.setText("            No Current Booking");
            }else{
                lblBookingStatus.setText(arb.isCheckBooking(username));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label lblStatus;
    public void AcceptBooking() throws SQLException {
        // check booking else no booking
        // isAcceptBooking -> change to confirmed
        // else error
        try {
            if (arb.isCheckBooking(username).isEmpty()){
                lblStatus.setText("No Booking");
            }else{
                arb.isAcceptBooking(username);
                lblStatus.setText("Confirmed");
                arb.isPrevSeat(Integer.parseInt(arb.isSeatNum(username)), username);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void DeclineBooking(){
        // check booking else no booking
        // isDeclineBooking -> cancel booking
        // else error
        try {
            if (arb.isCheckBooking(username).isEmpty()){
                lblStatus.setText("No Booking");
            }else{
                arb.isDeclineBooking(username);
                lblStatus.setText("Declined");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private Button btnReleaseBookingToAdminPanel;
    public void ReleaseBookingToAdminPanel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminPanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnReleaseBookingToAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}
