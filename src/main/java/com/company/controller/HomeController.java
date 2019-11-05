package com.company.controller;

import com.company.domain.Person;
import com.company.util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");

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

}
