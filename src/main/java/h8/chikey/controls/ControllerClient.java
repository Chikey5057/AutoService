package h8.chikey.controls;

import h8.chikey.models.Client;
import h8.chikey.models.ClientService;
import h8.chikey.models.Service;
import h8.chikey.service.ServiceClient;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Date;

public class ControllerClient {

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<Client, Integer> tableID;

    @FXML
    private TableColumn<Client, String> tableFirstName;

    @FXML
    private TableColumn<Client, String> tableLastName;

    @FXML
    private TableColumn<Client, String> tablePatron;

    @FXML
    private TableColumn<Client, Date> tableBirthday;

    @FXML
    private Button buttonCreate;

    ObservableList<Client> clientList = FXCollections.observableArrayList();


    @FXML
    void initialize(){
        buttonCreate.setOnAction(actionEvent ->{
            buttonCreate.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/WindowCreate.fxml"));
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
        try(SessionFactory factory = new Configuration().configure().buildSessionFactory()){
            ServiceClient sc = new ServiceClient(factory);
            clientList.addAll(sc.reedALL());
        }
        tableID.setCellValueFactory(clientIntegerCellDataFeatures -> new SimpleObjectProperty<>(clientIntegerCellDataFeatures.getValue().getClientID()));
        tableFirstName.setCellValueFactory(clientIntegerCellDataFeatures -> new SimpleObjectProperty<>(clientIntegerCellDataFeatures.getValue().getFirstName()));
        tableLastName.setCellValueFactory(clientIntegerCellDataFeatures -> new SimpleObjectProperty<>(clientIntegerCellDataFeatures.getValue().getLastName()));
        tablePatron.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getPatronymic()));
        tableBirthday.setCellValueFactory(clientDateCellDataFeatures -> new SimpleObjectProperty<>(clientDateCellDataFeatures.getValue().getBirthday()));
        table.setItems(clientList);
    }
}
