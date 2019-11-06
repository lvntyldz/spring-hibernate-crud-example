# ders56: hibernate ile criteria kullanımı


### içerik
- Select işlemlerinin HQL yerine Criteria ile yapılması

- Employe entitysinin oluşturulması
```
@Entity
@Table(name = "employees")
public class Employee implements Serializable {

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
    ...
```

- Employee için yeri ekran oluşturma  ve Menüye ekleme 
```
<li><a href="${pageContext.request.contextPath}/employee">Employee</a></li>
```


- Employe  için Controller tarafında geliştirme 
```
@RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
```
 
- Entity'nin hibernate.cnfg.xml üzerinden Map edilmesi
```
<mapping class="com.company.domain.Employee"></mapping>
```


- Tüm listeyi çekecek Criteria nın oluşturulması 
```
criteriaQuery.from(Employee.class);
```
```
public List<Employee> findAllEmployee() {
    CriteriaQuery<Employee> criteriaQuery = openSession().getCriteriaBuilder().createQuery(Employee.class);
    criteriaQuery.from(Employee.class);

    Query<Employee> query = openSession().createQuery(criteriaQuery);
    List<Employee> result = query.getResultList();

    return result;
}
```

- **CriteriaQuery**'e where clasue'ın  **Predicate** ile  eklenmesi
```
Predicate likeRestriction = criteriaBuilder.and(
        criteriaBuilder.equal(employeeRoot.get("id"), employeeId)
);
criteriaQuery.where(likeRestriction);
```

- Criteriada root.get() parametresi query de olduğu gibi değişken isimleridir.

- Like sorgularının OOP olarak oluşturulması.
```
Predicate likeRestriction = criteriaBuilder.and(
        //lastName != lastname
        criteriaBuilder.like(employeeRoot.get("lastName"), "%YIL%"),
        criteriaBuilder.notLike(employeeRoot.get("name"), "%Ali%")
);
```


- Kayıtların like ile aranıp Model'e eklenmesi 
```
List<Employee> likeEmployees = hibernateUtil.findEmployeeBy();
mv.addObject("likeEmployees", likeEmployees);
```


- Like ile bulunan sonuçların JSP tarafında loop ile ekrana basılması
```
<c:forEach items="${likeEmployees}" var="employe">
    <tr>
        <td>${employe.id}</td>
        <td>${employe.name}</td>
        <td>${employe.lastName}</td>
        <td>${employe.age}</td>
        <td>
            <a class="btn btn-danger"
               href="${pageContext.request.contextPath}/delete-employee/${employe.id}">delete</a>
        </td>
        <td>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/employee-update/Ahmet/YILDIRIM/20/true/${employe.id}">update</a>
        </td>
    </tr>
</c:forEach>
```
 
- proje yapısı

<img width="320px"  src="https://github.com/lvntyldz/spring-hibernate-crud-example/blob/lesson6/images/lesson6/projectStructure.png?raw=true" />
