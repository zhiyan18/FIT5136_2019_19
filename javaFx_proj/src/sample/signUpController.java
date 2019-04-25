package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;

public class signUpController {

    @FXML
    private Text title;

    @FXML
    private TextField userName;

    @FXML
    private TextField passWord;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField rePassWord;

    @FXML
    private TextField phoneNo;

    @FXML
    private TextField homeAdd;

    @FXML
    private TextField postCode;

    @FXML
    public void signUpBtnEvent(javafx.event.ActionEvent actionEvent) {
        System.out.println("sign up successfully !");
    }
}
