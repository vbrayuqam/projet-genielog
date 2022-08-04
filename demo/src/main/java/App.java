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
        Dossier test = new Dossier();
        Patient pat = new Patient();
        test.setPatient(pat);

        JSONObject js = JSONObject.fromObject(test);

        System.out.println(js.toString());



        // ApplicationMedecin appMed = new ApplicationMedecin();
    }
}

