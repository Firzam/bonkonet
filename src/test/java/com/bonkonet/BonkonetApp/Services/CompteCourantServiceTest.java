package com.bonkonet.BonkonetApp.Services;
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
import com.bonkonet.BonkonetApp.Entity.CompteCourant;
import com.bonkonet.BonkonetApp.DAO.CompteCourantDAO;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CompteCourantServiceTest {

    CompteCourantService compteCourantService;

    @Mock
    CompteCourantDAO compteCourantDAO;

    
    CompteCourant compteCourantTest = createCompteCourant(1, "12AEZ32", "Epargne Voyage", 50.0,50.0, 1);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        compteCourantService = new CompteCourantService(compteCourantDAO);
    }

    @Test
    public void shouldSendAcceptedStatus_whenSuccessfullyUpdatingCompte(){
        //Given
        when(compteCourantDAO.getCompteById(Mockito.any(Integer.class))).thenReturn(compteCourantTest);

        //When
        ResponseEntity<Void> response = compteCourantService.updateCompte(compteCourantTest);

        //Then
        assertEquals(new ResponseEntity<>(HttpStatus.ACCEPTED), response);
    }

    @Test
    public void shouldSendNotAcceptedStatus_whenUnsuccessfullyUpdatingCompte(){
        //Given
        when(compteCourantDAO.getCompteById(Mockito.any(Integer.class))).thenReturn(null);

        //When
        ResponseEntity<Void> response = compteCourantService.updateCompte(compteCourantTest);

        //Then
        assertEquals(new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE), response);
    }

    @Test
    public void shoudThrowException_WhenDebiterGoNegative() throws NegativeSolde{
        //Given
        Double montant = 250.0;

        //When
        compteCourantTest = compteCourantService.debiter(montant, compteCourantTest, null);       
    }

    @Test
    public void shoudCalculateNewSolde_WhenDebiter() throws NegativeSolde{
        //Given
        Double montant = 2000000.0;
        compteCourantTest = createCompteCourant(1, "12AEZ32", "Epargne Voyage", 251.00,23.00, 1);

        //When
        compteCourantTest = compteCourantService.debiter(montant, compteCourantTest, null);
        
        //Then
        assertEquals(compteCourantTest.getSolde(), (Double) 1.0);
    }

    private CompteCourant createCompteCourant(Integer id, String numero, String intitule, Double solde, Double montantDecouvertAutorise, Integer idClient){
        CompteCourant cc = new CompteCourant();
        cc.setId(id);
        cc.setNumero(numero);
        cc.setIntitule(intitule);
        cc.setSolde(solde);
        cc.setMontantDecouvertAutorise(montantDecouvertAutorise);
        cc.setIdClient(idClient);
        return cc;
    }
}   
