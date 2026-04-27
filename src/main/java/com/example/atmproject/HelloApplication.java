package com.example.atmproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // BAŞINA / EKLEDİK: Java'nın dosyayı resources içinde bulmasını sağlar
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Anasayfa.fxml"));

        // EKRAN BOYUTU: Tasarımının tam sığması için 800x600 yaptık
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        stage.setTitle("ATM Sistemi - Anasayfa");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}