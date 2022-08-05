package CoucheLogique;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dossier {
    
    private List<Antecedent> antecedents;
    private List<Visite> visites;
    private Patient patient;
    private Date date;

    public Dossier(){

    }

    public List<Antecedent> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(List<Antecedent> antecedents) {
        this.antecedents = antecedents;
    }

    public List<Visite> getVisites() {
        return visites;
    }

    public void setVisites(List<Visite> visites) {
        this.visites = visites;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public JSONObject lireDossier() {
        return JSONObject.fromObject(this);
    }
}
