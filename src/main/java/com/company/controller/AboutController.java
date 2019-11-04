package com.company.controller;

import com.company.domain.Person;
import com.company.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

    private static final Logger logger = LoggerFactory.getLogger(AboutController.class);

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("about");

        //create session
        Session session = HibernateUtil.openSession();

        //start transactions
        session.beginTransaction();

        Person person = new Person();
        person.setName("Ali");
        person.setLastName("ALİOĞLU");
        person.setAge(20);
        person.setStudent(true);

        session.save(person);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        return mv;
    }

}
