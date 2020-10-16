package com.bonkonet.BonkonetApp.Controllers;

import com.bonkonet.BonkonetApp.Entity.Compte;
import com.bonkonet.BonkonetApp.Entity.CompteCourant;
import com.bonkonet.BonkonetApp.Services.CompteCourantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compteCourant")
public class CompteCourantController {
    @Autowired
    private CompteCourantService service;

    @GetMapping("/courantById/{id}")
    public CompteCourant getCompteById(@PathVariable("id") Integer id){
        return service.getCompteById(id);
    }

     @GetMapping("/courantByNumero/{numero}")
     public CompteCourant getCompteByNumero(@PathVariable("numero") String numero){
        return service.getCompteByNumero(numero);
     }

    @PostMapping("/createCompte")
    public void createCompte(@RequestBody(required = true) CompteCourant compteCourant){
        service.createCompte(compteCourant);
    }

    @PostMapping("/updateCompte")
    @ResponseBody
    public ResponseEntity<Void> updateCompte(@RequestBody(required = true) CompteCourant compteCourant){
        return service.updateCompte(compteCourant);
    }

    @DeleteMapping("/deleteCompteById/{id}")
    public ResponseEntity<Void> deleteCompteById(@PathVariable("id") Integer id){
        return service.deleteCompteById(id);
    }
}
