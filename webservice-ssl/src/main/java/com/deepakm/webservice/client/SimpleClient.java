package com.deepakm.webservice.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by dmarathe on 6/15/15.
 */
public class SimpleClient {

    SimpleClient(String clientKeyStoreFile, String clientKeyStorePassword){
        System.setProperty("javax.net.ssl.trustStore", clientKeyStoreFile);
        System.setProperty("javax.net.ssl.trustStorePassword", clientKeyStorePassword);
    }

    public String hitRestURL(String url) throws IOException {

        StringBuilder stringBuffer = new StringBuilder();
        try (CloseableHttpClient httpclient = HttpClients.custom().build()) {
            HttpGet httpget = new HttpGet(url);
            try (CloseableHttpResponse response = httpclient.execute(httpget);
                 InputStream inputStream = response.getEntity().getContent();
                 Scanner s = new Scanner(inputStream)) {
                while (s.hasNextLine()) {
                    stringBuffer.append(s.nextLine());
                }
            }
        }
        return stringBuffer.toString();
    }
}
