package sample;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    private String userName = "";
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

    @FXML
    private Button myCart;

    @FXML
    private Button myOrder;

    @FXML
    private Button account;

    @FXML
    private ButtonBar botButtons;
    @FXML
    private Button restaurant1;

    @FXML
    private Button restaurant2;

    @FXML
    private Button restaurant3;
    @FXML
    private Button restaurant4;

    @FXML
    private Button restaurant5;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String name = logInController.getUserName();
        if (name != "") {
            signUp.setText(name);
            userName = name;
            botButtons.setDisable(false);
            botButtons.setVisible(true);

        } else {
            botButtons.setDisable(true);
            botButtons.setVisible(false);
        }
        Button[] restButtons = {restaurant1, restaurant2, restaurant3,restaurant4,restaurant5};
        String[] names = FileIO.getRestName().split("\n");
        Arrays.sort(names);
        int i = 0;
        while (i < restButtons.length && i < names.length) {
            restButtons[i].setVisible(true);
            restButtons[i].setText(names[i]);
            i++;
        }
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
