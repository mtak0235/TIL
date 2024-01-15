# Spring?

dependency injection container

# Dependency injection?

## dependency?

DB의 users 테이블에 접근할 수 있게 해주는 DAO(혹은 Repository)를 작성해보자

1. 조회 기능을 만들어보자

```java

import com.mysql.cj.jdbc.MysqlDataSource;

public class UserDao {

    public User findById(Integer id) {
        MysqlDataSource dataSource = new MysqlDataSource(); // (1)
        dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
        dataSource.setUser("tobaby");
        dataSource.setPassword("0000");

        try (Connection connection = dataSource.getConnection()) { // (2)
             PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
             // execute the statement..convert the raw jdbc resultset to a user
             return user;
        }
    }
}
```

💡 UserDao가 sql을 날리려고 DriverManager에 Depend한다.

2. firstName으로 조회하는 기능을 추가해보자

🙄DataSource 를 만드는 코드가 중복되니까 미리 메소드를 빼자

```java
public class UserDao {
    public User findById(Integer id) throws SQLException {
        try (Connection connection = newDataSource().getConnection()) { // (1)
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
            // TODO execute the select , handle exceptions, return the user
        }
    }

    public User findByFirstName(String firstName) throws SQLException {
        try (Connection connection = newDataSource().getConnection()) { // (2)
            PreparedStatement selectStatement = connection.prepareStatement("select * from users where first_name =  ?");
            // TODO execute the select ,  handle exceptions, return the user
        }
    }

    public DataSource newDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource(); // (3)
        dataSource.setUser("tobaby");
        dataSource.setPassword("0000");
        dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
        return dataSource;
    }
}

```

3. ProductDao를 추가해보자

🙄ProductDao도 DataSource를 만드는 코드가 또 필요하겠군. 뿐만 아니라 매 쿼리마다 DataSource를 만들다니 메모리 잡아먹게... DataSource를 따로
싱글톤으로 관리해야겠다. 😎 UserDao에서 DataSource의존 안해도 되네?!

```java
import com.mysql.cj.jdbc.MysqlDataSource;

public enum Application {

    INSTANCE;

    private DataSource dataSource;

    public DataSource dataSource() {
        if (dataSource == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("tobaby");
            dataSource.setPassword("0000");
            dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
            this.dataSource = dataSource;
        }
        return dataSource;
    }
}
```

```java
import com.yourpackage.Application;

public class UserDao {
    public User findById(Integer id) {
        try (Connection connection = Application.INSTANCE.dataSource().getConnection()) { // (1)
               PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
               // TODO execute the select etc.
        }
    }

    public User findByFirstName(String firstName) {
        try (Connection connection = Application.INSTANCE.dataSource().getConnection()) { // (2)
               PreparedStatement selectStatement = connection.prepareStatement("select * from users where first_name =  ?");
               // TODO execute the select etc.
        }
    }
}
```

🤔Dao들은 dataSource 를 어디서 가져와야되는지(Application)를 계속 알고 있어야 하네? Application.INSTANCE.dataSource()로
가져오니까... 🤔종속성이 더 복잡해지면 그 처리하는걸 Application에 다 때려 넣어야 될텐데 ,Application 겁나 뚱뚱해지겠네? 나중에 그것도 찢어발겨야 하는
시점이 오겠지?

## Inversion of Control

😥UserDao: "난 그저 dataSource가 필요할 뿐인데,, 어디서 가져와야할지(`Application.INSTANCE.dataSource()`)모르고 싶어."

😎Inversion of Control: "소원을 들어주지. 대신 넌 dataSource를 언제 어떻게 어디서 가져올지는 관여 못하는거다?"

```java
import javax.sql.DataSource;

public class UserDao {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) { // (1)
        this.dataSource = dataSource;
    }

    public User findById(Integer id) {
        try (Connection connection = dataSource.getConnection()) { // (2)
               PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
               // TODO execute the select etc.
        }
    }

    public User findByFirstName(String firstName) {
        try (Connection connection = dataSource.getConnection()) { // (2)
               PreparedStatement selectStatement = connection.prepareStatement("select * from users where first_name =  ?");
               // TODO execute the select etc.
        }
    }
}
```

