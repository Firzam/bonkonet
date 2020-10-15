@Entity
class Client {
    
    String identifiant;

    String nom;

    String prenom;

    CompteCourant compteCourant;

    CompteEpargne compteEpargne;
}