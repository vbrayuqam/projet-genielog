package CoucheLogique;


import CoucheDonnees.ConnecteurBD;
import net.sf.json.JSONObject;


public class SystemeDossier {

    private ProxyDossier dossier;

    public SystemeDossier() {
    }

    public void setDossier(ProxyDossier dossier) {
        this.dossier = dossier;
    }

    public boolean connexion(String utilisateur, String mdp){
        boolean valide = false;
        ConnecteurBD bd  = new ConnecteurBD();
        String pass = bd.medecinLoginPass(utilisateur);

        if(mdp.equals(pass)) {
            valide = true;
        }

        return valide;
    }

    public JSONObject lireDossier(String assMaladieNum) {
        ConnecteurBD bd = new ConnecteurBD();
        Dossier dossier = bd.constructionDossier(assMaladieNum);
        ProxyDossier proxy = new ProxyDossier(dossier);
        this.setDossier(proxy);
        return proxy.lireDossier();
    }

    public void modifierDossier(JSONObject dossierJSON) {
        Object dossierBean = JSONObject.toBean(dossierJSON, Dossier.class);
        Dossier nouveauDossier = (Dossier) dossierBean;
        ProxyDossier proxy = new ProxyDossier(nouveauDossier);
        this.setDossier(proxy);
        ConnecteurBD bd = new ConnecteurBD();
        bd.insererDossier(proxy.getDossier());
    }
}
