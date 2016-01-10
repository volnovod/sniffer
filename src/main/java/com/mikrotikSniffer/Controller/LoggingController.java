package com.mikrotikSniffer.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Created by victor on 06.01.16.
 */
public class LoggingController {

    private MikrotikConnection mikrotikConnection = null;
    private ApiConnection connection;
    private MikrotikLogging mikrotikLogging;

    public ApiConnection getConnection() {
        return connection;
    }

    public void setConnection(ApiConnection connection) {
        this.connection = connection;
    }

    public MikrotikConnection getMikrotikConnection() {
        return mikrotikConnection;
    }

    public void setMikrotikConnection(MikrotikConnection mikrotikConnection) {
        this.mikrotikConnection = mikrotikConnection;
    }

    @FXML
    private Button loggingButton;

    @FXML
    private Button exitButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField ipAddressField;

    @FXML
    private TextField portField;

    @FXML
    public void logging(){
        if ( this.loginField.getLength() != 0 ){
            this.mikrotikLogging = new MikrotikLogging(this.mikrotikConnection.getApiConnection(),
                    this.loginField.getText(), this.passwordField.getText());
                if (this.mikrotikLogging!=null){
                    this.mikrotikLogging.run();
                    if (this.mikrotikLogging.isLoggingStatus()){
                        this.setConnection(this.mikrotikConnection.getApiConnection());
                        System.out.println("asdlmgkldmsfgkmdfs");
                    }
                }

        }
    }

    @FXML
    public void exit(){
        Platform.exit();
        System.exit(0);
    }

}
