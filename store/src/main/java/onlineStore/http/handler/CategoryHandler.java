package onlineStore.http.handler;

import Category.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;
import util.DataBase;

import java.io.OutputStream;
import java.util.List;

import static onlineStore.Store.preparingStore;

public class CategoryHandler implements HttpHandler {
        @SneakyThrows
        @Override
        public void handle(HttpExchange exchange) {
            preparingStore();
            List<Category> category = DataBase.getAllCategories();
            ObjectMapper mapper = new ObjectMapper();
            OutputStream outputStream;

            byte[] jsoninBytes = mapper.writeValueAsBytes(category);
            Headers headers = exchange.getResponseHeaders();
            headers.add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsoninBytes.length);
            outputStream = exchange.getResponseBody();
            outputStream.write(jsoninBytes);
        }
}
