package com.bonkonet.BonkonetApp.DAO;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClientDAO{

    @PersistenceContext
    private EntityManager entityManager;
    
}