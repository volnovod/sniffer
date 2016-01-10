package com.mikrotikSniffer;

import com.mikrotikSniffer.Controller.ConnectionController;
import com.mikrotikSniffer.Controller.LoggingController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by victor on 06.01.16.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader connectingLoader = new FXMLLoader(getClass().getResource("/fxml/connection.fxml"));
        FXMLLoader loggingLoader = new FXMLLoader(getClass().getResource("/fxml/logging.fxml"));


        AnchorPane loggingPane = loggingLoader.load();
        AnchorPane connectingPane = connectingLoader.load();

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        Scene connectingScene = new Scene(connectingPane);
        Scene loggingScene = new Scene(loggingPane);

        ConnectionController connectionController = connectingLoader.getController();
        LoggingController loggingController = loggingLoader.getController();
        connectionController.setLoggingController(loggingController);
        connectionController.setLoggingScene(loggingScene);
        connectionController.setPrimaryStage(primaryStage);

        primaryStage.setScene(connectingScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
