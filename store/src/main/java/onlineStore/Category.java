package onlineStore;

import java.util.ArrayList;
import java.util.List;

public class Category {

    public String name;
    public List<Product> productList;

    public Category(String name) {
        this.name = name;
        productList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void putProductToList(Product product) {
        productList.add(product);
    }
}
