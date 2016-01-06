package com.mikrotikSniffer.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by victor on 06.01.16.
 */
public class LoggingController {

    private MikrotikLogging logging = null;

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
        if ( this.loginField.getLength() != 0  && this.passwordField.getLength() != 0){
            this.logging = new MikrotikLogging(ipAddressField.getText(), Integer.valueOf(portField.getText()));
            this.logging.run();
        }
    }

    @FXML
    public void exit(){
        Platform.exit();
        System.exit(0);
    }

}
