package com.deepakm.webservice.client;

import com.deepakm.webservice.server.SimpleRESTServer;
import com.deepakm.webservice.util.PKIUtil;
import junit.framework.Assert;
import org.apache.http.NoHttpResponseException;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by dmarathe on 6/15/15.
 */

public class SimpleClientTest {
    private static SimpleClient simpleClient;
    private static SimpleRESTServer simpleRESTServer;
    private final static String responseContent = "<h1>Hello World from Hello Handler! </h1>";
    private static final String host = "localhost";
    private static final int port = 8443;

    @BeforeClass
    public static void setUp() throws Exception {
        String keyStorePath = File.createTempFile("eldarserverkeystore", "jks").getAbsolutePath();
        String keyStorePassword = "password";
        String certificatePath = File.createTempFile("eldarservercertificate", "crt").getAbsolutePath();
        PKIUtil.generateSelfSignedCertificate(host, keyStorePath, certificatePath, keyStorePassword);

        AbstractHandler helloHandler = new AbstractHandler() {
            public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
                httpServletResponse.setContentType("text/html;charset=utf-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                request.setHandled(true);
                httpServletResponse.getWriter().println("<h1>Hello World from Hello Handler! </h1>");
            }
        };

        simpleRESTServer = new SimpleRESTServer.Builder()
                .host(host)
                .port(port)
                .keyStorePath(keyStorePath)
                .keyStorePassword(keyStorePassword)
                .abstractHandler(helloHandler)
                .build();
        simpleRESTServer.startServer();


        String clientKeyStoreFile = File.createTempFile("keystore", "jks").getAbsolutePath();
        String clientKeyStorePassword = "password";
        PKIUtil.importCertToKeystore(certificatePath, clientKeyStoreFile, clientKeyStorePassword);
        simpleClient = new SimpleClient(clientKeyStoreFile, clientKeyStorePassword);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        simpleRESTServer.stopServer();
    }

    @Test
    public void testHitRESTUrl() throws Exception {
        String response = simpleClient.hitRestURL("https://" + host + ":" + port);
        Assert.assertEquals(response, responseContent);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPort() throws IOException {
        int port = SimpleClientTest.port + 1;
        String response = simpleClient.hitRestURL("https://" + host + ":" + port + 1);
        assert response == null;
    }

    @Test(expected = UnknownHostException.class)
    public void testInvalidHost() throws IOException {
        String host = SimpleClientTest.host + "-nonexistent-host";
        String response = simpleClient.hitRestURL("https://" + host + ":" + port);
        assert response == null;
    }

    @Test(expected = NoHttpResponseException.class)
    public void testInvalidProtocol() throws IOException {
        String protocol = "http://";
        String response = simpleClient.hitRestURL(protocol + host + ":" + port);
        assert response == null;
    }

}
