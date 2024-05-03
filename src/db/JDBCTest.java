package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTest {
    public static void main(String[] args) throws IOException, SQLException {

        InputStream inputStream = ClassLoader.getSystemResourceAsStream("datasource.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("datasource.url");
        String username = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");

        DriverManager.getConnection(url, username, password);
        System.out.println("sucess");
    }
}

