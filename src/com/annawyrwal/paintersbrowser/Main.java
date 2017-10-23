package com.annawyrwal.paintersbrowser;


import com.annawyrwal.paintersbrowser.View.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//@Author Anna Wyrwal
//You need to pass path to images folder in parameter passed to program

public class Main extends Application {

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
        if (args.length < 1) {
            System.err.println("Usage: <path to images folder>");
            System.exit(-1);
        }
        Global.setPath(args[0]);
        launch(args);
    }
}
