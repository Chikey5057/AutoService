package h8.chikey.controls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerCreate {

    @FXML
    private Button buttonEXIT;

    @FXML
    void initialize(){
        buttonEXIT.setOnAction(actionEvent ->{
            buttonEXIT.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/WindowClient.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Таблица");
            stage.show();
        });
    }
}
