package com.epam.lab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Пример взят с
 * https://hellokoding.com/spring-mvc-4-hello-world-example-with-xml-configuration-maven-and-thymeleaf/
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET)
    public String table(Model model) {
        ArrayList<Map<String, Object>> list = new ArrayList();
        //list.add();
        model.addAttribute("list", list);
        return "table";
    }

}