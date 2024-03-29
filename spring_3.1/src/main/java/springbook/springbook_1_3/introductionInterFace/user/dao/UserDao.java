package springbook.springbook_1_3.introductionInterFace.user.dao;

import springbook.springbook_1_3.introductionInterFace.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker connectionMaker;

    // ConnectionMaker 인터페이스를 구현받아 만든 커넥션 메이커로 생성자 세팅
   public UserDao() {
        connectionMaker = new NConnectionMaker();
   }

   public void add(User user) throws SQLException, ClassNotFoundException {
       Connection c = connectionMaker.makeConnection();
       PreparedStatement ps = c.prepareStatement(
               "insert into users(id, name, password) values(?,?,?)");
       ps.setString(1, user.getId());
       ps.setString(2, user.getName());
       ps.setString(3, user.getPassword());
       ps.executeUpdate();

       ps.close();
       c.close();
   }

   public User get(String id) throws SQLException, ClassNotFoundException {
       Connection c = connectionMaker.makeConnection();

       PreparedStatement ps = c.prepareStatement(
               "select * from users where id = ?");

       ps.setString(1, id);

       ResultSet rs = ps.executeQuery();
       rs.next();
       User user = new User();
       user.setId(rs.getString("id"));
       user.setName(rs.getString("name"));
       user.setPassword(rs.getString("password"));

       rs.close();
       ps.close();
       c.close();

       return user;
   }
}
