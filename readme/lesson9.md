# ders9:  @OneToMany, @OneToOne, @ManyToOne, @ManyToMany   anotasyonlarının hibernate ile kullanılması


### içerik

- @OneToMany : ShoppingCart - Item ilişkisi

- @OneToOne : Product - ProductDetail ilişkisi

- @ManyToOne : Employee - Department ilişkisi

_ @ManyToMany : Eployee - Meeting ilişkisi


- @OneToMany ineceleme

- Üst CLass taki tanım :
```
@OneToMany(cascade = CascadeType.ALL)
private List<PostComment> comments = new ArrayList<>();
```

- CascadingType (Alt nesnenin nezaman kaydedileceği)
    - PERSIST : üst nesnenin inserti  esnasında alt nesne DB ye kaydedilir.
    - MERGE : Merge esnasında alt nesne DB ye gider.
    - REMOVE : Üst nesne silindiğinde alt nesne de silinir.
    - ALL : Üstteki tümü geçerlidir.


- Alt CLasstaki bir tanımlama yoktur.


---

- Post diye yeni bir menü ekleme
```
<li><a href="${pageContext.request.contextPath}/post">Post</a></li>
```

- Hibernate MySQL dialect'i güncelleme 
```
<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
```


- Mapping'e uygun ekleme yapacak endPoint'i controller'a ekleme 
```
@RequestMapping(value = {"/post-add"}, method = RequestMethod.GET)
```

- Postları ve Commentleri OOP olarak setlemek
```
PostComment comment1 = new PostComment();
comment1.setReview("yess");

PostComment comment2 = new PostComment();
comment2.setReview("Nope");

PostComment comment3 = new PostComment();
comment3.setReview("Hey!");

List<PostComment> comments = new ArrayList<>();
comments.add(comment1);
comments.add(comment2);
comments.add(comment3);

Post post = new Post();
post.setTitle("Yorum");
post.setComments(comments);
```

- Loglardan JOIN li SQL leri inceleme 
```
Hibernate: 
    select
        comments0_.Post_id as Post_id1_3_0_,
        comments0_.comments_id as comments2_3_0_,
        postcommen1_.id as id1_4_1_,
        postcommen1_.review as review2_4_1_ 
    from
        Post_PostComment comments0_ 
    inner join
        PostComment postcommen1_ 
            on comments0_.comments_id=postcommen1_.id 
    where
        comments0_.Post_id=?
```
