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

    private MikrotikLogging logging = null;
    private ApiConnection connection;

    public ApiConnection getConnection() {
        return connection;
    }

    public void setConnection(ApiConnection connection) {
        this.connection = connection;
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
        System.out.println();
        if ( this.loginField.getLength() != 0 ){
            this.logging = new MikrotikLogging(ipAddressField.getText(), Integer.valueOf(portField.getText()));
            this.logging.run();
            this.setConnection(this.logging.getApiConnection());
            try {
                this.connection.login(this.loginField.getText(), this.passwordField.getText());
                this.connection.execute("/system/reboot");
            } catch (MikrotikApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void exit(){
        Platform.exit();
        System.exit(0);
    }

}
