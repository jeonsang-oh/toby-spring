package springbook.springbook_1_3.separationResponsibilities.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class NConnectionMaker implements ConnectionMaker {


    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&serverTimezone=Asia/Seoul", "root", "00000000");
        return c;
    }
}
