package com.werwolfvpn;

import com.opencsv.exceptions.CsvException;
import com.werwolfvpn.api.GetServers;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, CsvException {
        GetServers servers = new GetServers();
        servers.csvdownload();

    }
}
