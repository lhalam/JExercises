package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        return "index";

    }
    //here we are gathering parameters from input 
    //that came from our jsp inputs and are marked like <input ... name=""
    //you rather must mark them like <form:input ... path="your_param_name"
    //also u must provide automatical binding, though u must at first
    //send your model to your page and name params identifically to their 
    //names in class
    //F.E: in class User we have name, though we must write path="name"
    //to binding be involved
    

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String processLogin(@RequestParam("email") String email,
//            @RequestParam("password") String password, ModelMap model) {
//     //   System.out.println(password);
//        model.addAttribute("name",email);
//        return "success";
//    }
    

}