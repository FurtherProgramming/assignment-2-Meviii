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
import main.model.EmployeeBookingModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class EmployeeBookingControllerREALL {
    EmployeeBookingModel ebm = new EmployeeBookingModel();
    UserHolder holder = UserHolder.getInstance();
    User u = holder.getUser();
    String username = u.getUsername();

    @FXML
    private Button btnBackEmployeePanel;
    @FXML
    private Label lblBookingUserDisplay;

    public void BackToMainEmployeePanel(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader();
        String address = "src/main/ui/employeePanel.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = load.load(fxmlStream);

        Stage stage = (Stage) btnBackEmployeePanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private TextField txtBookingDate;
    @FXML
    private Label labelBookingStatus;
    public void BookingBook(ActionEvent event) throws SQLException{
        try{

            if (ebm.checkBooking(username)) {
                labelBookingStatus.setText("Already Booked");
            }else if (ebm.isCheckUser(username)) {
                    if (!txtBookingDate.getText().isEmpty()) {
                        ebm.isBooking(txtBookingDate.getText(), username, "Awaiting Confirmation");
                        labelBookingStatus.setText("SeatNum: " + ebm.isSeatNum(username));
                    } else {
                        labelBookingStatus.setText("Incorrect Details");
                    }
                } else {
                    labelBookingStatus.setText("Wrong User");
                }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
