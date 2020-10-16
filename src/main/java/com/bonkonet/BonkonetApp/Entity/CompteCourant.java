package com.bonkonet.BonkonetApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="compte_courant")
public class CompteCourant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String numero;

    private String intitule;

    private Double solde;

    @Column(name = "montant_decouvert_autorise")
    private Double montantDecouvertAutorise;

    @JsonIgnore
    @Column(name = "id_client")
    private Integer idClient;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client", insertable = false, updatable = false)
    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(Double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}