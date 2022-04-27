package onlineStore;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class StoreApp {


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Store store = new Store();
        store.fillCategories();
        store.printStore();

        Boolean flag = true;

        while (flag) {
            switch (store.reader()) {
                case "sort":
                    System.out.println("you typed the 'sort' command");
                    store.sort();
                    flag= false;
                    break;
                case "top":
                    System.out.println("you typed the 'top' command");
                    store.top();
                    flag= false;
                    break;
                case "quit":
                    System.out.println("quit");
                    flag= false;
                    break;
                default:
                    System.out.println("type again");
            }
        }
//        store.printStore();
    }
}