😁UserDao: "아싸 Application몰라도 된다~. 날 사용하고 싶으면 dataSource를 달라 caller들아"

😅caller: "아 예;; (dataSource안만들고 개꿀이였는데 까비;;)"

```java
public class MyApplication {

    public static void main(String[] args) {
        //UserService service = new UserService(); 폐기각
        //User user1 = service.findById(1);
        //User user1 = service.findById(2);
        UserDao userDao = new UserDao(Application.INSTANCE.dataSource());
        User user1 = userDao.findById(1);
        User user2 = userDao.findById(2);
        // etc ...
    }
}
```

## Dependency Injection Containers

😅 caller: "UserDao가 DataSource 항상 필요로 해서 제가 넣어는 주고 있는데, 전 할 일이 많다구요.. 누가 UserDao에게 DataSource좀 잘
구성해서 걔한테 주면 안될까요? 제가 꼭 DataSource를 걔한테 넣어 줘야겠어요?"

😎Dependency Injection Container: "날 불렀는가 휴먼"

# Spring Dependency Injection Container

spring의 꽃은✨은 개발자가 작성한 객체의 종속성을 관리하는 aka **종속성 주입 컨테이너**!
우린 그걸 ApplicationContext라 부르지.

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.sql.DataSource;

public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(someConfigClass); // (1)

        UserDao userDao = ctx.getBean(UserDao.class); // (2)
        User user1 = userDao.findById(1);
        User user2 = userDao.findById(2);

        DataSource dataSource = ctx.getBean(DataSource.class); // (3)
        // etc ...
    }
}
```

😎caller : "2.에서 우린 필요한거 다 있는(dataSource까지 갖춘) 완전한 UserDao를 얻을 수 있다. 뿐만 아니라 여차하면 ApplicationContext
형님이 관리중인 DataSource를 직빵으로 받을 수도 있지. 우리가 형님에게 드려야 할 것은 종속 의존 관계를 담은 reference(someConfigClass)야. "

그 레퍼런스 제가 만들어보죠

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApplicationContextConfiguration {  // (1)

    @Bean
    public DataSource dataSource() {  // (2)
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("tobaby");
        dataSource.setPassword("0000");
        dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
        return dataSource;
    }

    @Bean
    public UserDao userDao() { // (3)
        return new UserDao(dataSource());
    }

}
```

spring dependency injection container소개하기 전에 만든 Application에서 의존 관계 처리하던 거랑 비슷한데 얘는 DataSource 싱글톤으로
관리하는 코드 안짜도 되네? @Configuration에 그 코드가 있구나..!

> AnnotationConfigApplicationContext 꼭 써야되나요?
> XML파일이나 annotated Java Configuration Class(?) 같은거 써도 되는데,
> 스프링이 제공하는 annotation 쓰는 Java Class 쓰려면 별 수 있나;;
> XML 파일 쓰는 ApplicationContext 구현체는 `ClassPathXmlApplicationContext`니까 필요하면 대신 쓰던가
>
> @Bean 이 뭐야요.
> MyApplicationContextConfiguration 에 있는 factory method들 (dataSource(), userDao())은 딱 UserDao를 뭘로 만드는지에 대한 정보만 있어. DataSource도 마찬가지고.
> 참고로 저 factory method들이 만든 인스턴스를 Spring beans라고 부른다?
> 😁`@Bean` : 제 아를 Spring bean으로 만들어 주십쇼 행님
>
> Spring bean의 scope는?
> 같은 질문
>
> * 모든 DAO가 같은 DataSource를 공유하나여? (=스프링이 singleton으로 만드나여?)
> * 모든 DAO가 재각기 DataSource를 갖나여? 그니까 DataSource가 필요할 때 마다 새로 만들어 쓰나여?(=스프링이 prototype으로 만드나여?)
> * bean들이 초큼 복잡한 scope를 가져도 되나여? (=HttpRequest당 혹은 HttpSession당 혹은 WebSocket당 새 DataSource가져도 되나여? )  [scope어디까지 되나?](https://docs.spring.io/spring-framework/docs/5.2.x/spring-framework-reference/core.html#beans-factory-scopes)
>
> ➡어노테이션만 붙이면쌉가능
>
> ```java
> import org.springframework.context.annotation.Bean;
> import org.springframework.context.annotation.Scope;
> import org.springframework.context.annotation.Configuration;
> 
> @Configuration
> public class MyApplicationContextConfiguration {
> 
>     @Bean
>     @Scope("singleton")
>     // @Scope("prototype") 
>     //@Scope("session") etc.
>     public DataSource dataSource() {
>         MysqlDataSource dataSource = new MysqlDataSource();
>         dataSource.setUser("tobaby");
>         dataSource.setPassword("0000");
>         dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
>         return dataSource;
>     }
> }
> ```
>
>

쨋든 갓만든 레퍼런스 한번 써보겠습니다.

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        // User user1 = userDao.findById(1);
        // User user2 = userDao.findById(1);
        DataSource dataSource = ctx.getBean(DataSource.class);
    }
}
```

## Spring java config

방금 만든 `MyApplicationContextConfiguration`이 spring java config임.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyApplicationContextConfiguration {

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("tobaby");
        dataSource.setPassword("0000");
        dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
        return dataSource;
    }

    @Bean
    public UserDao userDao() { 
        return new UserDao(dataSource()); //
    }

}
```

