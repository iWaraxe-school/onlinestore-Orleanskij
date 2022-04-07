package util;

import com.github.javafaker.Faker;


public class RandomStorePopulator {

    public static int generatePrice(){
        Faker faker = new Faker();
        int number= faker.number().numberBetween(1,10);
        return number;
    }

    public static int generateRate(){
        Faker faker = new Faker();
        int number= faker.number().numberBetween(1,10);
        return number;
    }

//    public String generateName(){
//        Faker faker = new Faker();
//        String food =faker.food().ingredient();
//        return food;
//    }
}
