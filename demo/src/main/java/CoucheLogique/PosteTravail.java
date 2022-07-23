package CoucheLogique;

public class PosteTravail {

    private String numeroPoste;
    private ProfMedical examinateur;

    public PosteTravail() {

    }

    public String getNumeroPoste() {
        return numeroPoste;
    }

    public void setNumeroPoste(String numeroPoste) {
        this.numeroPoste = numeroPoste;
    }

    public ProfMedical getExaminateur() {
        return examinateur;
    }

    public void setExaminateur(ProfMedical examinateur) {
        this.examinateur = examinateur;
    }
}
