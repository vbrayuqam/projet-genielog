package CoucheLogique;

import java.util.List;

public abstract class Etablissement {

    private Coordonnees coords;
    private List<SalleEvaluation> salles;

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

    public String getType() {
        return "aucun";
    }
}
