package consoleApp;

import onlineStore.DataBase;
import onlineStore.Store;
import onlineStore.ThreadTime;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Timer;

import static onlineStore.StoreHelper.readerOrder;

public class StoreApp {



    public static void main(String[] args) throws IOException, SQLException {
        Store store = Store.getInstance();
        store.fillCategories();
        store.printStore();

        Timer timer = new Timer();
        timer.schedule(new ThreadTime(), 0, 60000);

        Boolean flag = true;
        Boolean flag2 = true;
        String order = readerOrder();
        while (flag) {
            switch (order) {
                case "sort":
                    store.sort(order);
                    flag = false;
                    break;
                case "top":
                    store.top(order);
                    flag = false;
                    break;
                case "quit":
                    flag = false;
                    DataBase.deleteProductTable();
                    DataBase.deleteCategoryTable();
                    DataBase.closeConnection();
                    timer.cancel();
                    break;
                case "create order":
                    while (flag2) {
                        System.out.println("please type the product");
                        String productName = new Scanner(System.in).next();
                        switch (productName) {
                            case "stop":
                                flag2 = false;
                                break;
                            default:
                                store.createOrder(productName);
                        }
                    }
                default:
                    System.out.println("incorrect order");
                    order = readerOrder();
            }
        }
//        store.printStore();
    }
}