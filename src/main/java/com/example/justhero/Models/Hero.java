package com.example.justhero.Models;

import antlr.collections.List;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Hero  {

    @Id @GeneratedValue
    private Long id;
    @Size(min = 2, max = 20, message = "Veuillez renseigner un nom correct" )
    private String nom;
    @Size(min = 1, max = 5, message = "Veuillez renseigner une latitude au bon format")
    private String latitude;
    @Size(min = 1, max = 5, message = "Veuillez renseigner une longitude au bon format")
    private String longitude;
    @Size(min = 10, max = 10, message = "Veuillez renseigner un numéro de téléphone au bon format" )
    private String tel;

    @NotEmpty(message = "Veuillez Renseigner au moins un type d'incident")
    @Size(min = 1, max = 3)
    @ManyToMany()
    private java.util.List<Incident> incidents;

    public Hero() {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Hero(String nom, String latitude, String longitude, String tel, java.util.List<Incident> incidents) {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tel = tel;
        this.incidents = incidents;
    }

    public java.util.List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(java.util.List<Incident> incidents) {
        this.incidents = incidents;
    }

}
