package ru.nna.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request){
        String name=request.getParameter("name");
        System.out.println("Привет"+ name);
        return "first/hello";
    }

    @GetMapping("/goodbay")
    public String sayGoodbay(@RequestParam (value = "name",required = false) String name,
                             Model model){
        model.addAttribute("message",name);
        return "first/goodbay";
    }
}
