package main.controller;

import com.sun.javafx.css.Style;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.EmployeeBookingModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class EmployeeBookingController {
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
    final ColorPicker colorPicker = new ColorPicker();

    @FXML
    private Button btnSeat1, btnTestGreen, btnTestRed, btnTestOrange;
    public void Seat1(ActionEvent event){
        try{
            Color c = colorPicker.getValue();
            if (ebm.isCheckUser(username)){

            }else if(btnSeat1.getStyle() == btnTestGreen.getStyle()){
                btnSeat1.setStyle("-fx-background-color: red");
            }else{
                System.out.println("NEITHER");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void Seat2(ActionEvent event){

    }
    public void Seat3(ActionEvent event){

    }
    public void Seat4(ActionEvent event){

    }
    public void Seat5(ActionEvent event){

    }
    public void Seat6(ActionEvent event){

    }
    public void Seat7(ActionEvent event){

    }
    public void Seat8(ActionEvent event){

    }
    public void Seat9(ActionEvent event){

    }
    public void Seat10(ActionEvent event){

    }
    public void Seat11(ActionEvent event){

    }
    public void Seat12(ActionEvent event){

    }
    public void Seat13(ActionEvent event){

    }
    public void Seat14(ActionEvent event){

    }
    public void Seat15(ActionEvent event){

    }
    public void Seat16(ActionEvent event){

    }








}
