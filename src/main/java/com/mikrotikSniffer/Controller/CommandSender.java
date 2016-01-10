package com.mikrotikSniffer.Controller;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Created by Victor on 10.01.2016.
 */
public class CommandSender extends Thread {

    private String command;
    private ApiConnection apiConnection;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ApiConnection getApiConnection() {
        return apiConnection;
    }

    public void setApiConnection(ApiConnection apiConnection) {
        this.apiConnection = apiConnection;
    }

    public CommandSender(ApiConnection apiConnection) {
        this.apiConnection = apiConnection;
    }

    @Override
    public void run(){
        if (this.command.length() != 0){
            try {
                this.apiConnection.execute(this.getCommand());
            } catch (MikrotikApiException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
