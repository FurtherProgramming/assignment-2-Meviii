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
import main.model.AdminLockdownSeatModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AdminLockdownSeatController {
    AdminLockdownSeatModel als = new AdminLockdownSeatModel();

    @FXML
    private Button btnAdminLockdownToHomePanel;
    public void AdminLockdownToHomePanel(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminPanel.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnAdminLockdownToHomePanel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtSeatNum;
    public void Lockdown(ActionEvent event){

        try{
            if (txtSeatNum.getText().isEmpty()){
                lblStatus.setText("Empty Field");
            }else if(als.isCurrentlyLockdown(txtSeatNum.getText()).equals("1")){
                lblStatus.setText("Already Locked");
            }else if(als.isCurrentlyLockdown(txtSeatNum.getText()).equals("0")){
                als.isLockdown(txtSeatNum.getText(), Boolean.TRUE);
                als.isRemoveBooking(txtSeatNum.getText());
                lblStatus.setText("Done");
            }else{
                lblStatus.setText("Error");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
