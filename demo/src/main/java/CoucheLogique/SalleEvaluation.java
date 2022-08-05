package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public class SalleEvaluation {

    private String numeroSalle;
    private PosteTravail[] postes;

    public SalleEvaluation() {
    }

    public String getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public PosteTravail[] getPostes() {
        return postes;
    }

    public void setPostes(PosteTravail[] postes) {
        this.postes = postes;
    }
}
