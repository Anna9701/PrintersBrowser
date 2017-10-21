package com.annawyrwal.paintersbrowser;

import com.annawyrwal.paintersbrowser.Models.AuthorsLibrary;
import com.annawyrwal.paintersbrowser.View.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private AuthorsLibrary authorsLibrary;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "View/MainWindow.fxml"));
        Parent root = (Parent) loader.load();
        primaryStage.setTitle("Przeglądarka obrazów");
        primaryStage.setScene(new Scene(root, 700, 800));
        primaryStage.show();
        primaryStage.setMinHeight(750);
        primaryStage.setMinWidth(550);
        MainWindow controller = loader.getController();
        controller.init(primaryStage);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
