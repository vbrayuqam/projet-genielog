package CoucheLogique;

public class ProxyDossier {

    private Dossier dossier;

    public ProxyDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }
}
