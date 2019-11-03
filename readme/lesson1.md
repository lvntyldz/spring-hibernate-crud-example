# ders1: hibernate entegrasyonu


### içerik
- hibernate JAR'ın POM'a eklenmesi
```
<!--Hibernate -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>${hibernate.version}</version>
</dependency>
```

- mysql JAR'ın POM'a eklenmesi

```
<!-- connect to mysql -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql.connector.version}</version>
</dependency>
```

- hibernate.cfg.xml dosyasının projeye eklenmesi
    - Driver, URL, Username, Password ve Dialect girilmesi
    - show_sql parametresi
    - hbm2ddl.auto [validate, update, create-drop]

```
<hibernate-configuration>

    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost/ba</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">1234567890</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="show_sql">true</property>
        <!--<property name="hbm2ddl.auto">validate</property>-->
        <!--<property name="hbm2ddl.auto">update</property>-->
        <property name="hbm2ddl.auto">create-drop</property>

        <mapping class="com.company.domain.Person"></mapping>
    </session-factory>

</hibernate-configuration>
```

- log4j.properties dosyasının projeye eklenmesi ve INFO level loglama
```
# Log all JDBC parameters
#log4j.logger.org.hibernate.type=ERROR
log4j.logger.org.hibernate=INFO
#log4j.logger.org.hibernate=DEBUG
```



- ilk entity'nin oluşturulması
```
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    //getters and setters..
}
```

- HibernateUtil ile sessionFactory oluşturma
```
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static void closeSession() {
        getSession().close();
    }
```

- proje yapısı

<img width="320px"  src="https://github.com/lvntyldz/spring-hibernate-crud-example/blob/lesson1/images/lesson1/projectStructure.png?raw=true" />
