package onlineStore;

import Category.Product;

import java.util.TimerTask;

public class ThreadTime extends TimerTask {
    Store store;


    @Override
    public void run() {

        for (Product product : store.purchasedProducts) {
            System.out.println("The '" + product.getName() + "' will deleted from order");
        }
        store.purchasedProducts.clear();
    }
}
