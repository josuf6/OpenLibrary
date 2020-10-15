package ehu.isad.controllers;

import ehu.isad.Book;
import ehu.isad.Liburuak;
import ehu.isad.utils.Sarea;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class XehetasunakKud implements Initializable {

    private Liburuak mainApp;
    private Sarea nSarea;
    private Book nLiburu;

    public void setMainApp(Liburuak main) {
        this.mainApp = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.nSarea = new Sarea();
    }

    public void infoKudeatu(String pIsbn) {
        nLiburu = nSarea.infoLortu(pIsbn);
        //TODO
    }
}