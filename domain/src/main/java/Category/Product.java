package Category;

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
        System.out.println("Name: " + getName() + ";  Rate: " + getRate() + ";  Price: " + getPrice() + ";");
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name='" + getName() + '\'' +
                ", rate=" + getRate() +
                ", price=" + getPrice();
    }
}
