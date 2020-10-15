package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class LiburuKud implements Initializable {

    private Liburuak mainApp;

    @FXML
    private Label txtHautatu;

    @FXML
    private ComboBox<Book> comboLiburuak;

    @FXML
    private Button btnIkusi;

    public void setMainApp(Liburuak main) {
        this.mainApp = main;
    }

    @FXML
    void onClick(ActionEvent event) {
        mainApp.xehetasunakErakutsi(comboLiburuak.getValue().getIsbn());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.liburuakSartu();
        this.comboTestuaEgokitu();
    }

    private void liburuakSartu() {
        ObservableList<Book> liburuList = FXCollections.observableArrayList();
        liburuList.addAll(
                new Book("9781491920497", "Blockchain: Blueprint for a New Economy"),
                new Book("1491910399", "R for Data Science"),
                new Book("1491946008", "Fluent Python"),
                new Book("1491978236", "Natural Language Processing with PyTorch"),
                new Book("9781491906187", "Data Algorithms")
        );
        comboLiburuak.setItems(liburuList);
    }

    private void comboTestuaEgokitu() {
        comboLiburuak.setConverter(new StringConverter<>() {
            @Override
            public String toString(Book liburu) {
                if (liburu == null)
                    return "";
                return liburu.getTitle();
            }

            @Override
            public Book fromString(String string) {
                return null;
            }
        });
    }
}

