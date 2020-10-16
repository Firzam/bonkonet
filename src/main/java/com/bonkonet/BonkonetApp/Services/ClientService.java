package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.DAO.ClientDAO;
import com.bonkonet.BonkonetApp.Entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
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

    @Transactional
    public void createClient(Client client){
        clientDAO.createClient(client);
    }

    @Transactional
    public ResponseEntity<Void> updateClient(Client client) {
        Client clientBase = clientDAO.getClientById(client.getId());
        if (clientBase != null){
            updateClient(clientBase, client);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteClientById(Integer id){
        Client clientBase = clientDAO.getClientById(id);
        if (clientBase != null){
            deleteClient(clientBase);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @Transactional
    private void updateClient(Client clientBase, Client client){
        clientBase.setNom(client.getNom());
        clientBase.setPrenom(client.getPrenom());
        clientBase.setCompteCourant(client.getCompteCourant());
        clientBase.setCompteEpargne(client.getCompteEpargne());
        clientDAO.updateClient(clientBase);
    }

    @Transactional
    private void deleteClient(Client client){
        clientDAO.deleteClient(client);
    }
}