package com.bonkonet.BonkonetApp.Entity;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String identifiant;

    private String nom;

    private String prenom;

    @OneToMany(mappedBy = "client")
    @Nullable
    private List<CompteEpargne> compteEpargne;

    @OneToMany(mappedBy = "client")
    @Nullable
    private List<CompteCourant> compteCourant;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<CompteEpargne> getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(List<CompteEpargne> compteEpargne) {
        this.compteEpargne = compteEpargne;
    }

    public List<CompteCourant> getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(List<CompteCourant> compteCourant) {
        this.compteCourant = compteCourant;
    }
}