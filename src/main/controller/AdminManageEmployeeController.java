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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminManageEmployeeController implements Initializable {
    AdminDeleteAdminModel adm = new AdminDeleteAdminModel();

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    @FXML
    private Button btnAdminManageEmpToDeleteEmp;
    public void AdminManageEmpToDeleteEmp(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminDeleteEmployee.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnAdminManageEmpToDeleteEmp.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private Button btnDeleteAdminToAdminManagement;
    public void DeleteAdminToAdminManagement(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminManagement.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnDeleteAdminToAdminManagement.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private Button btnAdminManageEmpToDeactivateEmp;
    public void AdminManageEmpToDeactivateEmp(ActionEvent event) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminDeactivateEmployee.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnAdminManageEmpToDeactivateEmp.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private Button btnAdminManageEmpToAddEmp;
    public void AdminManageEmpToAddEmp(ActionEvent event) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminAddEmployee.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnAdminManageEmpToAddEmp.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private Button btnAdminManageEmpToUpdateEmp;
    public void AdminManageEmpToUpdateEmp(ActionEvent event) throws Exception {

        try {
            FXMLLoader loader = new FXMLLoader();
            String address = "src/main/ui/adminUpdateEmployeeCheck.fxml";
            InputStream fxmlStream = new FileInputStream(address);
            Parent root = loader.load(fxmlStream);

            Stage stage = (Stage) btnAdminManageEmpToUpdateEmp.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
