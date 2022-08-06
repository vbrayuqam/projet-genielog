package CoucheLogique;

import java.util.Date;

public class Antecedent {

    private String diagnostic;
    private String traitement;
    private Medecin medecin;
    private DateSys debut;
    private DateSys fin;

    public Antecedent(){

    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public DateSys getDebut() {
        return debut;
    }

    public void setDebut(DateSys debut) {
        this.debut = debut;
    }

    public DateSys getFin() {
        return fin;
    }

    public void setFin(DateSys fin) {
        this.fin = fin;
    }
}
