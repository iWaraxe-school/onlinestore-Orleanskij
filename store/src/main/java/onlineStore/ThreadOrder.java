package onlineStore;

import Category.Product;
import lombok.SneakyThrows;

import java.util.List;

import static util.RandomStorePopulator.generateTimeNumber;

public class ThreadOrder implements Runnable {

    List<Product> orders;
    Integer time;
    Product product;

    public ThreadOrder(List<Product> orders) {
        this.orders = orders;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (Product pr : orders) {
            product = pr;
            time = generateTimeNumber() * 1000;
            Store.purchasedProducts.add(product);
            System.out.println("The '" + product.getName() + "' will be added to the order in " + time + " milliseconds via " + Thread.currentThread());
            Thread.sleep(time);
        }
    }
}
