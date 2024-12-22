package com.meryem;

import java.time.LocalDate;

public class Person {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String adresse;

    public Person(String nom, String prenom, LocalDate dateNaissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int calculerAge() {
        return LocalDate.now().getYear() - dateNaissance.getYear();
    }
}
