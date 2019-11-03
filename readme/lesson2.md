# ders2: MySQL yerine SQLite kullanımı


### içerik
- hibernate versiyonunun SQLite destekli bir sürüme yükseltilmesi
```
<hibernate.version>5.2.12.Final</hibernate.version>
```

- SQLite jdb driver'in POM'a eklenmesi
```
<!-- SQLite JDBC library -->
<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>${sqlite.jdbc.version}</version>
</dependency>
```

- SQLite dialect'in POM'a eklenmesi
```
<!-- sqlite-dialect -->
<dependency>
    <groupId>com.zsoltfabok</groupId>
    <artifactId>sqlite-dialect</artifactId>
    <version>${sqlite.dialect.version}</version>
</dependency>
```


- hibernate.cnfg.xml'in SQLite'a göre configure edilmesi.
```
<!-- SQLITE -->
<property name="hibernate.connection.driver_class">org.sqlite.JDBC</property>
<property name="hibernate.connection.url">
    jdbc:sqlite://Users/leventyildiz/DEVELOPMENT/GIT/BA/spring-hibernate-crud-example/target/badb.db
</property>
<property name="hibernate.connection.username"></property>
<property name="hibernate.connection.password"></property>
<property name="hibernate.dialect">org.hibernate.dialect.SQLiteDialect</property>
```


- Oluşturulan tabloları  SQL browserdan görüntüleme


- insert değerlerini görüntüleme
```
SELECT * FROM PERSON
```

- loglardan insert cümlerlerini görüntüleme
```
Hibernate: insert into Person (name) values (?)
```