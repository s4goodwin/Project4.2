package bsu.comp152.project4_2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController extends Store implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField PriceField;
    @FXML
    private TextField TypeField;
    @FXML
    private TextField NameField;
    @FXML
    private ListView<MerchandiseItem> ListStock;
    private ArrayList<MerchandiseItem> Stock;
    private String Name="corn";
    private double Price=10;
    private ItemType ItemType= bsu.comp152.project4_2.ItemType.WICFood;

    public void loadData(){
        Stock=new ArrayList<MerchandiseItem>(getStock());
        Stock.add(new MerchandiseItem(Name, Price, ItemType));
        ObservableList<MerchandiseItem> dataToShow=
                FXCollections.observableArrayList(Stock);
        ListStock.setItems(dataToShow);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        ListStock.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MerchandiseItem>() {
            @Override
            public void changed(ObservableValue<? extends MerchandiseItem> observableValue, MerchandiseItem merchandiseItem, MerchandiseItem t1) {
                NameField.setText(t1.getName());
                PriceField.setText(String.valueOf(t1.getPrice()));
                TypeField.setText(String.valueOf(t1.getTaxibleType()));
            }
        });

    }
}