package CouchePresentation;

import java.awt.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CoucheLogique.SystemeDossier;

public class ApplicationMedecin extends JFrame {

    SystemeDossier sd;
    JSONObject dossier;

    // Elements interface graphique
    JFrame page = new JFrame("Lecture/Modification des dossiers");

    JPanel pAssuranceM = new JPanel();
    JLabel lAssuranceM = new JLabel("Numero d'assurance maladie");
    JTextField assuranceM = new JTextField(15);
    JButton bAssuranceM = new JButton("Rechercher");

    // Elements Dossier
    JPanel affichageDossier = new JPanel();

    JPanel pNom = new JPanel();
    JLabel lNom = new JLabel("Nom");
    JTextField nom = new JTextField(15);

    JPanel pPrenom = new JPanel();
    JLabel lPrenom = new JLabel("Prenom");
    JTextField prenom = new JTextField(15);

    JPanel pDateNaissance = new JPanel();
    JLabel lDateNJaissance = new JLabel("Date de naissance");
    JTextField dateNaissance = new JTextField(15);

    JPanel pGenre = new JPanel();
    JLabel lGenre = new JLabel("Genre");
    JTextField genre = new JTextField(15);

    JPanel pMere = new JPanel();
    JLabel lMere = new JLabel("Mere");
    JTextField mere = new JTextField(15);

    JPanel pPere = new JPanel();
    JLabel lPere = new JLabel("Pere");
    JTextField pere = new JTextField(15);

    JPanel pVilleNaissance = new JPanel();
    JLabel lVilleNJaissance = new JLabel("Ville de naissance");
    JTextField villeNaissance = new JTextField(15);

    JPanel pVisitesAntecedents = new JPanel();
    JButton bVisites = new JButton("Visites");
    JButton bAntecedents = new JButton("Antecedents");

    JPanel pSauvegarde = new JPanel();
    JButton bSauvegarde = new JButton("Sauvegarder");

    public String formatDate(JSONObject dateN) {
        if (dateN.get("annee").equals("") ||
                dateN.getString("mois").equals("") ||
                dateN.get("jour").equals("")) {
            return "";

        } else {
            return dateN.getString("annee")
                    + "-" + String.format("%02d", dateN.getInt("mois")) + "-"
                    + String.format("%02d", dateN.getInt("jour"));
        }
    }

    void lectureDossier(String am) {

        dossier = sd.lireDossier(am);
        nom.setText(dossier.getJSONObject("patient").getString("nom"));
        prenom.setText(dossier.getJSONObject("patient").getString("prenom"));
        JSONObject dateN = dossier.getJSONObject("patient").getJSONObject("dateNaissance");
        dateNaissance.setText(formatDate(dateN));
        genre.setText(dossier.getJSONObject("patient").getString("genre"));
        mere.setText(dossier.getJSONObject("patient").getString("mere"));
        pere.setText(dossier.getJSONObject("patient").getString("pere"));
        villeNaissance.setText(dossier.getJSONObject("patient").getString("villeNaissance"));
        affichageDossier.setVisible(true);

    }

    void modificationVisites(JSONArray visites) {
        dossier.put("visites", visites);
    }

    void modificationAntecedents(JSONArray antecedents) {
        dossier.put("antecedents", antecedents);
    }

    String lireDate(String date){
        if(date.matches("\\d{4}-((0\\d)|(1[0-2]))-(([0-2]\\d)|(3[0-1]))")){
            String[] dates = date.split("-");
            String dateLue = String.format("{\"annee\":\"%s\", \"mois\":\"%s\", \"jour\":\"%s\"}", dates[0],dates[1],dates[2]);
            System.out.println(dateLue);
            return dateLue;
        }
        else{
            dateNaissance.setText("Date invalide. Utiliser YYYY-MM-JJ");
            return "";
        }


    }

    public ApplicationMedecin(SystemeDossier systemeDossier) {

        sd = systemeDossier;

        pAssuranceM.setLayout(new FlowLayout());
        bAssuranceM.addActionListener(e -> {
            String am = assuranceM.getText();
            lectureDossier(am);
        });
        pAssuranceM.add(lAssuranceM);
        pAssuranceM.add(assuranceM);
        pAssuranceM.add(bAssuranceM);

        pNom.setLayout(new FlowLayout());
        pNom.add(lNom);
        pNom.add(nom);

        pPrenom.setLayout(new FlowLayout());
        pPrenom.add(lPrenom);
        pPrenom.add(prenom);

        pDateNaissance.setLayout(new FlowLayout());
        pDateNaissance.add(lDateNJaissance);
        pDateNaissance.add(dateNaissance);

        pGenre.setLayout(new FlowLayout());
        pGenre.add(lGenre);
        pGenre.add(genre);

        pMere.setLayout(new FlowLayout());
        pMere.add(lMere);
        pMere.add(mere);

        pPere.setLayout(new FlowLayout());
        pPere.add(lPere);
        pPere.add(pere);

        pVilleNaissance.setLayout(new FlowLayout());
        pVilleNaissance.add(lVilleNJaissance);
        pVilleNaissance.add(villeNaissance);

        pVisitesAntecedents.setLayout(new FlowLayout());
        bVisites.addActionListener(e -> {
            Visites visites = new Visites(this);
        });
        bAntecedents.addActionListener(e -> {
            Antecedents antecedents = new Antecedents(this);
        });
        pVisitesAntecedents.add(bAntecedents);
        pVisitesAntecedents.add(bVisites);

        pSauvegarde.setLayout(new FlowLayout());
        bSauvegarde.addActionListener(e -> {
            dossier.getJSONObject("patient").put("nom",nom.getText());
            dossier.getJSONObject("patient").put("prenom", prenom.getText());
            dossier.getJSONObject("patient").put("dateNaissance", lireDate(dateNaissance.getText()));
            dossier.put("genre", genre.getText());
            dossier.put("mere", mere.getText());
            dossier.put("pere", pere.getText());
            dossier.put("villeNaissance", villeNaissance.getText());
            sd.modifierDossier(dossier);
        });
        pSauvegarde.add(bSauvegarde);

        affichageDossier.setLayout(new GridLayout(3, 8));
        affichageDossier.add(pNom);
        affichageDossier.add(pPrenom);
        affichageDossier.add(pDateNaissance);
        affichageDossier.add(pGenre);
        affichageDossier.add(pMere);
        affichageDossier.add(pPere);
        affichageDossier.add(pVilleNaissance);
        affichageDossier.add(pVisitesAntecedents);
        affichageDossier.add(pSauvegarde);
        affichageDossier.setVisible(false);

        page.add(pAssuranceM);
        page.add(affichageDossier);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setLayout(new GridLayout(2, 1));
        page.pack();
        page.setVisible(true);

    }
}
