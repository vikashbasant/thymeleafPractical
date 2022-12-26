package com.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model){
        System.out.println("Inside about handler!...");

        // putting data in model:
        // dynamic send the data:
        model.addAttribute("name","Viaksh Basant");
        model.addAttribute("currentDate", new Date().toLocaleString());
        return "about";
        // about.html
    }


    // this is for handling iteration:
    @GetMapping(value = "/example-loop")
    public String iterateHandler(Model model){
        // send data to model: that is collections:
        // create a list, set collection:
        List<String> names = Arrays.asList("Vikash", "Prince", "Neha", "Amrit");

        model.addAttribute("names", names);

        return "iterate";
    }


    // handler for conditional statements:
    @GetMapping(value="/condition")
    public String conditionHandler(Model m){
        System.out.println("Conditional handler executed..");

        m.addAttribute("isActive", false);

        m.addAttribute("gender", "F");

        // Here creating list using java 8 features:
        List<Integer> numbers = Arrays.asList(12);

        m.addAttribute("myList", numbers);
        return "condition";
    }


    // handler for including fragments:
    @GetMapping("/service")
    public String servicesHandler(Model m){
        // processing logic:
        m.addAttribute("title", "About learn code with Vikash Basant!");
        m.addAttribute("subtitle", LocalDateTime.now().toString());
        return "service";
    }


    // for new about
    @GetMapping("/newabout")
    public String newAbout(){
        return "aboutnew";
    }

    // for contact
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
