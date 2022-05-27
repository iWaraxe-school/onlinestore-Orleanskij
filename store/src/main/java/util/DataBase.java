package util;

import Category.Category;
import Category.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    static final String DATA_DRIVER = "org.h2.Driver";
    static final String URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASSWORD = "";
    static Connection CONNECTION = null;
    static Statement STATEMENT = null;


    public static void makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DATA_DRIVER);
        CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
        STATEMENT = CONNECTION.createStatement();
    }

    public static void closeConnection() throws SQLException {
        CONNECTION.close();
    }

    public static void createCategoryTable() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS CATEGORIES (" +
                "id INTEGER PRIMARY KEY," +
                "name VARCHAR NOT NULL)";
        STATEMENT.executeUpdate(query);
    }

    public static void createProductTable() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS PRODUCTS (" +
                "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY," +
                "category_id INTEGER NOT NULL," +
                "name VARCHAR NOT NULL," +
                "price INTEGER NOT NULL," +
                "rate INTEGER NOT NULL," +
                "FOREIGN KEY (category_id)" +
                "REFERENCES Categories (id))";
        STATEMENT.executeUpdate(query);
    }

    public static void createProductTableForCart() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS PRODUCTS_CART (" +
                "id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY," +
                "name VARCHAR NOT NULL," +
                "price INTEGER NOT NULL," +
                "rate INTEGER NOT NULL)";
        STATEMENT.executeUpdate(query);
    }

    public static void insertProductTable(int categoryId, Product product) throws SQLException {
        String query = "INSERT INTO PRODUCTS(category_id,name,price,rate) VALUES (" + categoryId + ", '" + product.getName() + "', " + product.getPrice() + "," + product.getRate() + ");";
        STATEMENT.executeUpdate(query);
    }

    public static void insertCategoryTable(int id, String categoryName) throws SQLException {
        String query = "INSERT INTO CATEGORIES(id, name) VALUES (" + id + ", '" + categoryName + "');";
        STATEMENT.executeUpdate(query);
    }

    public static void deleteCategoryTable() throws SQLException {
        String query = "DELETE FROM CATEGORIES";
        STATEMENT.executeUpdate(query);
    }

    public static void deleteProductTable() throws SQLException {
        String query = "DELETE FROM PRODUCTS";
        STATEMENT.executeUpdate(query);
    }

    public static void deleteProductToCartTable() throws SQLException {
        String query = "DELETE FROM PRODUCTS_CART";
        STATEMENT.executeUpdate(query);
    }

    public static List<Category> getAllCategories() throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM CATEGORIES";
        ResultSet result = STATEMENT.executeQuery(query);
        List<Category> listOfAllCategories = new ArrayList<>();
        while (result.next()) {
            Category category = new Category(result.getString("NAME"));
            listOfAllCategories.add(category);
        }
        return listOfAllCategories;
    }

    public static List<Product> getAllProducts() throws SQLException, ClassNotFoundException {
        String query = String.format("SELECT NAME, PRICE, RATE from PRODUCTS");
        ResultSet result = STATEMENT.executeQuery(query);
        List<Product> listOfAllProducts = new ArrayList<>();
        while (result.next()) {
            Product listed = new Product(result.getString("NAME"), result.getInt("RATE"), result.getInt("PRICE"));
            listOfAllProducts.add(listed);
        }
        return listOfAllProducts;
    }

    public static List<Product> getProducts(String category) throws SQLException, ClassNotFoundException {
        String query = String.format("SELECT P.NAME, P.PRICE, P.RATE, C.NAME from PRODUCTS P INNER JOIN CATEGORIES C ON C.ID=P.CATEGORY_ID where C.NAME = '%s'", category);
        ResultSet result = STATEMENT.executeQuery(query);
        List<Product> listOfAllProducts = new ArrayList<>();
        while (result.next()) {
            Product listed = new Product(result.getString("NAME"), result.getInt("RATE"), result.getInt("PRICE"));
            listOfAllProducts.add(listed);
        }
        return listOfAllProducts;
    }

    public static void insertProductForCartTable(Product product) throws SQLException {
        String query = "INSERT INTO PRODUCTS_CART(name,price,rate) VALUES ('" + product.getName() + "', " + product.getPrice() + "," + product.getRate() + ");";
        STATEMENT.executeUpdate(query);
    }

    public static List<Product> getAllProductsFromCart() throws SQLException, ClassNotFoundException {
        String query = String.format("SELECT * from PRODUCTS_CART");
        ResultSet result = STATEMENT.executeQuery(query);
        List<Product> listOfAllProducts = new ArrayList<>();
        while (result.next()) {
            Product listed = new Product(result.getString("NAME"), result.getInt("RATE"), result.getInt("PRICE"));
            listOfAllProducts.add(listed);
        }
        return listOfAllProducts;
    }

    public static List<Product> getTopProducts() throws SQLException, ClassNotFoundException {
        String query = String.format("select * from products ORDER BY Price LIMIT 5");
        ResultSet result = STATEMENT.executeQuery(query);
        List<Product> listOfAllProducts = new ArrayList<>();
        while (result.next()) {
            Product listed = new Product(result.getString("NAME"), result.getInt("RATE"), result.getInt("PRICE"));
            listOfAllProducts.add(listed);
        }
        return listOfAllProducts;
    }

    public static List<Product> getSortProducts() throws SQLException, ClassNotFoundException {
        String query = String.format("select * from products ORDER BY Rate");
        ResultSet result = STATEMENT.executeQuery(query);
        List<Product> listOfAllProducts = new ArrayList<>();
        while (result.next()) {
            Product listed = new Product(result.getString("NAME"), result.getInt("RATE"), result.getInt("PRICE"));
            listOfAllProducts.add(listed);
        }
        return listOfAllProducts;
    }
}