package onlineStore;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static onlineStore.StoreHelper.readerOrder;

public class StoreApp {


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Store store = new Store();
        store.fillCategories();
        store.printStore();

        Boolean flag = true;
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
                    break;
                default:
                    System.out.println("incorrect order");
                    order = readerOrder();
            }
        }
//        store.printStore();
    }
}