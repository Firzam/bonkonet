package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.Entity.Exceptions.NegativeSolde;
import com.bonkonet.BonkonetApp.Entity.Compte;
import com.bonkonet.BonkonetApp.Entity.CompteCourant;

public abstract class CompteService<T extends Compte> {

    public T debiter(Double montant, T compte, Double decouvert) throws NegativeSolde{
        Double solde = compte.getSolde();
        Double nouveauSolde = solde - montant;
        if(nouveauSolde < 0  || (decouvert != null && nouveauSolde < decouvert)){
            throw new NegativeSolde();
        }else{
            compte.setSolde(nouveauSolde);
        }
        return compte;
    }

    public T crediter(Double montant, T compte){
        Double solde = compte.getSolde();
        Double nouveauSolde = solde + montant;
        compte.setSolde(nouveauSolde);
        return compte;
    }
}