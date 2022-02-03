package ru.nna.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nna.springcourse.DAO.personDAO;
import ru.nna.springcourse.model.person;

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

    @GetMapping("/new")
    public String newPeople(Model model){
        model.addAttribute("person", new person());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") person pers){
        personDAO.save(pers);
        return "redirect:/people";
    }
}
