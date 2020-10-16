package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.DAO.CompteEpargneDAO;
import com.bonkonet.BonkonetApp.Entity.CompteEpargne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompteEpargneService {

    private final CompteEpargneDAO compteDAO;
    public CompteEpargneService(CompteEpargneDAO compteDAO){
        this.compteDAO = compteDAO;
    }

    public CompteEpargne getCompteById(Integer id){
        return compteDAO.getCompteById(id);
    }

    public CompteEpargne getCompteByNumero(String numero){
        return compteDAO.getCompteByNumero(numero);
    }

    @Transactional
    public void createCompte(CompteEpargne compteEpargne){
        compteDAO.createCompte(compteEpargne);
    }

    @Transactional
    public ResponseEntity<Void> updateCompte(CompteEpargne compteEpargne) {
        CompteEpargne epargneBase = compteDAO.getCompteById(compteEpargne.getId());
        if (epargneBase != null){
            updateCompte(epargneBase, compteEpargne);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteCompteById(Integer id){
        CompteEpargne epargneBase = compteDAO.getCompteById(id);
        if (epargneBase != null){
            deleteCompte(epargneBase);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    private void updateCompte(CompteEpargne epargneBase, CompteEpargne compteEpargne){
        epargneBase.setNumero(compteEpargne.getNumero());
        epargneBase.setIntitule(compteEpargne.getIntitule());
        epargneBase.setSolde(compteEpargne.getSolde());
        epargneBase.setIdClient(compteEpargne.getIdClient());
        compteDAO.updateCompte(epargneBase);
    }

    @Transactional
    private void deleteCompte(CompteEpargne compteEpargne){
        compteDAO.deleteCompte(compteEpargne);
    }
}
