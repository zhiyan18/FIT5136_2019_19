package sample;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    private static String userName = "";
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
    private Button showMenuBtn;
    @FXML
    private ButtonBar botButtons;

    @FXML
    private ListView<String> restList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String name = logInController.getUserName();
        if (name != "") {
            signUp.setText(name);
            userName = name;
            botButtons.setDisable(false);
           // botButtons.setVisible(true);
            showMenuBtn.setDisable(false);

        } else {
            botButtons.setDisable(true);
           // botButtons.setVisible(false);
            showMenuBtn.setDisable(true);
        }

        String[] names =FileIO.getAllRestName();

        Arrays.sort(names);
        ObservableList<String> items = FXCollections.observableArrayList (names);
        restList.setItems(items);

        restList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);

            }
        });
    }
    public static String getUserName()
    {
        return userName;
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

    @FXML
    public void showMenuAct(ActionEvent e) throws IOException {
        restSelect = restList.getSelectionModel().getSelectedItem();
         showMenu();

    }
    public static String getRestSelect()
    {
        return restSelect;
    }

    public void showMenu() throws IOException
    {
        restList.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }

    public  String searchMatch()
    {
        String match = searchBar.getText();
        String[] names =FileIO.getAllRestName();
        String findName = "";
        for(String s : names)
        {
            if(s.toLowerCase().contains(match.toLowerCase()))
            {
                findName +=s + "\n";
            }
        }
        return  findName;
    }

    @FXML
    public void searchBtnAct(ActionEvent e) throws IOException
    {

       String nameStr =  searchMatch();

       if(nameStr.equals(""))
       {
          return;
       }
        String[] nameArr = nameStr.split("\n");
        ObservableList<String> items = FXCollections.observableArrayList (nameArr);
        restList.setItems(items);
    }

    @FXML
    public void myOrderAct(ActionEvent e) throws IOException
    {
        myOrder.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("orderHistory.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }

    @FXML
    public void accountAct(ActionEvent e) throws IOException
    {
        myOrder.getScene().getWindow().hide();
        Stage menu = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("editinfo.fxml"));
        Scene scene = new Scene(root);
        menu.setScene(scene);
        menu.show();
        menu.setResizable(false);
    }
}
