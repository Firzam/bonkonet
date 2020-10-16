package com.bonkonet.BonkonetApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="compte_epargne")
public class CompteEpargne extends Compte{

    @Column(name = "taux_interet")
    private Double tauxInteret;

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

}