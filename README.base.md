# base spring project


###içerik
- apache tiles ile layout yapısı.
- bootstrap görüntüsü
- farklı içeriklerde login, home ve about sayfaları
- base package tanımı
```
<context:component-scan base-package="com.company.controller"/>
```

- tiles konfigurasyonu
```
    <!-- Tiles configuration -->
    <bean id="tilesConfigurer"
          class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
        <property name="definitions">
            <list>
                <value>/WEB-INF/tiles/tiles-definitions.xml</value>
            </list>
        </property>
    </bean>
```

- static path tanımları
```
<!--resources access(mapping)-->
<mvc:resources mapping="/static/**" location="/resources/"/>
```

- proje yapısı
<img width="320px"  src="https://github.com/lvntyldz/spring-hibernate-crud-example/blob/base/images/base/projectStructure.png?raw=true" />