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
            this.mikrotikConnection = new MikrotikConnection(ipAddressField.getText(), Integer.valueOf(portField.getText()));
            this.mikrotikConnection.run();
            this.setConnection(this.mikrotikConnection.getApiConnection());
            try {
                if (this.connection!=null){
                    this.connection.login(this.loginField.getText(), this.passwordField.getText());
                }
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
