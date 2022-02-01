package ru.nna.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nna.springcourse.DAO.personDAO;

@Controller
@RequestMapping("/people")
public class peopleController {

    private final personDAO personDAO;

    public peopleController(personDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable ("id") int id, Model model){
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }
}
