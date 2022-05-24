package onlineStore.http.handler;

import Category.Product;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import lombok.SneakyThrows;
import util.DataBase;

import java.io.OutputStream;
import java.util.List;

import static onlineStore.Store.preparingStore;

public class ProductsHandler implements HttpHandler {
    @SneakyThrows
    @Override
    public void handle(HttpExchange exchange) {
//        List<Product> products = Store.getInstance().getAllProducts();
        preparingStore();
        List<Product> products = DataBase.getAllProducts();
        ObjectMapper mapper = new ObjectMapper();
        OutputStream outputStream;

        byte[] jsoninBytes = mapper.writeValueAsBytes(products);
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, jsoninBytes.length);
        outputStream = exchange.getResponseBody();
        outputStream.write(jsoninBytes);
    }
}
