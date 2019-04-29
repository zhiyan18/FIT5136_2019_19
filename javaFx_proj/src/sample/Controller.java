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
import javafx.scene.layout.VBox;
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
    private static String restSelect ="";
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

    @FXML
    private VBox buttonBox;

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
        String[] names =FileIO.getAllRestName();

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

    public static String getRestSelect()
    {
        return restSelect;
    }
    @FXML
    public void menuActionB1(ActionEvent e) throws IOException {
        restSelect = restaurant1.getText();
        restaurant1.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }



    @FXML
    public void menuActionB3(ActionEvent e) throws IOException {
        restSelect = restaurant3.getText();
        restaurant3.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }

    @FXML
    public void menuActionB2(ActionEvent e) throws IOException {
        restSelect = restaurant2.getText();
        restaurant2.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }

    @FXML
    public void menuActionB4(ActionEvent e) throws IOException {
        restSelect = restaurant4.getText();
        restaurant4.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }

    @FXML
    public void menuActionB5(ActionEvent e) throws IOException {
        restSelect = restaurant5.getText();
        restaurant5.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }

}
