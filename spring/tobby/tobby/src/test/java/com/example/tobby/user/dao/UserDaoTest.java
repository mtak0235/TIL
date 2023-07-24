package com.example.tobby.user.dao;

import com.example.tobby.user.domain.Level;
import com.example.tobby.user.domain.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/test.xml")
//@DirtiesContext
class UserDaoTest {

    @Autowired
    private ApplicationContext context;
    @Autowired
    UserDao dao;

    @BeforeEach
    private void setUp() {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/tobby", "tobaby", "0000", true);
//        dao.setDataSource(dataSource);
//        dao = context.getBean("userDao", UserDao.class);
        user1 = new User("a", "탁예지", "0000", Level.SILVER, 55, 10);
        user2 = new User("b", "탁도윤", "000", Level.GOLD, 100, 40);
        user3 = new User("c", "탁민경", "0000", Level.BASIC, 1, 0);

    }

    @BeforeEach
    private void initExecuted() {
        System.out.println("context = " + context);
        System.out.println("this = " + this);
    }

    @AfterEach
    private void cleanup() throws SQLException {

        dao.deleteAll();
    }

    User user3;
    User user1;
    User user2;

    @Test
    void add_get() throws SQLException, ClassNotFoundException {
//        UserDao dao = new UserDao(new DConnectionMaker());
        dao.add(user3);
        System.out.println("succeed " + user3.getId());

        User user1 = dao.get(user3.getId());
        System.out.println(user1.getId());
        System.out.println(user1.getName());
        System.out.println(user1.getPassword());
        System.out.println("succeed" + user1.getId());
    }

    @Test
    void addAndGet() throws SQLException, ClassNotFoundException {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao dao = applicationContext.getBean("userDao", UserDao.class);
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
        dao.add(user3);
        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(2);

        User userGet = dao.get(user3.getId());
        checkSameUser(userGet, user3);

        User userGet1 = dao.get(user1.getId());
        checkSameUser(userGet1, user1);
    }

    @Test
    void UserDaoXMLTest() throws SQLException, ClassNotFoundException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("test.xml");
//        ApplicationContext applicationContext = new GenericXmlApplicationContext("com/example/tobby/user/dao/applicationContext.xml");
        UserDao dao = applicationContext.getBean("userDao", UserDao.class);
        dao.add(user3);
        System.out.println("succeed " + user3.getId());

        User user1 = dao.get(user3.getId());
        System.out.println(user1.getId());
        System.out.println(user1.getName());
        System.out.println(user1.getPassword());
        System.out.println("succeed" + user1.getId());
    }

    @Test
    void userDaoReturnSameObj() {
//        DaoFactory daoFactory = new DaoFactory();
//        UserDao dao = daoFactory.userDao();
//        UserDao dao1 = daoFactory.userDao();
//        System.out.println("dao = " + dao);
//        System.out.println("dao1 = " + dao1);
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//        UserDao dao2 = context.getBean("userDao", UserDao.class);
//        UserDao dao3 = context.getBean("userDao", UserDao.class);
//        System.out.println("dao2 = " + dao2);
//        System.out.println("dao3 = " + dao3);
    }

    @Test
    public void count() throws SQLException, ClassNotFoundException {
        GenericApplicationContext context = new GenericXmlApplicationContext("test.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
        dao.add(user3);
        assertThat(dao.getCount()).isEqualTo(1);
        dao.add(user1);
        assertThat(dao.getCount()).isEqualTo(2);
        dao.add(user2);
        assertThat(dao.getCount()).isEqualTo(3);
    }

    @Test
    public void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertThat(dao.getCount()).isEqualTo(0);
        assertThrows(EmptyResultDataAccessException.class, () -> {
            dao.get("unknown");
        });
    }

    private void checkSameUser(User user, User user1) {
        assertThat(user.getId()).isEqualTo(user1.getId());
        assertThat(user.getPassword()).isEqualTo(user1.getPassword());
        assertThat(user.getName()).isEqualTo(user1.getName());
        assertThat(user.getLevel()).isEqualTo(user1.getLevel());
        assertThat(user.getLogin()).isEqualTo(user1.getLogin());
        assertThat(user.getRecommend()).isEqualTo(user1.getRecommend());
    }

    @Test
    public void getAll() throws SQLException, ClassNotFoundException {
        dao.deleteAll();
        dao.add(user1);//yeji
        List<User> users1 = dao.getAll();
        assertThat(users1.size()).isEqualTo(1);
        checkSameUser(user1, users1.get(0));
        dao.add(user2);//doyun
        List<User> users2 = dao.getAll();
        assertThat(users2.size()).isEqualTo(2);
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));
        dao.add(user3);//mtak
        List<User> users3 = dao.getAll();
        assertThat(users3.size()).isEqualTo(3);
        checkSameUser(user1, users3.get(0));
        checkSameUser(user2, users3.get(1));
        checkSameUser(user3, users3.get(2));
        dao.deleteAll();
        List<User> users0 = dao.getAll();
        assertThat(users0.size()).isEqualTo(0);
    }

    @Test
    public void duplicateKey() {
        assertThrows(DuplicateKeyException.class, () -> {
            dao.deleteAll();
            dao.add(user1);
            dao.add(user1);
        });
    }

    @Autowired
    DataSource dataSource;

    @Test
    public void sqlExceptionTranslate() {
        dao.deleteAll();
        try {
            dao.add(user1);
            dao.add(user1);
        } catch (DuplicateKeyException e) {
            SQLException sqlEx = (SQLException)e.getRootCause();
            SQLExceptionTranslator set =
                    new SQLErrorCodeSQLExceptionTranslator(this.dataSource);
            assertThat(set.translate(null, null, sqlEx)).isInstanceOf(DuplicateKeyException.class);
        }
    }
}