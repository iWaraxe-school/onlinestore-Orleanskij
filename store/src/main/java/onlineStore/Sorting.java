package onlineStore;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;


import static util.ParsingXML.readerMap;

public class Sorting implements Comparator<Product>{

    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }

    private static Comparator<Product> getComparator(String sortKey) {
        switch (sortKey){
            case ("name"):
                return Comparator.comparing(Product::getName);
            case("price"):
                return Comparator.comparingInt(Product::getPrice);
            case ("rate"):
                return Comparator.comparingInt(Product::getRate);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static List<Product> sortProductList(List<Product> productList) throws IOException, ParserConfigurationException, SAXException {
        List<Product> productsOfList = new ArrayList<>(productList);
        Map<String, String> sortingMap = readerMap();
        for (String sortKey : sortingMap.keySet()) {
            if (sortingMap.get(sortKey).equals("asc")) {
                productsOfList.sort(getComparator(sortKey));
            } else if (sortingMap.get(sortKey).equals("desc")) {
                productsOfList.sort(getComparator(sortKey).reversed());
            }
        }
        return productsOfList;
    }

    public static void sortProductListByPrice(List<Product> productList) {
        productList.sort(getComparator("price").reversed());
    }
}
