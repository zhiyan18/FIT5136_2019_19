package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class EditInfoController implements Initializable {

    private String uname ="";
    @FXML
    private Text title;

    @FXML
    private TextField userName;

    @FXML
    private TextField email;
    @FXML
    private Button signUpBtn;

    @FXML
    private TextField phoneNo;

    @FXML
    private TextField homeAdd;

    @FXML
    private TextField postCode;

    @FXML
    private PasswordField passWord;

    @FXML
    private PasswordField rePassWord;

    @FXML
    private Button homeButton;
    @FXML
    private Button update;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        uname = Controller.getUserName();
   String[] info =  FileIO.getUserInfo(uname).split(",");
   userName.setText(uname);
   userName.setEditable(false);
   email.setText(info[5]);
   email.setEditable(false);
   phoneNo.setText(info[2]);
   homeAdd.setText(info[3]);
   postCode.setText(info[4]);
   passWord.setText(info[1]);
   rePassWord.setText(info[1]);
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

    @FXML
    public void updateAct(ActionEvent e) throws IOException
    {

        String line = "" + uname + "," + passWord.getText() + "," + phoneNo.getText() + "," + homeAdd.getText() + "," + postCode.getText() + "," + email.getText() ;
        FileIO.updateUser(uname,line);
        System.out.println("update successfully !");
    }
}
