package com.werwolfvpn.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Create {
    public void create(String name, String serveraddress) {
        try {
            //Runtime.getRuntime().exec("powershell Add-VpnConnection -Name" + name + " -ServerAddress + " + serveraddress + "");

            String commands = "powershell Add-VpnConnection -Name" + name + " -ServerAddress + " + serveraddress + "";
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(commands);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(proc.getErrorStream()));

// Read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

// Read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
