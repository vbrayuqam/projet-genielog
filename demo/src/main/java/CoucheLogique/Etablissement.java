package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public abstract class Etablissement {

    private Coordonnees coords;
    private List<SalleEvaluation> salles = new ArrayList<>();

    public Coordonnees getCoords() {
        return coords;
    }

    public void setCoords(Coordonnees coords) {
        this.coords = coords;
    }

    public List<SalleEvaluation> getSalles() {
        return salles;
    }

    public void setSalles(List<SalleEvaluation> salles) {
        this.salles = salles;
    }

    public void ajouterSalle(SalleEvaluation salle) {
        this.salles.add(salle);
    }

    public String getType() {
        return "aucun";
    }
}
