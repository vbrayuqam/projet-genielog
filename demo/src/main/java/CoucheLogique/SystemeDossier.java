package CoucheLogique;


import net.sf.json.JSONObject;


public class SystemeDossier {

    private ProxyDossier dossier;

    public SystemeDossier() {
    }

    public void setDossier(ProxyDossier dossier) {
        this.dossier = dossier;
    }

    public boolean connexion(String utilisateur, String mdp){
        // fetch de la db les identifiants
        // veirifie la validité

        // retourne le résultat
        return (utilisateur.equals("Bob"));
    }

    public JSONObject lireDossier() {
        return dossier.lireDossier();
    }

    public void modifierDossier(JSONObject dossierJSON) {
        Object dossierBean = JSONObject.toBean(dossierJSON, Dossier.class);
        Dossier nouveauDossier = (Dossier) dossierBean;
        ProxyDossier proxy = new ProxyDossier(nouveauDossier);

        this.setDossier(proxy);

        // ajouter les trucs pour modifier la db éventuellement
    }
}
