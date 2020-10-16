package com.bonkonet.BonkonetApp.Entity;

import javax.persistence.*;

@Entity
@Table(name = "compte_epargne")
public class CompteEpargne extends Compte{

    private Double tauxInteret;

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}