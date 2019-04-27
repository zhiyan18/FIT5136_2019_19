package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Button homeButton;

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

    @FXML
    public void homeAction(ActionEvent e) throws IOException {
        homeButton.getScene().getWindow().hide();
        Stage home= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.show();
        home.setResizable(false);
    }
}
