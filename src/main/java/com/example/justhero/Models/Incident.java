package com.example.justhero.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Incident {

    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String latitude;
    private String longitude;

    @ManyToMany()
    //@NotEmpty(message = "Veuillez Renseigner un incident")
    //@Size(min = 1, max = 1)
    private java.util.List<Hero> heros;

    public Incident() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public List<Hero> getHeros() {
        return heros;
    }

    public void setHeros(List<Hero> heros) {
        this.heros = heros;
    }

    public Incident(String nom, String latitude, String longitude, List<Hero> heros) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.heros = heros;
    }
}
