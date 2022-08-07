import CoucheLogique.*;
import CouchePresentation.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;


public class App
{
    public static void main( String[] args )
    {

        SystemeDossier systemeDossier = new SystemeDossier();
        PageConnexion pageConnexion = new PageConnexion(systemeDossier);
    }
}