🤔아 근데 물론 caller가 `new UserDao(Application.INSTANCE.dataSource())`하던 시절에서
진화해  `new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class).getBean(UserDao.class)`
하게 된 것 까지는 좋았는데,, `MyApplicationContextConfiguration.class`까 보니까 또 dataSource를 직접 집어넣고
있네..(`new UserDao(dataSource())`) 다른 방법 없나?

😎`@ComponentScan`만 있다면 쌉가능

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan  // (1)
public class MyApplicationContextConfiguration {

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("tobaby");
        dataSource.setPassword("0000");
        dataSource.setURL("jdbc:mysql://localhost:3306/tobby");
        return dataSource;
    }
    // (2)
    // no more UserDao @Bean method!
}
```

😎`@ComponentScan` : MyApplicationContextConfiguration가 속한 패키지의 모든 class를 털어서 Spring Bean처럼 보이는(
@Component가 붙은) 게 나오면 싸그리 bean으로 만들갔어.

```java
import javax.sql.DataSource;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    private DataSource dataSource;
    public UserDao(DataSource dataSource) { // (1)
        this.dataSource = dataSource;
    }
}
```

🥺`@Component`: 저를 Spring bean으로 만들어 주십쇼 `@ComponentScan`행님

🤔`@ComponentScan`: `@Component` 자네 필요한 놈이 있나? 내가 관리하는 애들 중에 있으면 꽂아 줄게.

😄`@Component`:  있습니닷! 제가 필요한 객체에 `@Autowired` 붙여 놓겠습니다!
(사실 요즘 스프링에 발전해서 `@Autowired `안붙여도 잘 주입 받음)

```java
import javax.sql.DataSource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserDao {

    private DataSource dataSource;

    public UserDao(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
```

🤔굳이 생성자로 의존성 주입 해야됨?

ㄴㄴ. 바로 때려넣어도 됨 (aka Filed스타일)

```java
import javax.sql.DataSource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserDao {
    @Autowired
    private DataSource dataSource;
}
```

혹은 setter로 때려 박거나 (aka setter 스타일)

```java
import javax.sql.DataSource;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserDao {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
```

# Spring Aspect-Oriented Programming(AOP)

# 스프링의 핵심 기술

a.k.a spring core

* **IOC Container**
* Events
* Resources
* i18n
* validation
* data binding
* type conversion
* SpEL
* **AOP**
* AOT

## IOC Container

implementation of IOC (inversion of control)

### IOC?

* called DI(dependecy injection)
* 객체가 생성되거나, factory method로부터 반환될 때!
  의존하는 객체들을 **다양한 형태**로 주입 받는 것.
    * 생성자의 매개변수로 들어가거나, factory method의 매개변수로 들어가거나, 그 객체의 setter로 주입할 수 있다.





