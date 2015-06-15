package com.deepakm.webservice.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.ssl.SslSelectChannelConnector;
import org.eclipse.jetty.util.ssl.SslContextFactory;

/**
 * Created by dmarathe on 6/15/15.
 */
public class SimpleRESTServer {

    private final Server server;

    private SimpleRESTServer(Server server) {
        this.server = server;
    }

    public void startServer() throws Exception {
        this.server.start();
    }

    public void stopServer() throws Exception {
        this.server.stop();
    }

    public static class Builder {
        private String host;
        private int port;
        private String keyStorePath;
        private String keyStorePassword;
        private AbstractHandler handler;

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder keyStorePath(String keyStorePath) {
            this.keyStorePath = keyStorePath;
            return this;
        }

        public Builder keyStorePassword(String keyStorePassword) {
            this.keyStorePassword = keyStorePassword;
            return this;
        }

        public Builder abstractHandler(AbstractHandler handler) {
            this.handler = handler;
            return this;
        }

        public SimpleRESTServer build() {

            SslSelectChannelConnector sslConnector = new SslSelectChannelConnector();
            sslConnector.setHost(host);
            sslConnector.setPort(port);
            SslContextFactory contextFactory = sslConnector.getSslContextFactory();
            contextFactory.setKeyStore(keyStorePath);
//contextFactory.setKeyStorePath(keyStorePath);
            contextFactory.setKeyStorePassword(keyStorePassword);

            Server server = new Server();
            server.setConnectors(new Connector[]{sslConnector});
            server.setHandler(handler);
            SimpleRESTServer simpleRESTServer = new SimpleRESTServer(server);
            return simpleRESTServer;
        }
    }

}


