package com.werwolfvpn.api;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class GetServers {
    public static void main(String[] args) throws IOException {
        new GetServers().download();
    }
    private void download() throws IOException {
        File f = new File("index.html");
        if(!f.exists()) {
            InputStream in = new URL("https://www.vpngate.net/en/").openStream();
            Files.copy(in, Paths.get("index.html"), StandardCopyOption.REPLACE_EXISTING);
        }
        readReplace();
    }
    private void readReplace() {
        try {
            boolean found = false;
            boolean first = true;
            String out = "";
            File myObj = new File("index.html");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                /**
                if(data.contains("<table")) {
                   found = true;
                }
                if(data.contains("<table id=\"vg_hosts_table_id\" cellspacing=\"0\" cellpadding=\"4\" border=\"1\">")) {
                    found = false;
                }
                if(data.contains("<table id=\"vpngate_menu_table\">")) {
                    found = false;
                }
                if(data.contains("<table style=\"width: 100%\" cellpadding=\"8\">")) {
                    found = false;
                }
                if(data.contains("<table id=\"vpngate_footer_table\">")) {
                    found = false;
                }
                if(data.contains("<table border=\"1\" id=\"vg_hosts_table_id\" cellspacing=\"0\" cellpadding=\"4\" align=\"center\">")) {
                    found = false;
                }
                if(data.contains("<table border=\"1\" id=\"vg_hosts_table_id\" cellspacing=\"0\" cellpadding=\"4\" align=\"center\">")) {
                    found = false;
                }
                if(data.contains("</table>")) {
                    found = false;
                }
                 **/
                if(data.contains("Label_Table")) {
                    found = true;
                    first = true;
                }
                if(data.contains("</span>")) {

                }
                if(found) {
                    if (out == "") {
                        out = data;
                    }else {
                        out = out + "\n" + data;
                    }
                }
            }
            try {
                FileWriter myWriter = new FileWriter("edit.html");
                myWriter.write(out);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
