package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.DAO.ClientDAO;
import com.bonkonet.BonkonetApp.Entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    
    private final ClientDAO clientDAO;
    public ClientService(ClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }
    public List<Client> showClient() {
        return clientDAO.showClient();
    }
    
}