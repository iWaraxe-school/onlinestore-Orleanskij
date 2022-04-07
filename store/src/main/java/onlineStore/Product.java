package onlineStore;

public class Product{

    protected String name;
    protected int rate;
    protected int price;
    private Category category;


    public Product(String name, Category category, int rate, int price) {
        this.name = name;
        this.category = category;
        this.rate = rate;
        this.price = price;
    }

    public String getCategory(){
        String x = category.getName();
       return x;
    }

    public void printProduct(){
        System.out.println("Name: " + name + ";  Rate: " + rate + ";  Price: " + price + ";");
    }

}
