package com.annawyrwal.paintersbrowser;

import com.annawyrwal.paintersbrowser.Models.Author;
import com.annawyrwal.paintersbrowser.Models.AuthorsLibrary;
import com.annawyrwal.paintersbrowser.View.MainWindow;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Map;

public class Main extends Application {
    private AuthorsLibrary authorsLibrary;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("View/MainWindow.fxml"));
        primaryStage.setTitle("Przeglądarka obrazow");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        MainWindow controller = loader.getController();

    }



    public static void main(String[] args) {
        launch(args);
    }
}
