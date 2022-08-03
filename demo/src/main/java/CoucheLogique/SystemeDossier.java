package CoucheLogique;

import java.util.ArrayList;
import java.util.List;

public class SystemeDossier {

    private List<ProxyDossier> dossiers;

    public SystemeDossier() {
        this.dossiers = new ArrayList<ProxyDossier>();
    }

    public boolean connexion(String usr, String pwd){
        return (usr == "Bob");

    }


}
