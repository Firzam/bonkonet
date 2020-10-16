package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.DAO.CompteCourantDAO;
import com.bonkonet.BonkonetApp.Entity.CompteCourant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompteCourantService {

    private final CompteCourantDAO compteDAO;
    public CompteCourantService(CompteCourantDAO compteDAO){
        this.compteDAO = compteDAO;
    }

    public CompteCourant getCompteById(Integer id){
        return compteDAO.getCompteById(id);
    }

    public CompteCourant getCompteByNumero(String numero){
        return compteDAO.getCompteByNumero(numero);
    }

    @Transactional
    public void createCompte(CompteCourant compteCourant){
        compteDAO.createCompte(compteCourant);
    }

    @Transactional
    public ResponseEntity<Void> updateCompte(CompteCourant compteCourant) {
        CompteCourant courantBase = compteDAO.getCompteById(compteCourant.getId());
        if (courantBase != null){
            updateCompte(courantBase, compteCourant);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteCompteById(Integer id){
        CompteCourant courantBase = compteDAO.getCompteById(id);
        if (courantBase != null){
            deleteCompte(courantBase);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    private void updateCompte(CompteCourant courantBase, CompteCourant compteCourant){
        courantBase.setNumero(compteCourant.getNumero());
        courantBase.setIntitule(compteCourant.getIntitule());
        courantBase.setSolde(compteCourant.getSolde());
        compteDAO.updateCompte(courantBase);
    }

    @Transactional
    private void deleteCompte(CompteCourant compteCourant){
        compteDAO.deleteCompte(compteCourant);
    }
}
