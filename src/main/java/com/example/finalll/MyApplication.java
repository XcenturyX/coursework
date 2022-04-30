package com.example.finalll;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApplication.class.getResource("start.fxml"));
        Rectangle2D rectangle2D= Screen.getPrimary().getBounds();
        Scene scene = new Scene(fxmlLoader.load(), rectangle2D.getWidth()/1.5, rectangle2D.getHeight()/1.75);
        stage.setTitle("Redaktor");
        InputStream iconStream = getClass().getResourceAsStream("foto/iconca.png");
        Image icon = new Image(iconStream);
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}