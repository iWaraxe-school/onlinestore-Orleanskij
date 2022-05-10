package onlineStore;

import Category.Product;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;

import java.util.List;

public class ThreadTime implements Runnable {
    List<Product> orders;

    public ThreadTime(List<Product> orders) {
        this.orders = orders;
    }

    @SneakyThrows
    @Override
    public void run() {
        Faker faker = new Faker();
        int timePeriod = faker.number().numberBetween(1, 120) * 1_000;
        for (Product product : orders) {
            System.out.println("The '" + product.getName() + "' will deleted from order");
        }
        System.out.println(timePeriod + "     " + Thread.currentThread());
        Thread.sleep(timePeriod);
        orders.clear();
    }
}
