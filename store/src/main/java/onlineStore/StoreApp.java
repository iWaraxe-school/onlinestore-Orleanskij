package onlineStore;

import onlineStore.categories.Bike;
import onlineStore.categories.Milk;
import onlineStore.categories.Phone;

import java.util.ArrayList;
import java.util.List;

import static util.RandomStorePopulator.generatePrice;
import static util.RandomStorePopulator.generateRate;

public class StoreApp {


    public static void main(String[] args) {
        Store store = new Store();
        Product savushkin = new Product("3%", new Milk(), generateRate(), generatePrice());
        Product savushkin2 = new Product("9%", new Milk(), generateRate(), generatePrice());
        Product phone = new Product("Samsung", new Phone(), generateRate(), generatePrice());
        Product bike = new Product("gorniy", new Bike(), generatePrice(), generatePrice());
        List<Product> objects = new ArrayList<>();
        objects.add(savushkin);
        objects.add(savushkin2);
        objects.add(phone);
        objects.add(bike);

        store.initStore(objects);
        store.printStore();
    }
}
