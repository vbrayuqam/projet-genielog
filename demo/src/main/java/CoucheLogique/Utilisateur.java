package CoucheLogique;

public abstract class Utilisateur {

    private String nom;
    private String prenom;

    private Identifiants identifiants;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Identifiants getIdentifiants() {
        return identifiants;
    }

    public void setIdentifiants(Identifiants identifiants) {
        this.identifiants = identifiants;
    }
}
