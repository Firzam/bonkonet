package com.bonkonet.BonkonetApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="compte_courant")
public class CompteCourant extends Compte{

    @Column(name = "montant_decouvert_autorise")
    private Double montantDecouvertAutorise;

    public Double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(Double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }
}