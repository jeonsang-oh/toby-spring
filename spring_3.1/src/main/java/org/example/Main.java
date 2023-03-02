package org.example;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&serverTimezone=Asia/Seoul";
        String userName = "root";
        String password = "00000000";
        Properties props = new Properties();

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from users");

        resultSet.next();
        String name = resultSet.getString("name");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}