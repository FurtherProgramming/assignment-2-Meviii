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
import main.model.AdminUpdateEmployeeCheckModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class AdminUpdateEmployeeCheckController {
    AdminUpdateEmployeeCheckModel uec = new AdminUpdateEmployeeCheckModel();


    @FXML
    private Button btnUpdateEmpToManageEmployee;
    public void UpdateEmpToManageEmployee(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminManageEmployee.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnUpdateEmpToManageEmployee.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnCheckToEmployeeUpdateDetails;
    @FXML
    private Label lblStatus;
    public void Check(ActionEvent event) throws IOException{
        try{
            if (uec.isCheckUser(txtUsername.getText())) {
                User u = new User(txtUsername.getText());
                UserHolder holder = UserHolder.getInstance();
                holder.setUser(u);

                FXMLLoader loader = new FXMLLoader();
                String address = "src/main/ui/adminUpdateEmployeeDetails.fxml";
                InputStream fxmlStream = new FileInputStream(address);
                Parent root = loader.load(fxmlStream);

                Stage stage = (Stage) btnCheckToEmployeeUpdateDetails.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
            }else{
                lblStatus.setText("Not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
