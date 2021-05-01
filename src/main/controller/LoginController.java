package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.model.LoginModel;

import javax.xml.soap.Text;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnAdminPanel;


    // Check database connection
    @Override
    public void initialize(URL location, ResourceBundle resources){
        if (loginModel.isDbConnected()){
            isConnected.setText("Connected");
        }else{
            isConnected.setText("Not Connected");
        }

    }
    /* login Action method
       check if user input is the same as database.
     */
    public void Login(ActionEvent event){

        try {
            if (loginModel.isLogin(txtUsername.getText(),txtPassword.getText())){

                isConnected.setText("Logged in successfully");
            }else{
                isConnected.setText("Incorrect Login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ChangeToAdminPanel(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminLogin.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);


        Stage stage = (Stage) btnAdminPanel.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);




        //=========================================================================================================

        //btnAdminPanel
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ui/adminLogin.fxml")));
        Scene scene = new Scene(root);

        //Getting stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();

        Stage s = new Stage();
        s.setScene(FXMLLoader.load(getClass().getResource("ui/adminLogin.fxml")));
        s.show();*/

        //=========================================================================================================

        /*FXMLLoader loader = new FXMLLoader();
        loader.load().getClass().getClassLoader().getResource(FXMLLoader.load((getClass().getClassLoader().getResource("../ui/adminLogin.fxml"))));
        Stage stage = (Stage) btnAdminPanel.getScene().getWindow();
        Scene scene = new Scene(loader.getRoot());
        stage.setScene(scene);*/
    }
    @FXML
    private TextField txtRegUser;
    @FXML
    private TextField txtRegPass;
    @FXML
    private TextField txtRegName;
    @FXML
    private TextField txtRegSurname;
    @FXML
    private TextField txtRegAge;
    public void RegisterButtonPushed(ActionEvent event) {
        //Should open new form
        //isRegister Completed. Need to implement.

    }




    //11.2.3 big sur



}
