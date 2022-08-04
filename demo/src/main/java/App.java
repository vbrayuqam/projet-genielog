import CoucheDonnees.*;
import CoucheLogique.*;
import CouchePresentation.*;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

public class App
{
    public static void main( String[] args )
    {
        // tests couche logique
        Dossier test = new Dossier();
        Patient pat = new Patient();
        pat.setNas("ayy lmao");
        test.setPatient(pat);
        JSONObject js = JSONObject.fromObject(test);
        System.out.println(js.toString());
        Object bean = JSONObject.toBean(js, Dossier.class);
        Dossier doss = (Dossier) bean;
        System.out.println(doss.getPatient().getNas());

        SystemeDossier systemeDossier = new SystemeDossier();
        PageConnexion pageConnexion = new PageConnexion(systemeDossier);
        ApplicationMedecin appMed = new ApplicationMedecin();

    }
}

