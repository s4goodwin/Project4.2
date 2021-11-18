package bsu.comp152.project4_2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
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
    private String Name="Corn";                                          //I had to do this because i couldnt get the
    private double Price=10;                                               //arraylist to populate, assigned one object
    private ItemType ItemType= bsu.comp152.project4_2.ItemType.WICFood; //so i could continue

    public void loadData(){
        Stock=new ArrayList<MerchandiseItem>(getStock());        //assigns a new arraylist<merchandiceitem> to Stock
        Stock.add(new MerchandiseItem(Name, Price, ItemType));
        ObservableList<MerchandiseItem> dataToShow=             //turns arraylist into a observable list, assigns it name
                FXCollections.observableArrayList(Stock);       //datatoshow, then use data to show to set items in the listview
        ListStock.setItems(dataToShow);
    }

    @FXML
    public void saveButtonPressed(ActionEvent event){   //for the save button
        var pressedButton=(Button)event.getSource();
        var currentNameText=NameField.getText();  //creates variable for each textfield, and gets the text from it
        var currentPriceText=PriceField.getText();
        var currentItemType=TypeField.getText();
        Object objName=currentNameText;                 //converted from string to object so i could add it to Stock
        Object objPrice=currentPriceText;
        Object objType=currentItemType;
        Stock.add((MerchandiseItem) objName);       //added each field into stock
        Stock.add((MerchandiseItem) objPrice);
        Stock.add((MerchandiseItem) objType);
    }
    @FXML
    public void newButtonPressed(ActionEvent event){
        var pressedButton=(Button)event.getSource();  //when user selects new, it clears the text fields so they can
        NameField.setText("");                          //input their new object, then they can hit save
        PriceField.setText("");
        TypeField.setText("");

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
    public ArrayList<MerchandiseItem> getStock() {  //getter for stock
        return Stock;
    }
}