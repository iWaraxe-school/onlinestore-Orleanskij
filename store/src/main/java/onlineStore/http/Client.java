package onlineStore.http;
import io.restassured.RestAssured;
import onlineStore.Store;

public class Client {
    private Store store;
    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    public Client() {
        store = Store.getInstance();
    }

    public void getProductsList() {
        RestAssured.given().auth().basic(USERNAME, PASSWORD).when().get("http://localhost:8090/products")
                .then().log().body();
    }

    public void addToCart() {
        RestAssured.given().auth().basic(USERNAME, PASSWORD).when().post("http://localhost:8090/cart")
                .then().log().body();
    }

    public void getTopProducts() {
        RestAssured.given().auth().basic(USERNAME, PASSWORD).when().get("http://localhost:8090/top")
                .then().log().body();
    }
    public void getSortProducts() {
        RestAssured.given().auth().basic(USERNAME, PASSWORD).when().get("http://localhost:8090/sort")
                .then().log().body();
    }

}
