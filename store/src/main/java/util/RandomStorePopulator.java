package util;

import com.github.javafaker.Faker;


public class RandomStorePopulator {

    public static int generatePrice() {
        Faker faker = new Faker();
        int number = faker.number().numberBetween(1, 30);
        return number;
    }

    public static int generateTimeNumber() {
        Faker faker = new Faker();
        int number = faker.number().numberBetween(1, 3);
        return number;
    }

    public static int generateRate() {
        Faker faker = new Faker();
        int number = faker.number().numberBetween(1, 10);
        return number;
    }

    public static String generateName(String categoryName) {
        Faker faker = new Faker();
        String name;
        switch (categoryName) {
            case "Milk":
                name = faker.food().ingredient();
                break;
            case "Phone":
                name = faker.company().name();
                break;
            case "Bike":
                name = faker.company().name();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + categoryName);
        }
        return name;
    }
}
