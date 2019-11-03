package com.company.controller;

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
        return mv;
    }

}
