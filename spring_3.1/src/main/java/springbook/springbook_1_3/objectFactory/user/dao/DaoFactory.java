package springbook.springbook_1_3.objectFactory.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    private ConnectionMaker connectionMaker() {
        SimpleConnectionMaker connectionMaker = new SimpleConnectionMaker();
        return connectionMaker;
    }

    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }
}
