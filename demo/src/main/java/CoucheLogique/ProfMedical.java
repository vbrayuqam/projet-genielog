package CoucheLogique;

public class ProfMedical extends Utilisateur {

    private String type;

    public ProfMedical() {
        this.type = "profesionnel médical";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
