package onlineStore;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class Sorting implements Comparator<Product> {

    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }

    private static Comparator<Product> getComparator(String sortKey) {
        switch (sortKey) {
            case ("name"):
                return Comparator.comparing(Product::getName);
            case ("price"):
                return Comparator.comparingInt(Product::getPrice);
            case ("rate"):
                return Comparator.comparingInt(Product::getRate);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static List<Product> sortProductList(List<Product> productList, Map<String, String> sortingMap) throws IOException, ParserConfigurationException, SAXException {
        List<Product> productsOfList = new ArrayList<>(productList);
        for (Map.Entry<String, String> entry : sortingMap.entrySet()) {
            if (entry.getValue().equals("asc")) {
                productsOfList.sort(getComparator(entry.getKey()));
            } else if (entry.getValue().equals("desc")) {
                productsOfList.sort(getComparator(entry.getKey()).reversed());
            }
        }
        return productsOfList;
    }
}
