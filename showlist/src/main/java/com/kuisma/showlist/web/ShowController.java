package com.kuisma.showlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kuisma.showlist.repository.ShowRepository;

@Controller 
public class ShowController {

    @RequestMapping("/index")
    public String index(Model model) {

        return "frontpage";
    }

    private ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @RequestMapping("/showlist")
    public String shows(Model model) {
        model.addAttribute("shows", showRepository.findAll());
        return "showlist";
    }

}
