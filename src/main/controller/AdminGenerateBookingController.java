package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.model.AdminGenerateBookingModel;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminGenerateBookingController implements Initializable {
    AdminGenerateBookingModel agb = new AdminGenerateBookingModel();

    @FXML
    private Label lblDetails;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        lblDetails.setText(agb.isCurrentBookings());
    }

    @FXML
    private Button btnGenerateBookingToReports;
    public void GenerateBookingToReports(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminGenerateReports.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnGenerateBookingToReports.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    @FXML
    private TextField txtUsername;
    @FXML
    private Label txtIfGenerated;
    public void Generate(ActionEvent event){

        try{
            agb.isBookingInfo();
            txtIfGenerated.setText("Generated!");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
