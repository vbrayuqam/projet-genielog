package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public class SalleEvaluation {

    private String numeroSalle;
    private List<PosteTravail> postes;

    SalleEvaluation() {
        this.postes = new ArrayList<>();
    }

    public String getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }
}
