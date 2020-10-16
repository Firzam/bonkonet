package com.bonkonet.BonkonetApp.DAO;

import com.bonkonet.BonkonetApp.Entity.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClientDAO{

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * List all clients
     *
     * @return
     */
    public List<Client> showClient() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Client> client = query.from(Client.class);
        query.select(client);
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Get a specific client with his ID
     *
     * @param id
     * @return
     */
    public Client getClientById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Client> client = query.from(Client.class);
        Predicate idEqual = cb.equal(client.get("id"), id);
        query.select(client).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Get a specific client with his identifiant
     *
     * @param identifiant
     * @return
     */
    public Client getClientByIdentifiant(String identifiant){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Client> client = query.from(Client.class);
        Predicate idEqual = cb.equal(client.get("identifiant"), identifiant);
        query.select(client).where(idEqual);
        return entityManager.createQuery(query).getSingleResult();
    }

    /**
     * Create client in database
     *
     * @param client
     */
    public void createClient(Client client){
        entityManager.persist(client);
    }

    /**
     * Update client in database
     *
     * @param client
     */
    public void updateClient(Client client){
        entityManager.persist(client);
    }

    /**
     * Delete client from database
     *
     * @param client
     */
    public void deleteClient(Client client){
        entityManager.delete(client);
    }
    
}