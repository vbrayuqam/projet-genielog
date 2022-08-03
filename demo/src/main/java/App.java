import CoucheDonnees.*;
import CoucheLogique.*;
import CouchePresentation.*;

public class App 
{
    public static void main( String[] args )
    {
        SystemeDossier systemeDossier = new SystemeDossier();
        PageConnexion pageConnexion = new PageConnexion(systemeDossier);
        ApplicationMedecin appMed = new ApplicationMedecin();
    }
}
