package onlineStore;

public class Product {

    protected String name;
    protected int rate;
    protected int price;

    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public void printProduct() {
        System.out.println("Name: " + name + ";  Rate: " + rate + ";  Price: " + price + ";");
    }

}
