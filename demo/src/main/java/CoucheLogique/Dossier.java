package CoucheLogique;


import net.sf.json.JSONObject;
import java.util.Date;


public class Dossier {
    
    private Antecedent[] antecedents;
    private Visite[] visites;
    private Patient patient;
    private DateSys date;

    public Dossier(){
    }

    public Antecedent[] getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(Antecedent[] antecedents) {
        this.antecedents = antecedents;
    }

    public Visite[] getVisites() {
        return visites;
    }

    public void setVisites(Visite[] visites) {
        this.visites = visites;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public DateSys getDate() {
        return date;
    }

    public void setDate(DateSys date) {
        this.date = date;
    }

    public JSONObject lireDossier() {
        return JSONObject.fromObject(this);
    }
}
