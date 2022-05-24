package onlineStore.http;

import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import onlineStore.http.handler.CartHandler;
import onlineStore.http.handler.ProductSortHandler;
import onlineStore.http.handler.ProductsHandler;
import onlineStore.http.handler.ProductsTopHandler;

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
