package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public class Etablissement {

    private String nom;
    private Coordonnees coords;
    private String type;
    private SalleEvaluation[] salles;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Coordonnees getCoords() {
        return coords;
    }

    public void setCoords(Coordonnees coords) {
        this.coords = coords;
    }

    public SalleEvaluation[] getSalles() {
        return salles;
    }

    public void setSalles(SalleEvaluation[] salles) {
        this.salles = salles;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return "aucun";
    }
}
