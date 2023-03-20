package springbook.springbook_1_3.objectFactory.user.dao;


import java.sql.Connection;
import java.sql.SQLException;

// 인터페이스 생성
public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
