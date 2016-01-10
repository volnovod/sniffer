package com.mikrotikSniffer.Controller;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Created by Victor on 10.01.2016.
 */
public class MikrotikLogging extends Thread {

    private ApiConnection apiConnection;
    private String login;
    private String password;
    private boolean loggingStatus;

    public boolean isLoggingStatus() {
        return loggingStatus;
    }

    public ApiConnection getApiConnection() {
        return apiConnection;
    }

    public void setApiConnection(ApiConnection apiConnection) {
        this.apiConnection = apiConnection;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MikrotikLogging(ApiConnection apiConnection, String login, String password) {
        this.apiConnection = apiConnection;
        this.login = login;
        this.password = password;
        this.loggingStatus = false;
    }

    @Override
    public void run(){
        if (this.login.length()!=0){
            try {
                this.apiConnection.login(this.login, this.password);
                this.loggingStatus=true;
            } catch (MikrotikApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
