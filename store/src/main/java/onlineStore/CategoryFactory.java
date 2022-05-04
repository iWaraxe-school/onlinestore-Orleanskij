package onlineStore;

import Category.Category;
import Category.categories.Bike;
import Category.categories.Categories;
import Category.categories.Milk;
import Category.categories.Phone;

import java.util.ArrayList;
import java.util.List;

public class CategoryFactory {
    List<Category> categorylist = new ArrayList<>();

    public List<Category> createCategories(Categories type) {

        Category category = null;
        switch (type) {
            case Phone:
                category = new Phone();
                break;
            case Bike:
                category = new Bike();
                break;
            case Milk:
                category = new Milk();
                break;
        }

        categorylist.add(category);
        return categorylist;
    }


}
