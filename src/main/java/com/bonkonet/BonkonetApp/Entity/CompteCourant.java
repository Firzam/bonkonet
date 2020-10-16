package com.bonkonet.BonkonetApp.Entity;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class CompteCourant extends Compte {

    private Double montantDecouvertAutorise;

    public Double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(Double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }
}