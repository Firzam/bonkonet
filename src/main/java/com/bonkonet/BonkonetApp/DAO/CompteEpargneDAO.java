package com.bonkonet.BonkonetApp.DAO;

import com.bonkonet.BonkonetApp.Entity.CompteEpargne;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class CompteEpargneDAO {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get a specific compte epargne with his ID
     *
     * @param id
     * @return
     */
    public CompteEpargne getCompteById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompteEpargne> query = cb.createQuery(CompteEpargne.class);
        Root<CompteEpargne> compteEpargne = query.from(CompteEpargne.class);
        Predicate idEqual = cb.equal(compteEpargne.get("id"), id);
        query.select(compteEpargne).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Get a specific compte epargne with his numero
     *
     * @param numero
     * @return
     */
    public CompteEpargne getCompteByNumero(String numero){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompteEpargne> query = cb.createQuery(CompteEpargne.class);
        Root<CompteEpargne> compteEpargne = query.from(CompteEpargne.class);
        Predicate idEqual = cb.equal(compteEpargne.get("numero"), numero);
        query.select(compteEpargne).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Create compte epargne in database
     *
     * @param compteEpargne
     */
    public void createCompte(CompteEpargne compteEpargne){
        entityManager.persist(compteEpargne);
    }

    /**
     * Update compte epargne in database
     *
     * @param compteEpargne
     */
    public void updateCompte(CompteEpargne compteEpargne){
        entityManager.persist(compteEpargne);
    }

    /**
     * Delete compte epargne from database
     *
     * @param compteEpargne
     */
    public void deleteCompte(CompteEpargne compteEpargne){
        entityManager.remove(compteEpargne);
    }
}
