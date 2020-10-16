package com.bonkonet.BonkonetApp.Controllers;

import com.bonkonet.BonkonetApp.Entity.CompteEpargne;
import com.bonkonet.BonkonetApp.Services.CompteEpargneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compteEpargne")
public class CompteEpargneController {
    @Autowired
    private CompteEpargneService service;

    @GetMapping("/epargneById/{id}")
    public CompteEpargne getCompteById(@PathVariable("id") Integer id){
        return service.getCompteById(id);
    }

    @GetMapping("/epargneByNumero/{numero}")
    public CompteEpargne getCompteByNumero(@PathVariable("numero") String numero){
        return service.getCompteByNumero(numero);
    }

    @PostMapping("/createCompte")
    public void createCompte(@RequestBody(required = true) CompteEpargne compteEpargne){
        service.createCompte(compteEpargne);
    }

    @PostMapping("/updateCompte")
    @ResponseBody
    public ResponseEntity<Void> updateCompte(@RequestBody(required = true) CompteEpargne compteEpargne){
        return service.updateCompte(compteEpargne);
    }

    @DeleteMapping("/deleteCompteById/{id}")
    public ResponseEntity<Void> deleteCompteById(@PathVariable("id") Integer id){
        return service.deleteCompteById(id);
    }
}
