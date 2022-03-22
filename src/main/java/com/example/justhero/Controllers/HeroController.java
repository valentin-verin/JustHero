package com.example.justhero.Controllers;

import com.example.justhero.Models.Incident;
import com.example.justhero.Repositories.HeroRepository;
import com.example.justhero.Models.Hero;
import com.example.justhero.Repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HeroController {
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private IncidentRepository incidentRepository;

    @RequestMapping("/hero/heros")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "nom", defaultValue = "") String nom){
        Page<Hero> pageHeros=heroRepository.rechercher("%"+nom+"%", PageRequest.of(page , size));

        model.addAttribute("listHeros", pageHeros.getContent());
        int[] pages = new int[pageHeros.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("pageCourante", page);
        model.addAttribute("nom", nom);
        return "hero/heros";
    }

    @RequestMapping(value = "/hero/delete" , method = RequestMethod.GET)
    public String delete(Long id, String nom, int page, int size) {
        heroRepository.deleteById(id);
        return "redirect:/hero/heros?page="+page+"&size="+size+"&nom="+nom;
    }

    @RequestMapping(value = "/hero/form", method = RequestMethod.GET)
    public String form(Model model){
        model.addAttribute("hero", new Hero());
        List<Incident> incidents = incidentRepository.findAll();
        model.addAttribute(incidents);
        return "hero/form";
    }

    @RequestMapping(value = "/hero/save", method = RequestMethod.POST)
    public String save(Model model, @Valid Hero hero, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "hero/form";
        heroRepository.save(hero);
        return "hero/AddConfirm";
    }

}
