package onlineStore;

import Category.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}