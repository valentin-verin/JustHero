package com.example.justhero.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // Page d'accueuil
    @RequestMapping( "/")
    public String Home(Model model) {
        return "home";
    }

}
