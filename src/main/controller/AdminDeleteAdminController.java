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
import main.model.AdminCreateAdminModel;
import main.model.AdminDeleteModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDeleteAdminController implements Initializable {
    AdminDeleteModel adm = new AdminDeleteModel();

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    @FXML
    private Button btnDeleteAdminToAdminManagement;
    public void DeleteAdminToAdminManagement(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManagement.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnDeleteAdminToAdminManagement.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

    @FXML
    private TextField txtAdminUsername;
    @FXML
    private Label labelAccDelStatus;
    public void Delete(ActionEvent event) throws SQLException {
        try {
            if (adm.isCheckUser(txtAdminUsername.getText())){
                adm.isDelete(txtAdminUsername.getText());
                labelAccDelStatus.setText("Deleted");
            }else{
                labelAccDelStatus.setText("Doesn't Exist");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}