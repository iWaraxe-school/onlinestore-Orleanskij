package onlineStore;
import org.reflections.Reflections;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Store {
    public List<Product> productsList = new ArrayList<>();


    public void initStore(List<Product> list){
        productsList = list;
    }

    public void printStore(){

        Reflections reflections = new Reflections("onlineStore.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> subType : subTypes) {
            System.out.println(subType.getSimpleName());
            for (Product product : productsList) {
                if(product.getCategory().equals(subType.getSimpleName()))
                product.printProduct();
            }
            System.out.println();
        }

    }
}



