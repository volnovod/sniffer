package com.mikrotikSniffer.Controller;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Created by victor on 06.01.16.
 */
public class MikrotikConnection extends Thread {

    private ApiConnection apiConnection;
    private String ipAddress;
    private int port;
    private boolean connectioinStatus = false;
    private String command;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ApiConnection getApiConnection() {
        return apiConnection;
    }

    public void setApiConnection(ApiConnection apiConnection) {
        this.apiConnection = apiConnection;
    }

    public boolean isConnectioinStatus() {
        return connectioinStatus;
    }

    public void setConnectioinStatus(boolean connectioinStatus) {
        this.connectioinStatus = connectioinStatus;
    }

    public MikrotikConnection(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.connectioinStatus = false;
    }

    @Override
    public void run(){
        try {
            this.apiConnection = ApiConnection.connect(getIpAddress(), getPort(), 2000);
            this.connectioinStatus = true;
        } catch (MikrotikApiException e) {
            System.out.println(e.getMessage());
            this.connectioinStatus=false;
            e.printStackTrace();
        }
    }
}
