package com.bonkonet.BonkonetApp.DAO;

import com.bonkonet.BonkonetApp.Entity.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClientDAO{

    @PersistenceContext
    private EntityManager entityManager;
    public List<Client> showClient() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Client> client = query.from(Client.class);
        query.select(client);
        return entityManager.createQuery(query).getResultList();
    }
    
}