# ders3: hibernate temel anotasyonlar


### içerik

- @Table - name: tablo isminin DB deki karşılığı
```
@Table(name = "persons")
```

- @Column(name) - name: kolon isminin DB deki karşılığıdır. 
```
@Column(name = "id")
``` 

- @Column(nullable) - nullable: alanın boş olarak DB ye yazılıp yazılamayacağı. nullable=false iken null değer set edersek **(org.hibernate.PropertyValueException: not-null property)** exception atar. 
```
@Column(name = "firstname", nullable = false)
```

-  @Column(length) - length : alanın DB tarafındaki genişliği(String default 255)
```
  @Column(name = "firstname", nullable = false, length = 25)
```

- Güncel kolon bilgileri
```
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname", nullable = false, length = 25)
    private String name;

    @Column(name = "lastname", nullable = false, length = 25)
    private String lastName;

    @Column(name = "age", nullable = false, length = 6)
    private int age;

    @Column(name = "is_student", nullable = false)
    private boolean student;
```


- Yeni(güncel) tablo yapısı(IDEA->SQL scripts->Source Editor)
```
create table persons
(
  id         integer     not null
    primary key,
  age        integer     not null,
  lastname   varchar(25) not null,
  firstname  varchar(25) not null,
  is_student boolean     not null
);
```
 
- SessionFactory üzerinden Hibernate Session'un açılması
```
sessionFactory.openSession();
```

- Hibernate Session üzerinden  Transaction'ın başlatılması
```
session.beginTransaction();
```

- entity'nin doldurulması
```
Person person = new Person();
person.setName("Ali");
person.setLastName("ALİOĞLU");
person.setAge(20);
person.setStudent(true);
```

- Entity deki değişikliklerin session'a yazılması
```
 session.save(person);
```

- Sessindaki değişikliklerin commitlenerek DB'ye yazılması
```
session.getTransaction().commit();
```

- Hibernate Session'un kapatılması
```
sessionFactory.close();
```