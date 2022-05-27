package onlineStore;

import Category.Product;
import lombok.SneakyThrows;

import java.util.List;

import static util.RandomStorePopulator.generateTimeNumber;

public class ThreadCart implements Runnable{

    Integer time;
    Product product;

    public ThreadCart(Product product) {
        this.product = product;
    }

    @SneakyThrows
    @Override
    public void run() {
            time = generateTimeNumber() * 1000;
            Store.getInstance().purchasedProducts.add(product);
            System.out.println("The '" + product.getName() + "' will be added to the order in " + time + " milliseconds via " + Thread.currentThread());
            Thread.sleep(time);

    }


}
