package sample;
import com.google.gson.Gson;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MenuController implements Initializable
{
    private ArrayList<String> selectedFoodName;
    private String restName;
    private double price = 0;
    @FXML
    private Text title;


    @FXML
    private Button homeButton;

    @FXML
    private Text priceText;
    @FXML
    private Button placeOrderBtn;
    @FXML
    private ListView<String> menuList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        restName = Controller.getRestSelect();
        String[] menu = FileIO.getRestMenu(restName).split("\n");
        ObservableList<String> items = FXCollections.observableArrayList (menu);
        menuList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        menuList.setItems(items);
        menuList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   price = 0;
                for( String s:menuList.getSelectionModel().getSelectedItems()) {
                    JSONObject food = FileIO.getFoodObj(s, restName);
                    try {
                         price += Double.valueOf(food.getString("price"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                priceText.setText("total price: "+price);
            }
        });

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
    public void placeOrderAct(ActionEvent e) throws IOException {
        ObservableList<String> foodsList ;
        foodsList = menuList.getSelectionModel().getSelectedItems();
        selectedFoodName = new ArrayList<>();
        if(foodsList.isEmpty()) return;
        for(String s:foodsList)
        {
          //  selectedFoodName.add( FileIO.getFoodObj(s,restName));
            selectedFoodName.add(s);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = sdf.format(new Date());
        Order order = new Order(Controller.getUserName(),time, selectedFoodName,price);
        Gson gson = new Gson();
        String line = gson.toJson(order);
      System.out.println( line);
      FileIO.placeOrder(line);

        priceText.setText("this order is placed");
    }
}
