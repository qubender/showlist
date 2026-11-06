package com.kuisma.showlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuisma.showlist.domain.AppUser;
import com.kuisma.showlist.domain.Category;
import com.kuisma.showlist.domain.Show;
import com.kuisma.showlist.repository.CategoryRepository;
import com.kuisma.showlist.repository.ShowRepository;

import jakarta.validation.Valid;

@Controller
public class ShowController {

    @RequestMapping("/index")
    public String index(Model model) {

        return "frontpage";
    }

    //repojen konstruktorit
    private ShowRepository showRepository;
    private CategoryRepository categoryRepository;

    public ShowController(ShowRepository showRepository, CategoryRepository categoryRepository) {
        this.showRepository = showRepository;
        this.categoryRepository = categoryRepository;
    }
    //lista ohjelmista
    @RequestMapping("/showlist")
    public String shows(Model model) {
        model.addAttribute("shows", showRepository.findAll());
        return "showlist";
    }
    //lisää ohjelma sivu
    @RequestMapping(value = "/addshow", method = RequestMethod.GET)
    public String addShow(Model model) {
        model.addAttribute("shows", new Show());
        model.addAttribute("category", categoryRepository.findAll());
        return "addshow";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveShow(@Valid @ModelAttribute("shows") Show show, BindingResult result) {

        if (result.hasErrors()) {
            return "addshow";
        }

        Long categoryId = show.getCategory().getId();

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow();

        show.setCategory(category);

        showRepository.save(show);
        return "redirect:showlist";
    }
    //sisäänkirjautumissivu
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(Model model) {
        model.addAttribute("appUser", new AppUser());
        return "login";
    }
    //REST, joka tulostaa ohjelmien tiedot
    @RequestMapping(value = "/api/showlist/{id}", method = RequestMethod.GET)
    @ResponseBody 
    public Show findShowRest(@PathVariable("id") Long showId) {
        return showRepository.findById(showId).orElseThrow();
    }
}
