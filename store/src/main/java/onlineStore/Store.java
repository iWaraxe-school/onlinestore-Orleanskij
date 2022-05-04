package onlineStore;

import Category.Category;
import Category.Product;

import Category.categories.Categories;
import util.RandomStorePopulator;

import java.util.*;

import static onlineStore.StoreHelper.createCategoriesList;
import static util.ParsingXML.readerMap;

public class Store {
    private List<Category> categories;

    private static Store instance;

    public static Store getInstance() {  //Singleton
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public Store() {
//        categories = createCategoriesList();
        categories = createCategoryList();   //Factory pattern
    }

    public List<Category> createCategoryList() {
        List<Category> categoryToAdd = new ArrayList<>();
        CategoryFactory factory = new CategoryFactory();
        for (Categories category : Categories.values()) {
            categoryToAdd = factory.createCategories(category);
        }
        return categoryToAdd;
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

    List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        for (Category category : categories) {
            list.addAll(category.getProductList());
        }
        return list;
    }

    public void sort(String order) {
        for (Category category : categories) {
            System.out.println("Category: " + category.getName());
            List<Product> list = new ArrayList<>();
            try {
                list = Sorting.sortProductList(category.getProductList(), readerMap(order));
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Product product : list) {
                product.printProduct();
            }
        }
    }

    public void top(String order) {
        List<Product> sortedProductList = new ArrayList<>();
        try {
            sortedProductList = Sorting.sortProductList(getAllProducts(), readerMap(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Top 5 products by price:");

        for (int i = 0; i < 5; i++) {
            System.out.println(sortedProductList.get(i));
        }
    }

}



