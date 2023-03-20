import org.junit.jupiter.api.Test;
import springbook.springbook_1_3.separationResponsibilities.user.dao.ConnectionMaker;
import springbook.springbook_1_3.separationResponsibilities.user.dao.NConnectionMaker;
import springbook.springbook_1_3.separationResponsibilities.user.dao.UserDao;
import springbook.springbook_1_3.separationResponsibilities.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    @Test
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new NConnectionMaker();

        UserDao dao = new UserDao(connectionMaker);
        User user = new User();

        user.setId("whiteship");
        user.setName("전상오");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공!");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공!");
    }
}
