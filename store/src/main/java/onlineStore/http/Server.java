package onlineStore.http;

import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import onlineStore.http.handler.*;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private HttpServer server;
    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    public void startHttpServer() throws IOException {
            server = HttpServer.create(new InetSocketAddress(8090), 0);
            createContext(server, "/products", new ProductsHandler());
            createContext(server, "/cart", new CartHandler());
            createContext(server, "/top", new ProductsTopHandler());
            createContext(server, "/sort", new ProductSortHandler());
            createContext(server, "/category", new CategoryHandler());
            server.setExecutor(null);
            server.start();
    }

    private void createContext(HttpServer server, String path, HttpHandler handler){
        server.createContext(path, handler).setAuthenticator(new BasicAuthenticator("test") {
            @Override
            public boolean checkCredentials(String username, String password) {
                return username.equals(USERNAME) && password.equals(PASSWORD);
            }
        });
    }

    public HttpServer getServer() {
        return server;
    }
}
