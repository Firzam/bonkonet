package com.bonkonet.BonkonetApp.Services;

import com.bonkonet.BonkonetApp.DAO.CompteEpargneDAO;
import com.bonkonet.BonkonetApp.Entity.CompteEpargne;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CompteEpargeServiceTest {

    CompteEpargneService compteEpargneService;

    @Mock
    CompteEpargneDAO compteEpargneDAO;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        compteEpargneService = new CompteEpargneService(compteEpargneDAO);
    }

    @Test
    public void shouldSendAcceptedStatus_whenSuccessfullyUpdatingCompte(){
        //Given
        CompteEpargne compteEpargeTest = createCompteEpargne(1, "12AEZ32", "Epargne Voyage", 123.00,23.00, 1);
        when(compteEpargneDAO.getCompteById(Mockito.any(Integer.class))).thenReturn(compteEpargeTest);

        //When
        ResponseEntity<Void> response = compteEpargneService.updateCompte(compteEpargeTest);

        //Then
        assertEquals(new ResponseEntity<>(HttpStatus.ACCEPTED), response);
    }

    private CompteEpargne createCompteEpargne(Integer id, String numero, String intitule, Double solde, Double tauxInteret, Integer idClient){
        CompteEpargne ce = new CompteEpargne();
        ce.setId(id);
        ce.setNumero(numero);
        ce.setIntitule(intitule);
        ce.setSolde(solde);
        ce.setTauxInteret(tauxInteret);
        ce.setIdClient(idClient);
        return ce;
    }
}
