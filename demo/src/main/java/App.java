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

        DateSys date = new DateSys();
        date.setJour(4);
        date.setAnnee(2100);
        date.setMois(6);

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
        pat.setDateNaissance(date);

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
        visite.setDate(date);

        Visite visite2 = new Visite();

        Antecedent antecedent = new Antecedent();
        antecedent.setDiagnostic("2 jambes en moins");
        antecedent.setMedecin(medecin);
        antecedent.setTraitement("non");

        Antecedent[] ants = new Antecedent[2];
        ants[0] = antecedent;
        ants[1] = antecedent;

        Visite[] vis = new Visite[4];
        vis[0] = visite;
        vis[1] = visite;
        vis[2] = visite;
        vis[3] = visite2;

        Dossier doss = new Dossier();
        doss.setPatient(pat);
        doss.setVisites(vis);
        doss.setAntecedents(ants);

        ProxyDossier proxy = new ProxyDossier(doss);

        System.out.println(proxy.lireDossier().toString(4));

        SystemeDossier sd = new SystemeDossier();
        sd.setDossier(proxy);


        JSONObject js = proxy.lireDossier();
        JSONArray jsvis = js.getJSONArray("visites");
        System.out.println(jsvis.toString(4));
        JSONObject jstemp = jsvis.getJSONObject(0);
        System.out.println(jstemp.toString(4));
        jstemp.put("notes", "non.jpeg");
        System.out.println(jstemp.toString(4));

        System.out.println(jsvis.toString(4));
        JSONObject js2;


        PageConnexion pageConnexion = new PageConnexion(sd);
    }
}

