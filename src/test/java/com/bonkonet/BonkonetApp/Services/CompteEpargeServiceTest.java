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
import com.bonkonet.BonkonetApp.Entity.Exceptions.NegativeSolde;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CompteEpargeServiceTest {

    CompteEpargneService compteEpargneService;

    @Mock
    CompteEpargneDAO compteEpargneDAO;

    
    CompteEpargne compteEpargeTest = createCompteEpargne(1, "12AEZ32", "Epargne Voyage", 123.00,23.00, 1);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        compteEpargneService = new CompteEpargneService(compteEpargneDAO);
    }

    @Test
    public void shouldSendAcceptedStatus_whenSuccessfullyUpdatingCompte(){
        //Given
        when(compteEpargneDAO.getCompteById(Mockito.any(Integer.class))).thenReturn(compteEpargeTest);

        //When
        ResponseEntity<Void> response = compteEpargneService.updateCompte(compteEpargeTest);

        //Then
        assertEquals(new ResponseEntity<>(HttpStatus.ACCEPTED), response);
    }

    @Test
    public void shouldSendNotAcceptedStatus_whenUnsuccessfullyUpdatingCompte(){
        //Given
        when(compteEpargneDAO.getCompteById(Mockito.any(Integer.class))).thenReturn(null);

        //When
        ResponseEntity<Void> response = compteEpargneService.updateCompte(compteEpargeTest);

        //Then
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE), response);
    }

    @Test
    public void shoudThrowException_WhenDebiterGoNegative() throws NegativeSolde{
        //Given
        Double montant = 250.0;

        //When
        compteEpargeTest = compteEpargneService.debiter(montant, compteEpargeTest, null);       
    }

    @Test
    public void shoudCalculateNewSolde_WhenDebiter() throws NegativeSolde{
        //Given
        Double montant = 250.0;
        compteEpargeTest = createCompteEpargne(1, "12AEZ32", "Epargne Voyage", 251.00,23.00, 1);

        //When
        compteEpargeTest = compteEpargneService.debiter(montant, compteEpargeTest, null);
        
        //Then
        assertEquals(compteEpargeTest.getSolde(), (Double) 1.0);
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
