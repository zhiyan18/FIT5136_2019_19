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
        String name = userName.getText();
        if (!passWord.getText().equals(rePassWord.getText())) {
            System.out.println("pass word repeat mistake !");
        }
        else if(FileIO.accountExist(name))
        {
            System.out.println("this user name has existed !");
        }
        else if(name.length()<4)
        {
            System.out.println("user name must be larger than 3 characters");
        }
        else{
              FileIO.register(name,passWord.getText(),phoneNo.getText(),homeAdd.getText(),postCode.getText());
            System.out.println("sign up successfully !");
        }
    }
}