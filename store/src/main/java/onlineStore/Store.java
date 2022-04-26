package onlineStore;

import org.xml.sax.SAXException;
import util.RandomStorePopulator;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static onlineStore.StoreHelper.createCategoriesList;

public class Store {
    private List<Category> categories;


    public Store() {
        categories = createCategoriesList();
    }

    public void fillCategories() {
        RandomStorePopulator populator = new RandomStorePopulator();
        Random random = new Random();

        for (Category category : categories) {
            int j = random.nextInt(10);

            for (int i = 0; i < j; i++) {
                String name = populator.generateName(category.getName());
                int rate = populator.generateRate();
                int price = populator.generatePrice();
                Product product = new Product(name, rate, price);
                category.putProductToList(product);
            }
        }
    }

    public void printStore() {
        for (Category category : categories) {
            System.out.println("Category: " + category.getName());

            for (Product product : category.getProductList()) {
                product.printProduct();
            }
        }
    }

    public String reader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please type the command");
        String s = reader.readLine();
        System.out.println("you typed: " + s);
        return s;
    }

    public void sort() throws IOException, ParserConfigurationException, SAXException {
        for (Category category : categories) {
            System.out.println("Category: " + category.getName());
            List<Product> list = Sorting.sortProductList(category.getProductList());
            for (Product product : list) {
                product.printProduct();
            }
        }
    }

    public void top() {
        List<Product> productList = new ArrayList<>();

        for (Category category : categories) {
            productList.addAll(category.getProductList());
        }
        Sorting.sortProductListByPrice(productList);
        System.out.println("Top 5 products by price:");

        for (int i = 0; i < 5; i++) {
            System.out.println(productList.get(i));
        }
    }

}



