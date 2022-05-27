package consoleApp;

import util.DataBase;
import onlineStore.Store;
import onlineStore.http.Client;
import onlineStore.http.Server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static onlineStore.Store.clearStore;
import static onlineStore.StoreHelper.readerOrder;

public class StoreApp {


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Store store = Store.getInstance();


//        store.fillCategories();
//        store.printStore();
//        store.preparingStore(store);


//        Timer timer = new Timer();
//        timer.schedule(new ThreadTime(), 0, 60000);

        Server server = new Server();
        server.startHttpServer();
        Client client = new Client();
        System.out.println("Categories:");
        client.getCategories();
        System.out.println("All products");
        client.getProductsList();

        Boolean flag = true;
        Boolean flag2 = true;
        String order = readerOrder();
        while (flag) {
            switch (order) {
                case "sort":
                    System.out.println("sorted products:");
//                    store.sort(order);
                    client.getSortProducts();
                    clearStore();
                    server.getServer().stop(5);
                    flag = false;
                    break;
                case "top":
                    System.out.println("top products:");
//                    store.top(order);
                    client.getTopProducts();
                    clearStore();
                    server.getServer().stop(5);
                    flag = false;
                    break;
                case "quit":
                    flag = false;
                    clearStore();
                    server.getServer().stop(5);
//                    timer.cancel();
                    break;
                case "create order":
                    DataBase.createProductTableForCart();
                    while (flag2) {
                        System.out.println("please type the product\nor\n - clear\n - completed");
                        String productName = new Scanner(System.in).next();
                        switch (productName) {
                            case "clear":
                                flag2 = false;
                                DataBase.deleteProductToCartTable();
                                break;
                            case "completed":
                                client.addToCart();
                                flag2 = false;
                                DataBase.deleteProductToCartTable();
                                break;
                            default:
//                                store.createOrder(productName);
                                store.createOrderToCart(productName);
                        }
                    }
                default:
                    System.out.println("");
                    order = readerOrder();
            }
        }
//        store.printStore();
    }
}