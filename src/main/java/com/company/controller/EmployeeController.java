package com.company.controller;

import com.company.domain.Employee;
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
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping(value = {"/employee"}, method = RequestMethod.GET)
    public ModelAndView employee() {
        ModelAndView mv = new ModelAndView("employee");

        HibernateUtil hibernateUtil = new HibernateUtil();
        List<Employee> employeeList = hibernateUtil.findAllEmployee();

        Employee employee = hibernateUtil.findEmployeeById(2);
        mv.addObject("employeeById", employee);

        Employee firstEmployee = hibernateUtil.findEmployeeById(1);
        mv.addObject("firstEmployee", firstEmployee);

        Employee lastEmployee = null;

        if (employeeList.size() > 0) {
            int last = employeeList.size() - 1;
            lastEmployee = employeeList.get(last);
        }

        List<Employee> likeEmployees = hibernateUtil.findEmployeeBy();

        mv.addObject("likeEmployees", likeEmployees);

        mv.addObject("employees", employeeList);

        mv.addObject("lastEmployee", lastEmployee);

        return mv;
    }

    @RequestMapping(value = {"/delete-employee/{id}"}, method = RequestMethod.GET)
    public String employeeDelete(HttpServletRequest request, @PathVariable int id) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        Employee employee = hibernateUtil.findEmployeeById(id);

        if (employee == null) {
            return "employee";
        }

        //start transactions
        session.beginTransaction();

        session.delete(employee);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = {"/employee-add/{firstName}/{lastName}/{age}"}, method = RequestMethod.GET)
    public String employeeAdd(HttpServletRequest request,
                              @PathVariable String firstName,
                              @PathVariable String lastName,
                              @PathVariable int age) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        //start transactions
        session.beginTransaction();

        Employee employee = new Employee();
        employee.setName(firstName);
        employee.setLastName(lastName);

        session.save(employee);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = {"/employee-update/{firstName}/{lastName}/{age}/{id}"}, method = RequestMethod.GET)
    public String employeeUpdate(HttpServletRequest request,
                                 @PathVariable String firstName,
                                 @PathVariable String lastName,
                                 @PathVariable int age,
                                 @PathVariable int id) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        //create session
        Session session = hibernateUtil.openSession();

        //start transactions
        session.beginTransaction();

        Employee employee = hibernateUtil.findEmployeeById(id);
        employee.setName(firstName);
        employee.setLastName(lastName);

        session.update(employee);

        //commit transaction
        session.getTransaction().commit();

        //close session
        session.close();

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
