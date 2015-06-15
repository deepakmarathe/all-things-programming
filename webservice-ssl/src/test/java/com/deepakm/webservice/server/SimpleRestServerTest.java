package com.deepakm.webservice.server;

import com.deepakm.webservice.util.PKIUtil;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by dmarathe on 6/15/15.
 */
public class SimpleRestServerTest {

    @Test
    public void testServerUp() throws Exception {
        String host = "localhost";
        int port = 8443;
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

        SimpleRESTServer simpleRESTServer = new SimpleRESTServer.Builder()
                .host(host)
                .port(port)
                .keyStorePath(keyStorePath)
                .keyStorePassword(keyStorePassword)
                .abstractHandler(helloHandler)
                .build();

        simpleRESTServer.startServer();
        simpleRESTServer.stopServer();
    }
}
