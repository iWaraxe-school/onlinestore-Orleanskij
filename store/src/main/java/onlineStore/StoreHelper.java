package onlineStore;

import org.reflections.Reflections;

import java.util.*;

public class StoreHelper {


    public static List<Category> createCategoriesList() {

        List<Category> categoryToAdd = new ArrayList<>();
        Reflections reflections = new Reflections("onlineStore.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);
        for (Class<? extends Category> subType : subTypes) {
            try {
                categoryToAdd.add(subType.getConstructor().newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (categoryToAdd.isEmpty()) {
            throw new RuntimeException("categories are not created");
        }
        return categoryToAdd;
    }
}
