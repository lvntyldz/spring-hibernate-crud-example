# ders7: hibernate sorgu parametrelerinin görüntülenmesi


### içerik

- properties dosyasına hibernate log ayarının eklenmesi
```
log4j.logger.org.hibernate.SQL=debug
log4j.logger.org.hibernate.type=trace
```

- loglarda select parametrelerinin görüntülenmesi
```
Hibernate: 
    select
        employee0_.id as id1_0_,
        employee0_.age as age2_0_,
        employee0_.lastname as lastname3_0_,
        employee0_.firstname as firstnam4_0_ 
    from
        employees employee0_ 
    where
        (
            employee0_.lastname like ?
        ) 
        and (
            employee0_.firstname not like ?
        )
23:38:45,740 TRACE BasicBinder:65 - binding parameter [1] as [VARCHAR] - [%YIL%]
23:38:45,740 TRACE BasicBinder:65 - binding parameter [2] as [VARCHAR] - [%Ali%]
```


- loglarda insert parametrelerinin görüntülenmesi
```
Hibernate: 
    insert 
    into
        employees
        (age, lastname, firstname, id) 
    values
        (?, ?, ?, ?)
23:43:01,884 TRACE BasicBinder:65 - binding parameter [1] as [INTEGER] - [0]
23:43:01,884 TRACE BasicBinder:65 - binding parameter [2] as [VARCHAR] - [YILDIZ]
23:43:01,884 TRACE BasicBinder:65 - binding parameter [3] as [VARCHAR] - [Veli]
23:43:01,884 TRACE BasicBinder:65 - binding parameter [4] as [INTEGER] - [2]
```


- loglarda delete parametrelerinin görüntülenmesi
```
Hibernate: 
    delete 
    from
        employees 
    where
        id=?
23:43:54,789 TRACE BasicBinder:65 - binding parameter [1] as [INTEGER] - [2]
```


---

- Debug ve detaylı log bilgileri için POM'a logback'in eklenmesi
```
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>${logback.version}</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-core</artifactId>
    <version>${logback.version}</version>
</dependency>
```

- Spring loglama için logback.xml'in resources dizinine eklenmesi

- Spring loglamanın logback ile aktif edilmesi
```
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
    <root level="INFO">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>
```