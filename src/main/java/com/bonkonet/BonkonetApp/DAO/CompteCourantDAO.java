package com.bonkonet.BonkonetApp.DAO;

import com.bonkonet.BonkonetApp.Entity.Client;
import com.bonkonet.BonkonetApp.Entity.CompteCourant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class CompteCourantDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Get a specific compte courant with his ID
     *
     * @param id
     * @return
     */
    public CompteCourant getCompteById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompteCourant> query = cb.createQuery(CompteCourant.class);
        Root<CompteCourant> compteCourant = query.from(CompteCourant.class);
        Predicate idEqual = cb.equal(compteCourant.get("id"), id);
        query.select(compteCourant).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Get a specific compte courant with his numero
     *
     * @param numero
     * @return
     */
    public CompteCourant getCompteByNumero(String numero){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CompteCourant> query = cb.createQuery(CompteCourant.class);
        Root<CompteCourant> compteCourant = query.from(CompteCourant.class);
        Predicate idEqual = cb.equal(compteCourant.get("numero"), numero);
        query.select(compteCourant).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Create compte courant in database
     *
     * @param compteCourant
     */
    public void createCompte(CompteCourant compteCourant){
        entityManager.persist(compteCourant);
    }

    /**
     * Update compte courant in database
     *
     * @param compteCourant
     */
    public void updateCompte(CompteCourant compteCourant){
        entityManager.persist(compteCourant);
    }

    /**
     * Delete compte courant from database
     *
     * @param compteCourant
     */
    public void deleteCompte(CompteCourant compteCourant){
        entityManager.remove(compteCourant);
    }
}
