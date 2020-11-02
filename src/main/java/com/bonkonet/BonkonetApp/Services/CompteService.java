package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.Entity.Exceptions.NegativeSolde;
import com.bonkonet.BonkonetApp.Entity.Compte;

public abstract class CompteService<T extends Compte> {

    public void debiter(Double montant, T compte) throws NegativeSolde{
        Double solde = compte.getSolde();
        Double nouveauSolde = solde - montant;
        if(nouveauSolde < 0) throw new NegativeSolde();
        else compte.setSolde(nouveauSolde);
    }

    public void crediter(Double montant, T compte){
        Double solde = compte.getSolde();
        Double nouveauSolde = solde + montant;
        compte.setSolde(nouveauSolde);
    }
}