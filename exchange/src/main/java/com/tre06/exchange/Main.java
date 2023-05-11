package com.tre06.exchange;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override     
    public void start(Stage stage) throws IOException {         
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("parent.fxml"));         
        Scene scene = new Scene(fxmlLoader.load(), 600, 475);         
        stage.setTitle("Currency Exchange");
/*        Image image=new Image("logo tala.png");
        stage.getIcons().add(image);*/
        stage.setScene(scene);         
        stage.show();     
        } 

    public static void main(String[] args) {
        launch();
    }
}