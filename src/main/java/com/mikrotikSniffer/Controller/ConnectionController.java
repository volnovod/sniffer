package com.mikrotikSniffer.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Created by Victor on 10.01.2016.
 */
public class ConnectionController {

    private Stage primaryStage;
    private Scene loggingScene;
    private MikrotikConnection mikrotikConnection;
    private String ipAddress;
    private int port;
    private LoggingController loggingController;

    @FXML
    private TextField ipAddressField;

    @FXML
    private TextField portField;

    @FXML
    private Button connectionButton;

    @FXML
    private Button exitButton;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Scene getLoggingScene() {
        return loggingScene;
    }

    public void setLoggingScene(Scene loggingScene) {
        this.loggingScene = loggingScene;
    }

    public MikrotikConnection getMikrotikConnection() {
        return mikrotikConnection;
    }

    public void setMikrotikConnection(MikrotikConnection mikrotikConnection) {
        this.mikrotikConnection = mikrotikConnection;
    }

    public LoggingController getLoggingController() {
        return loggingController;
    }

    public void setLoggingController(LoggingController loggingController) {
        this.loggingController = loggingController;
    }

    @FXML
    public void connect(){
        if ( this.ipAddressField.getLength() != 0 && this.portField.getLength()!=0){
            this.mikrotikConnection = new MikrotikConnection(ipAddressField.getText(), Integer.valueOf(portField.getText()));
            this.mikrotikConnection.run();
            if (this.mikrotikConnection.isConnectioinStatus()){
                System.out.println("Connection Okkk");
                this.loggingController.setMikrotikConnection(this.mikrotikConnection);
                this.primaryStage.setScene(this.getLoggingScene());
                this.primaryStage.show();
            }
        }

    }

    @FXML
    public void exit(){
        Platform.exit();
        System.exit(0);
    }
}
