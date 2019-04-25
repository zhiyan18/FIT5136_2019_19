package sample;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField searchBar;

    @FXML
    private Text title;

    @FXML
    private Button signUp;

    @FXML
    private Button searchButton;

    @FXML
    private Tab sortByName;

    @FXML
    private Tab sortByDist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
   @FXML
    public void logInAction(ActionEvent e) throws IOException {
      signUp.getScene().getWindow().hide();
      Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }
}
