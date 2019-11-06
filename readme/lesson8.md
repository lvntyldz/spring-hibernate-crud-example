# ders8: Transient, Embeddable ve Embeded anotasyonlarının hibernate ile kullanılması


### içerik

- Transient olarak işratlenen alan için DB de bir karşılık olmaz(DB de tutulmaz).

- Değişkenin Transient olarak işaretlenmesi
```
@Transient
private boolean newRecord;
```
- Anoyasyonun entity den kaldırılarak incelenmesi.

- Contact adından yeni bir entity oluşturulması.

- Yeni entity'nin hibernate.cnfg.xml'e eklenmesi
```
<mapping class="com.company.domain.Contact"></mapping>
```

- @Embeddable olarak işaretlenen Entityler için yeni tablo oluşturulmaaz.
```
@Embeddable
//@Table(name = "contacts")
public class Contact implements Serializable {
...
```

- @Embeddable Entity'nin alanları @Embedded olarak çağrıldığı tablonun içinde oluşur. 
```
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
    ...
    @Embedded
    private Contact contact;
    ...
```


- Embeddable Objenin oluşturulması ve Main Entity'e setlenmesi
```
Contact contact = new Contact();
contact.setAddress("İstanbul");
contact.setEmail("aa@bb.cc");
contact.setPhone("02121234567");
...
Employee employee = new Employee();
employee.setName(firstName);
employee.setLastName(lastName);
employee.setContact(contact);
```

- Değerlerin DB üzerinden incelenmesi

- UML diagramının gösterilmesi