/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;

import ehu.isad.controllers.LiburuKud;
import ehu.isad.controllers.XehetasunakKud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Liburuak extends Application {

    private Parent liburuUI;
    private Parent xehetasunakUI;

    private Stage stage;

    private LiburuKud liburuKud;
    private XehetasunakKud xehetasunakKud;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setResizable(false);
        this.liburuakErakutsi();
        stage.setTitle("OpenLibrary");
    }

    public void liburuakErakutsi() throws Exception {
        this.pantailakKargatu();
        stage.setScene(new Scene(liburuUI, 380, 130));
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - 380) / 2);
        stage.setY((primScreenBounds.getHeight() - 180) / 2);
        stage.show();
    }

    private void pantailakKargatu() throws IOException {
        FXMLLoader loaderLiburuak = new FXMLLoader(getClass().getResource("/Liburuak.fxml"));
        liburuUI = (Parent) loaderLiburuak.load();
        liburuKud = loaderLiburuak.getController();
        liburuKud.setMainApp(this);

        FXMLLoader loaderXehetasunak = new FXMLLoader(getClass().getResource("/Xehetasunak.fxml"));
        xehetasunakUI = (Parent) loaderXehetasunak.load();
        xehetasunakKud = loaderXehetasunak.getController();
        xehetasunakKud.setMainApp(this);
    }

    public void xehetasunakErakutsi(String pIsbn) {
        stage.setScene(new Scene(xehetasunakUI, 600, 450));
        xehetasunakKud.infoKudeatu(pIsbn);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - 600) / 2);
        stage.setY((primScreenBounds.getHeight() - 400) / 2);
        stage.show();
    }
}
