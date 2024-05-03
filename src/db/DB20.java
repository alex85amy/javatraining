package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;

public class DB20 {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public DB20() throws SQLException, IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("datasource.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("datasource.url");
        String username = properties.getProperty("datasource.username");
        String password = properties.getProperty("datasource.password");
        connection = DriverManager.getConnection(url, username, password);
    }

    public void addMember(String account, String password, String name, String email, String gender, String isBlock) throws SQLException {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now().withNano(0);
        String isAd = "KM";
        String createDate = currentDate.toString();
        String createTime = currentTime.toString();
        String sql = "INSERT INTO eip_member (m_account, m_password, m_name, m_email, m_gender, m_block, is_ad, m_create_date, m_create_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, gender);
        preparedStatement.setString(6, isBlock);
        preparedStatement.setString(7, isAd);
        preparedStatement.setString(8, createDate);
        preparedStatement.setString(9, createTime);
        preparedStatement.executeUpdate();
    }


    public void updateMember(String account, String password, String name, String email, String gender, String isBlock) throws SQLException {
        String sql = "UPDATE eip_member SET m_password=?, m_name=?, m_email=?, m_gender=?, m_block=? WHERE m_account=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, email);
        preparedStatement.setString(4, gender);
        preparedStatement.setString(5, isBlock);
        preparedStatement.setString(6, account);
        preparedStatement.executeUpdate();
    }


    public void searchMember(String search) throws SQLException {
        String sql = "SELECT * FROM eip_member WHERE m_account LIKE ? OR m_name LIKE ? OR m_email LIKE ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + search + "%");
        preparedStatement.setString(2, "%" + search + "%");
        preparedStatement.setString(3, "%" + search + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String account = resultSet.getString("m_account");
            String password = resultSet.getString("m_password");
            String name = resultSet.getString("m_name");
            String email = resultSet.getString("m_email");
            String gender = resultSet.getString("m_gender");
            String isBlock = resultSet.getString("m_block");
            String isAd = resultSet.getString("is_ad");
            String createDate = resultSet.getString("m_create_date");
            String createTime = resultSet.getString("m_create_time");

            System.out.println("Account: " + account);
            System.out.println("Password: " + password);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Gender: " + gender);
            System.out.println("Is Blocked: " + isBlock);
            System.out.println("Is Ad: " + isAd);
            System.out.println("Create Date: " + createDate);
            System.out.println("Create Time: " + createTime);
            System.out.println();
        }
    }


    public void deleteMember(String account) throws SQLException {
        String sql = "DELETE FROM eip_member WHERE m_account=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, account);
        preparedStatement.executeUpdate();
    }


    public void close() throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}

