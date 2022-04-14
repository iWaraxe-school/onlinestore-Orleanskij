package onlineStore;


public class StoreApp {


    public static void main(String[] args) {
        Store store = new Store();
        store.fillCategories();
        store.printStore();
    }
}
