package ru.nna.springcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.nna.springcourse.DAO.personDAO;
import ru.nna.springcourse.model.person;

import javax.validation.Valid;

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
    public String create(@ModelAttribute("person") @Valid person pers, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "people/new";
        }

        personDAO.save(pers);
        return "redirect:/people";
    }
    //метод для изменения имени
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid person person,BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors()){
            return "people/edit";
        }

        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }


}
