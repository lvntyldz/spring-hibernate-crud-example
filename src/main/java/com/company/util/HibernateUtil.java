package com.company.util;

import com.company.domain.Employee;
import com.company.domain.Person;
import com.company.domain.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Person> findAll() {
        //return openSession().createQuery("from person").list();
        return openSession().createQuery("from Person").list();
    }

    public Person findFirst() {
        Query query = openSession().createQuery("from Person where id=1");

        try {
            return (Person) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Person findById(int id) {
        Query query = openSession().createQuery("from Person where id=:id");
        query.setParameter("id", id);

        try {
            return (Person) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession() {
        sessionFactory.close();
    }

    public List<Employee> findAllEmployee() {
        CriteriaQuery<Employee> criteriaQuery = openSession().getCriteriaBuilder().createQuery(Employee.class);
        criteriaQuery.from(Employee.class);

        Query<Employee> query = openSession().createQuery(criteriaQuery);
        List<Employee> result = query.getResultList();

        return result;
    }

    public Employee findEmployeeById(int employeeId) {
        CriteriaBuilder criteriaBuilder = openSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        Predicate likeRestriction = criteriaBuilder.and(
                criteriaBuilder.equal(employeeRoot.get("id"), employeeId)
        );

        criteriaQuery.where(likeRestriction);

        Query<Employee> query = openSession().createQuery(criteriaQuery);
        Employee result = query.uniqueResult();

        return result;

    }

    public List<Employee> findEmployeeBy() {
        CriteriaBuilder criteriaBuilder = openSession().getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        Predicate likeRestriction = criteriaBuilder.and(
                //lastName != lastname
                criteriaBuilder.like(employeeRoot.get("lastName"), "%YIL%"),
                criteriaBuilder.notLike(employeeRoot.get("name"), "%Ali%")
        );

        criteriaQuery.where(likeRestriction);

        Query<Employee> query = openSession().createQuery(criteriaQuery);
        List<Employee> resultList = query.getResultList();

        return resultList;

    }

    public Post findPostById(int id) {
        Query query = openSession().createQuery("from Post where id=:id");
        query.setParameter("id", id);

        try {
            return (Post) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Post> findAllPost() {
        return openSession().createQuery("from Post ").list();
    }
}