package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import java.util.Scanner;

public class logInController implements Initializable {
    private static logInController instance;
    private static String curUserName = "";
 public logInController()
 {
     instance = this;
 }
 public static String getUserName()
 {
     return curUserName;
 }

    @FXML
    private Text title;

    @FXML
    private TextField userName;

    @FXML
    private TextField passWord;

    @FXML
    private CheckBox remember;

    @FXML
    private Button logInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private Button homeButton;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        userName.setStyle("-fx-text-inner-color: #a0a2ab");
        passWord.setStyle("-fx-text-inner-color: #a0a2ab");
    }
    @FXML
    public void logInBtnAction(ActionEvent e)
    {
        String name = userName.getText()    ;
        String pw = passWord.getText();
        if(!FileIO.accountExist(name))
        {
            System.out.println("this account is not exist!");
        }
        else if(!FileIO.pwCorrect(name,pw))
        {
            System.out.println("password wrong!");
        }
        else
        {
            System.out.println(name+" log in successfully");
            curUserName = name;
        }
    }



    @FXML
    private void signUpAction(ActionEvent e1) throws IOException {
        signUpBtn.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    @FXML
    public void homeAction(ActionEvent e) throws IOException {
       homeButton .getScene().getWindow().hide();
        Stage  home= new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        home.setScene(scene);
        home.show();
        home.setResizable(false);
    }

    }



