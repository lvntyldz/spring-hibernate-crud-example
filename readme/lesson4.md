# ders1: hibernate query ile select işlemleri


### içerik
- Query api SQL syntax'ına yakın bir **HQL** desteği sunar.

- Class ve değişken isimleriyle sorgu yazabilmemizi sağlar. Bu sayede OOP den kopmamış oluruz.

- SQL injection'ın önlenmesi için paramereleri methodlar aracılığıyla alır.

- query api case sensitive dir. "from Person" != "from person" **(QuerySyntaxException: person is not mapped [from person])**
Peson objesindeki class ve değişken isimlerini parametre olarak alır.

- query list örneği
```
public List<Person> findAll() {
    //return openSession().createQuery("from person").list();
    return openSession().createQuery("from Person").list();
}
```

- find by Id(inline) örneği
```
Query query = openSession().createQuery("from Person where id=1");
```

- set Query Parameters örneği
```
Query query = openSession().createQuery("from Person where id=:id");
query.setParameter("id", id);
```

- loglarda SQL select Query
```
Hibernate: 
    select
        person0_.id as id1_0_,
        person0_.age as age2_0_,
        person0_.lastname as lastname3_0_,
        person0_.firstname as firstnam4_0_,
        person0_.is_student as is_stude5_0_ 
    from
        persons person0_ 
    where
        person0_.id=1
```

- Override Person.toString  
```
@Override
public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", age=" + age +
            ", student=" + student +
            '}';
}
```


- HomeController'dan parametrelerin Model'e eklenmesi
```
mv.addObject("personById", person);
mv.addObject("firstPerson", firstPerson);
mv.addObject("persons", personList);
mv.addObject("lastPerson", lastPerson);
```


- JSP tarafındaki türkçe karakter sorununun oluşmaması için Encoding UTF-8 olarak set edilmeli.
```
<%@ page pageEncoding="UTF-8" %>
```

- jslt ile view katmanında objelere erişme ve ekrana basma
```
<b> Record By Id Record :</b> ${personById}
```


- jsl loop ile verileri ekrana basma
```
<c:forEach items="${persons}" var="p">
    <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.lastName}</td>
        <td>${p.age}</td>
        <td>${p.student}</td>
    </tr>
</c:forEach>
```