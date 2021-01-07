package com.example.demo.controllers;

import com.example.demo.services.BookJsonModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin
@RestController
public class IndexController {

    BookJsonModule bookJsonModule;

    @Autowired
    public IndexController(BookJsonModule bookJsonModule) {
        this.bookJsonModule = bookJsonModule;
    }

    @RequestMapping(value = "/")
    public ModelAndView defaultHome(){
        bookJsonModule.createDataBase();
        return new ModelAndView("home");
    }

}
