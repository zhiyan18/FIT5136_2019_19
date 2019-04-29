package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable
{
    @FXML
    private Text title;

    @FXML
    private Button food1;

    @FXML
    private Button food2;

    @FXML
    private Button food3;

    @FXML
    private Button food4;

    @FXML
    private Button food5;

    @FXML
    private Button homeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] menu = FileIO.getRestMenu(Controller.getRestSelect()).split("\n");
        food1.setText(menu[0]);
        food2.setText(menu[1]);

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
