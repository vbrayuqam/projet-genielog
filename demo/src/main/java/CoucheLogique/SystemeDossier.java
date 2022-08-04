package CoucheLogique;


import net.sf.json.JSONObject;


public class SystemeDossier {

    private ProxyDossier dossier;

    public SystemeDossier() {
    }

    public boolean connexion(String usr, String pwd){
        return (usr.equals("Bob"));
    }

    public void setDossier(ProxyDossier dossier) {
        this.dossier = dossier;
    }

    public JSONObject lireDossier() {
        JSONObject dossierJSON = JSONObject.fromObject(dossier.getDossier());
        return dossierJSON;
    }

    public void modifierDossier(JSONObject dossierJSON) {
        Object dossierBean = JSONObject.toBean(dossierJSON, Dossier.class);
        Dossier nouveauDossier = (Dossier) dossierBean;
        ProxyDossier proxy = new ProxyDossier(nouveauDossier);

        this.setDossier(proxy);

        // ajouter les trucs pour modifier la db éventuellement
    }
}
