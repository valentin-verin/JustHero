package com.example.justhero.Controllers;

import com.example.justhero.Models.Hero;
import com.example.justhero.Models.Incident;
import com.example.justhero.Repositories.HeroRepository;
import com.example.justhero.Repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class IncidentController {

    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private IncidentRepository incidentRepository;


    // Formulaire d'ajout
    @RequestMapping(value = "/incident/form", method = RequestMethod.GET)
    public String form(Model model){
        List<Incident> incidents = incidentRepository.findAll();
        model.addAttribute("incident", new Incident());
        model.addAttribute("incidents",incidents);
        return "incident/form";
    }

    // Validation du formulaire
    @RequestMapping(value = "/incident/save", method = RequestMethod.POST)
    public String save(Model model, @Valid Incident incident, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "incident/form";
        }

        return "incident/map";
    }
}
