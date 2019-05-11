package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderHisController implements Initializable {
    private ArrayList<String> orderStrList;

    @FXML
    private Text title;

    @FXML
    private Button homeButton;

    @FXML
    private ListView<String> orderList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       String orders = FileIO.getOrderHis();
        System.out.println(orders);
        orderStrList = new ArrayList<>();
        try {
           JSONArray  orderJArr = new JSONArray(orders);
            for(int i=0;i<orderJArr.length();i++)
            {
                if( orderJArr.getJSONObject(i).getString("userName").equals(Controller.getUserName()))
                {
                   orderStrList.add( orderJArr.getJSONObject(i).toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ObservableList<String> items = FXCollections.observableArrayList (orderStrList);
        orderList.setItems(items);

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
