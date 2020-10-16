package com.bonkonet.BonkonetApp.Controllers;

import com.bonkonet.BonkonetApp.Entity.Client;
import com.bonkonet.BonkonetApp.Services.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping()
    public List<Client> showClient () {
        return service.showClient();
    }

    @PostMapping("/createClient")
    public void createClient(@RequestBody(required = true) Client client){
        service.createClient(client);
    }

    @PostMapping("/updateClient")
    @ResponseBody
    public ResponseEntity<Void> updateClient(@RequestBody(required = true) Client client){
        return service.updateClient(client);
    }

    @DeleteMapping("/deleteClientById/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("id") Integer id){
        return service.deleteClientById(id);
    }
    
}