package com.werwolfvpn.api;

import java.io.IOException;

public class Connect {
    public void connect(String name) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c rasdial " + name + " vpn vpn");
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
