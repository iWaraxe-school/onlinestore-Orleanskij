package onlineStore;

import util.RandomStorePopulator;

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
}



