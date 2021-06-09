package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.model.AdminDeleteAdminModel;
import main.model.AdminWhitelistModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminWhitelistController implements Initializable {
    AdminWhitelistModel awm = new AdminWhitelistModel();

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    @FXML
    private Button btnAdminWhitelistToManagement;
    public void AdminWhitelistToManagement(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManagement.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnAdminWhitelistToManagement.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

    public void Whitelist(ActionEvent event) throws IOException{
        //checkuser
        //changewhitelist(for rebooking same seat)
        if (awm.isCheckUser(txtUsername().getText)){

        }

    }
}
