# ders5: hibernate ile update ve delete işlemi


### içerik

- Person ile ilgili listeleme işlemlerinin PersonController'a ve person.jsp'ye taşınması

- delete işlemi için view katmanına link eklenmesi 
```
<a class="btn btn-danger" href="${pageContext.request.contextPath}/delete-person/${p.id}">delete</a>
```

- delete işlermleri için Controller'a endPoint eklenmesi
```
@RequestMapping(value = {"/delete-person/{id}"}, method = RequestMethod.GET)
```

- Transaction'ın başlatılması
```
//start transactions
session.beginTransaction();
```


- Silme işleminin uygulanması
```
session.delete(person);
```

- Değişikliklerin DB ye commitlenmesi
```
//commit transaction
session.getTransaction().commit();
```

- Debug ederek adımların gösterilmesi.

- MySQL,SQLite ta ayrı ayrı gösterilmesi.

- Loglardan silme adımını inceleme 
```
Hibernate: 
    delete 
    from
        persons 
    where
        id=?
```

- Silme işleminden sonra DB'deki kayıtları inceleme

---

- Add Person için Jsp'ye link ekleme 
```
<a class="btn btn-success" href="${pageContext.request.contextPath}/person-add/Veli/YILDIZ/25/false">Add New Person</a>
```

- Controller'a addPerson için endPoint ekleme
```
@RequestMapping(value = {"/person-add/{firstName}/{lastName}/{age}/{isStudent}"}, method = RequestMethod.GET)
```

- Controllerdan yakalanan parametrelerin DB'ye kaydedilmesi
```
session.save(person);
```

---

- Update Person için JSP'ye link eklenmesi
```
<a class="btn btn-primary" href="${pageContext.request.contextPath}/person-update/Ahmet/YILDIRIM/20/true/${p.id}">update</a>
```


- Controller'a updatePerson için endPoint ekleme
```
@RequestMapping(value = {"/person-update/{firstName}/{lastName}/{age}/{isStudent}/{id}"}, method = RequestMethod.GET)
```

- Güncel değerlerin Entity'e set edilmesi
```
Person person = hibernateUtil.findById(id);
person.setStudent(isStudent);
person.setName(firstName);
person.setLastName(lastName);
```

- Yeni bilgilerin Db ye yazılması 
```
session.update(person);
```

- Loglardan update cümlesinin incelenmesi
```
Hibernate: 
    update
        persons 
    set
        age=?,
        lastname=?,
        firstname=?,
        is_student=? 
    where
        id=?
```

- proje yapısı

<img width="320px"  src="https://github.com/lvntyldz/spring-hibernate-crud-example/blob/lesson5/images/lesson5/projectStructure.png?raw=true" />
