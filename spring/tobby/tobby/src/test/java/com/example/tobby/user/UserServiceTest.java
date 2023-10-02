package com.example.tobby.user;

import com.example.tobby.user.dao.UserDao;
import com.example.tobby.user.domain.Level;
import com.example.tobby.user.domain.User;
import com.example.tobby.user.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.tobby.user.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.example.tobby.user.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/test.xml")
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;
    List<User> users;


    @BeforeEach
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1","a@gmail.com", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2","a@gmail.com",Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3","a@gmail.com", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD - 1),
                new User("madnite1", "이상호", "p4","a@gmail.com", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD),
                new User("green", "오민규", "p5","a@gmail.com", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    void bean() {
        assertThat(this.userService).isNotNull();
    }

    @Test
    @DirtiesContext
    public void upgradeLevels() throws SQLException {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        //DB 테스트 데이터 준비
        userDao.deleteAll();
        for (User user : users) userDao.add(user);

        //메일 발송 여부 확인을 위한 mock obj di
//        MockMailSender mockMailSender = new MockMailSender();
        MailSender mockMailSender = mock(MailSender.class);
        userServiceImpl.setMailSender(mockMailSender);

        //DB 업데이트 여부 확인을 위한 Mock obj di
//        MockUserDao mockUserDao = new MockUserDao();
        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.getAll()).thenReturn(this.users);
        userServiceImpl.setUserDao(mockUserDao);

        //테스트 대상 실행
        userServiceImpl.upgradeLevels();

        //UserDao mock obj를 이용한 결과 확인
//        List<User> updated = mockUserDao.getUpdated();
//        assertThat(updated.size()).isEqualTo(2);
//        checkUserAndLevel(updated.get(0), users.get(1).getId(), users.get(1).getLevel());
//        checkUserAndLevel(updated.get(0), users.get(3).getId(), users.get(3).getLevel());
        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao).update(users.get(1));
        assertThat(users.get(1).getLevel()).isEqualTo(Level.SILVER);
        verify(mockUserDao).update(users.get(3));
        assertThat(users.get(3).getLevel()).isEqualTo(Level.GOLD);


        // DB에 저장된 결과 확인
//        checkLevelUpgraded(users.get(0), false);
//        checkLevelUpgraded(users.get(1), true);
//        checkLevelUpgraded(users.get(2), false);
//        checkLevelUpgraded(users.get(3), true);
//        checkLevelUpgraded(users.get(4), false);

        //MailSender mock obj를 이용한 결과 확인
//        List<String> requests = mockMailSender.getRequests();
//        assertThat(requests.size()).isEqualTo(2);
//        assertThat(requests.get(0)).isEqualTo(users.get(1).getEmail());
//        assertThat(requests.get(1)).isEqualTo(users.get(3).getEmail());
        ArgumentCaptor<SimpleMailMessage> mailMessageArg = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mockMailSender, times(2)).send(mailMessageArg.capture());
        List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
        assertThat(mailMessages.get(0).getTo()[0]).isEqualTo(users.get(1).getEmail());
        assertThat(mailMessages.get(1).getTo()[0]).isEqualTo(users.get(3).getEmail());
    }

    void checkUserAndLevel(User updated, String expectedId, Level expectedLevel) {
        assertThat(updated.getId()).isEqualTo(expectedId);
        assertThat(updated.getLevel()).isEqualTo(expectedLevel);
    }
    static class MockUserDao implements UserDao {
        private List<User> users;//래밸 업그레이드 후보 목록

        public List<User> getUpdated() {
            return updated;
        }

        private List<User> updated = new ArrayList<>();//찐 업그레이드자들 목록
        @Override//mock obj 가능 제공
        public void update(User user) {
            updated.add(user);
        }
        @Override//test stub 기능 제공
        public List<User> getAll() {
            return this.users;
        }
        @Override
        public void add(User user) {
            throw new UnsupportedOperationException();
        }

        @Override
        public User get(String id) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAll() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getCount() {
            throw new UnsupportedOperationException();
        }
    }
    static class MockMailSender implements MailSender {
        private List<String> requests = new ArrayList<String>();

        public List<String> getRequests() {
            return requests;
        }

        @Override
        public void send(SimpleMailMessage mailMessage) throws MailException {
            requests.add(mailMessage.getTo()[0]);
        }

        @Override
        public void send(SimpleMailMessage... simpleMessages) throws MailException {
        }
    }
    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel().nextLevel());
        } else {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel());
        }
    }

    @Test
    public void add() {
        userDao.deleteAll();
        User userWithLevel = users.get(4);     // GOLD 레벨
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);
        userService.add(userWithLevel);
        userService.add(userWithoutLevel);
        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());
        assertThat(userWithLevelRead.getLevel()).isEqualTo(userWithLevel.getLevel());
        assertThat(userWithoutLevelRead.getLevel()).isEqualTo(Level.BASIC);
    }

//    @Autowired
//    DataSource dataSource;

    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    MailSender mailSender;
    @Autowired
    ApplicationContext context;
    @Autowired
    UserService testUserService;
    @Test
    @DirtiesContext
    public void upgradeAllorNothing() throws Exception {
//        TestUserServiceImpl testUserServiceImpl = new TestUserServiceImpl();
//        testUserServiceImpl.setUserDao(this.userDao);
//        testUserServiceImpl.setMailSender(mailSender);

//        UserServiceTx userServiceTx = new UserServiceTx();
//        userServiceTx.setUserService(testUserService);
//        userServiceTx.setTransactionManager(this.transactionManager);
//        TransactionHandler transactionHandler = new TransactionHandler();
//        transactionHandler.setTransactionManager(transactionManager);
//        transactionHandler.setTarget(testUserService);
//        transactionHandler.setPattern("upgrade");
//        UserService txUserService = (UserService) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{UserService.class}, transactionHandler);

//        TxProxyFactoryBean txProxyFactoryBean = context.getBean("&userService", TxProxyFactoryBean.class);
//        ProxyFactoryBean txProxyFactoryBean = context.getBean("&userService", ProxyFactoryBean.class);
//        txProxyFactoryBean.setTarget(testUserServiceImpl);
//        UserService txUserService = (UserService) txProxyFactoryBean.getObject();
        userDao.deleteAll();
        for (User user : users) userDao.add(user);
        try {
//            txUserService.upgradeLevels();
            this.testUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        } catch (TestUserServiceException | SQLException e) {
        }
        checkLevelUpgraded(users.get(1), false);
    }
//
    static class TestUserServiceImpl extends UserServiceImpl {
        private String id="madnite1";

        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) throw new TestUserServiceException();
            super.upgradeLevel(user);
        }
    }

    static class TestUserServiceException extends RuntimeException {
    }

    @Test
    public void advisorAutoProxyCreator() {
        assertThat(testUserService).isInstanceOf(java.lang.reflect.Proxy.class);
    }
}