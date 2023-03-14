package springbook.springbook_1_2.makeConnection_2.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // N사 DB Connection 생성코드
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&serverTimezone=Asia/Seoul", "root", "00000000");
        return c;
    }
}

