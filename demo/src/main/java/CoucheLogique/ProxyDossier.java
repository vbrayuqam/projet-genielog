package CoucheLogique;

import net.sf.json.JSONObject;

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

    public JSONObject lireDossier() {
        return dossier.lireDossier();
    }


}
