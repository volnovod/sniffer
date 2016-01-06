package com.mikrotikSniffer.Controller;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;

/**
 * Created by victor on 06.01.16.
 */
public class MikrotikLogging extends Thread {

    private ApiConnection apiConnection;
    private String ipAddress;
    private int port;

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

    public MikrotikLogging(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void run(){
        try {
            this.apiConnection = ApiConnection.connect(getIpAddress(), getPort(), 2000);
            System.out.println("good");
            System.out.println(this.getName());
        } catch (MikrotikApiException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
