package com.werwolfvpn.api;

import java.io.IOException;

public class Create {
    public void create(String name, int serveraddress) {
        try {
            Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /c powershell Add-VpnConnection -Name" + name + " -ServerAddress + " + serveraddress + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
