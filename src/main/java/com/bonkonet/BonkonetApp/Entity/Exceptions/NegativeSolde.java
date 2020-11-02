package com.bonkonet.BonkonetApp.Entity.Exceptions;

public class NegativeSolde extends Exception {

    public NegativeSolde(){
        super("Solde Negatif");
    }
}