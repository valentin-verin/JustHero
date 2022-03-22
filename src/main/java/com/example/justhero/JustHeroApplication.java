package com.example.justhero;

import com.example.justhero.Repositories.HeroRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JustHeroApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JustHeroApplication.class, args);
        HeroRepository heroRepository = context.getBean(HeroRepository.class);
        //heroRepository.save(new Hero("Batman", "3465354", "2454674795", "0607060706"));
        //heroRepository.save(new Hero("Spider-Man", "3227894", "798677456", "0703968737"));
        //heroRepository.save(new Hero("Superman", "237656687", "12645765", "0693962°5"));
        //heroRepository.save(new Hero("Thor", "457754", "478808096", "0706395960"));

        //heroRepository.findAll().forEach(p->System.out.println(p.getNom()));
    }

}
