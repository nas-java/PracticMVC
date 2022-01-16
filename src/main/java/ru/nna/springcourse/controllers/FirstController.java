package ru.nna.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(){
        return "first/hello";
    }

    @GetMapping("/goodbay")
    public String sayGoodbay(){
        return "first/goodbay";
    }
}
