package com.bonkonet.BonkonetApp.Services;

public class CompteService<T> {

    public void debiter(Double montant, T compte) throws NegativeSolde{
        Double solde = compte.getSolde();
        Double nouveauSolde = solde - montant;
        if(nouveauSolde < 0) throw new NegativeSolde;
        else compte.setSolde(nouveauSolde);
    }

    public void crediter(Double montant, T compte){
        Double solde = compte.getSolde();
        Double nouveauSolde = solde + montant;
        compte.setSolde(nouveauSolder);
    }
}