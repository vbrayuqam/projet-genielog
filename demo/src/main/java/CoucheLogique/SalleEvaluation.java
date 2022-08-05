package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public class SalleEvaluation {

    private String numeroSalle;
    private List<PosteTravail> postes = new ArrayList<>();

    public SalleEvaluation() {
    }

    public String getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(String numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    public List<PosteTravail> getPostes() {
        return postes;
    }

    public void setPostes(List<PosteTravail> postes) {
        this.postes = postes;
    }

    public void ajouterPoste(PosteTravail poste) {
        postes.add(poste);
    }

    public PosteTravail extrairePoste(int index) {
        return postes.get(index);
    }
}
