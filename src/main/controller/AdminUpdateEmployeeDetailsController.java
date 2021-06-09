package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.User;
import main.UserHolder;
import main.model.AdminUpdateEmployeeDetailsModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminUpdateEmployeeDetailsController implements Initializable {
    public AdminUpdateEmployeeDetailsModel ued = new AdminUpdateEmployeeDetailsModel();

    UserHolder holder = UserHolder.getInstance();
    User u = holder.getUser();
    String username = u.getUsername();

    @FXML
    private TextArea lblUserDetail;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            lblUserDetail.setText(ued.isUserDetail(username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Label lblStatus;
    @FXML
    private TextField txtName, txtSurname, txtAge, txtUsername, txtPassword, txtSecretQuestion, txtSecretAnswer;
    public void Update(ActionEvent event) throws Exception{
        try{
            Boolean txtNameEmpty = txtName.getText().isEmpty();
            Boolean txtSurnameEmpty = txtSurname.getText().isEmpty();
            Boolean txtAgeEmpty = txtAge.getText().isEmpty();
            Boolean txtUsernameEmpty = txtUsername.getText().isEmpty();
            Boolean txtPasswordEmpty = txtPassword.getText().isEmpty();
            Boolean txtSQuestionEmpty = txtSecretQuestion.getText().isEmpty();
            Boolean txtSAnswerEmpty = txtSecretAnswer.getText().isEmpty();

            if(!ued.isCheckUser(txtUsername.getText())) {
                if (txtNameEmpty || txtSurnameEmpty || txtAgeEmpty || txtUsernameEmpty || txtPasswordEmpty || txtSQuestionEmpty || txtSAnswerEmpty) {
                    lblStatus.setText("Empty Fields");
                } else if (!(txtNameEmpty && txtSurnameEmpty && txtAgeEmpty && txtUsernameEmpty && txtPasswordEmpty && txtSQuestionEmpty && txtSAnswerEmpty) && username == txtUsername.getText()) {
                    ued.isUpdate(txtName.getText(), txtSurname.getText(), txtAge.getText(), txtUsername.getText(), txtPassword.getText(), txtSecretQuestion.getText(), txtSecretAnswer.getText(), username);
                    lblStatus.setText("Updated!");
                } else {
                    lblStatus.setText("Error");
                }
            }else if (ued.isCheckUser(txtUsername.getText())){
                lblStatus.setText("Username Exists");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @FXML
    private Button btnEmpUpdDetailToUserCheck;
    public void EmpUpdDetailToUserCheck(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        String address = "src/main/ui/adminUpdateEmployeeCheck.fxml";
        InputStream fxmlStream = new FileInputStream(address);
        Parent root = loader.load(fxmlStream);

        Stage stage = (Stage) btnEmpUpdDetailToUserCheck.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

    }

}
