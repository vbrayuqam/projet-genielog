package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public class Etablissement {

    private Coordonnees coords;
    private String type;
    private SalleEvaluation[] salles;

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
