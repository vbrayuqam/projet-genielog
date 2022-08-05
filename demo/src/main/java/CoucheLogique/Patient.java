package CoucheLogique;

import java.util.Date;

public class Patient extends Utilisateur {


    private DateSys dateNaissance;
    private String genre;
    private String mere;
    private String pere;
    private String villeNaissance;
    private String nas;
    private Coordonnees coords;

    public Patient(){
        
    }

    public DateSys getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(DateSys dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMere() {
        return mere;
    }

    public void setMere(String mere) {
        this.mere = mere;
    }

    public String getPere() {
        return pere;
    }

    public void setPere(String pere) {
        this.pere = pere;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }

    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        this.nas = nas;
    }

    public Coordonnees getCoords() {
        return coords;
    }

    public void setCoords(Coordonnees coords) {
        this.coords = coords;
    }
}
