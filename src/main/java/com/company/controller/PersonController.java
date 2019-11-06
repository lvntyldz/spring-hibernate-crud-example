package com.company.controller;

import com.company.domain.Person;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping(value = {"/person"}, method = RequestMethod.GET)
    public ModelAndView person() {
        ModelAndView mv = new ModelAndView("person");

        HibernateUtil hibernateUtil = new HibernateUtil();
        List<Person> personList = hibernateUtil.findAll();

        Person person = hibernateUtil.findById(2);
        mv.addObject("personById", person);

        Person firstPerson = hibernateUtil.findFirst();
        mv.addObject("firstPerson", firstPerson);

        Person lastPerson = null;

        if (personList.size() > 0) {
            int last = personList.size() - 1;
            lastPerson = personList.get(last);
        }

        mv.addObject("persons", personList);
        mv.addObject("lastPerson", lastPerson);

        return mv;
    }

    @RequestMapping(value = {"/delete-person/{id}"}, method = RequestMethod.GET)
    public String personDelete(HttpServletRequest request, @PathVariable int id) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        Person person = hibernateUtil.findById(id);

        if (person == null) {
            return "person";
        }

        //start transactions
        session.beginTransaction();

        session.delete(person);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }


    @RequestMapping(value = {"/person-add/{firstName}/{lastName}/{age}/{isStudent}"}, method = RequestMethod.GET)
    public String personAdd(HttpServletRequest request,
                            @PathVariable String firstName,
                            @PathVariable String lastName,
                            @PathVariable int age,
                            @PathVariable boolean isStudent) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        //start transactions
        session.beginTransaction();

        Person person = new Person();
        person.setStudent(isStudent);
        person.setName(firstName);
        person.setLastName(lastName);

        session.save(person);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = {"/person-update/{firstName}/{lastName}/{age}/{isStudent}/{id}"}, method = RequestMethod.GET)
    public String personUpdate(HttpServletRequest request,
                               @PathVariable String firstName,
                               @PathVariable String lastName,
                               @PathVariable int age,
                               @PathVariable boolean isStudent,
                               @PathVariable int id) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        //start transactions
        session.beginTransaction();

        Person person = hibernateUtil.findById(id);
        person.setStudent(isStudent);
        person.setName(firstName);
        person.setLastName(lastName);

        session.update(person);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
