import CoucheLogique.*;
import CouchePresentation.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class App
{
    public static void main( String[] args )
    {
        // dossier dummy
        Coordonnees coords = new Coordonnees();
        coords.setAdresse("164 rue des tests");
        coords.setCourriel("no@thanks.pls");
        coords.setTelephone("420-666-1337");

        Coordonnees coords2 = new Coordonnees();
        coords.setAdresse("534 rue des tests");
        coords.setCourriel("yes@thanks.pls");
        coords.setTelephone("234-345-0000");

        Coordonnees coords3 = new Coordonnees();
        coords.setAdresse("345 rue des tests");
        coords.setCourriel("pat@thanks.pls");
        coords.setTelephone("111-345-0230");

        Identifiants id = new Identifiants();
        id.setMotDePasse("pass1");
        id.setNomUtilisateur("user1");

        Patient pat = new Patient();
        pat.setNas("123-123-1234");
        pat.setCoords(coords3);
        pat.setMere("Gerard Burger");
        pat.setPere("Nancy Burger");
        pat.setGenre("Medium Saignant");
        pat.setNom("Burger");
        pat.setPrenom("Bob");
        pat.setIdentifiants(id);

        Medecin medecin = new Medecin();
        medecin.setIdentifiants(id);
        medecin.setNom("Charest");
        medecin.setPrenom("Jean");

        PosteTravail poste = new PosteTravail();
        poste.setNumeroPoste("2");
        poste.setExaminateur(medecin);
        PosteTravail[] postes = new PosteTravail[1];
        postes[0] = poste;

        SalleEvaluation salle = new SalleEvaluation();
        salle.setNumeroSalle("1");
        salle.setPostes(postes);
        SalleEvaluation[] salles = new SalleEvaluation[1];
        salles[0] = salle;

        Etablissement hopital = new Etablissement();
        hopital.setCoords(coords);
        hopital.setSalles(salles);
        hopital.setType("hopital");
        hopital.setNom("test123");

        Etablissement clinique = new Etablissement();
        clinique.setCoords(coords2);
        clinique.setSalles(salles);
        clinique.setType("clinique");
        clinique.setNom("test123");

        Visite visite = new Visite();
        visite.setDiagnostic("une jambe en moins");
        visite.setMedecin(medecin);
        visite.setTraitement("une fausse jambe");
        visite.setNotes("aucunes");
        visite.setEtablissement(hopital);
        visite.setNotes("ouin.jpeg");

        Antecedent antecedent = new Antecedent();
        antecedent.setDiagnostic("2 jambes en moins");
        antecedent.setMedecin(medecin);
        antecedent.setTraitement("non");

        Antecedent[] ants = new Antecedent[2];
        ants[0] = antecedent;
        ants[1] = antecedent;

        Visite[] vis = new Visite[3];
        vis[0] = visite;
        vis[1] = visite;
        vis[2] = visite;

        Dossier doss = new Dossier();
        doss.setPatient(pat);
        doss.setVisites(vis);
        doss.setAntecedents(ants);

        ProxyDossier proxy = new ProxyDossier(doss);

        SystemeDossier sd = new SystemeDossier();
        sd.setDossier(proxy);
    

        // La methode pour acceder au JSON dummy est lireDossier, invoqué sur proxy, j'ai pas set les dates encore


        SystemeDossier systemeDossier = new SystemeDossier();
        PageConnexion pageConnexion = new PageConnexion(systemeDossier);
    }
}

