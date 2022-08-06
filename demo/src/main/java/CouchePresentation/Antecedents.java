package CouchePresentation;
import CoucheLogique.Antecedent;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Antecedents {

    // Elements interface graphique
    JFrame page;
    JPanel boutons;
    JButton sauvegarder;
    JButton ajouter;


    private List<JTextField> nomsTF;
    private List<JTextField> prenomsTF;
    private List<JTextField> datesTF;
    private List<JTextField> diagnosticsTF;
    private List<JTextField> traitementsTF;
    private List<JTextField> debutsTF;
    private List<JTextField> finTF;

    JPanel affichageAntecedent(JSONObject antecedent) {
        JPanel pAntecedent = new JPanel();
        pAntecedent.setLayout(new FlowLayout());
        JSONObject med = antecedent.getJSONObject("medecin");

        JPanel pMed = new JPanel();
        pMed.setLayout(new BoxLayout(pMed, BoxLayout.Y_AXIS));
        JLabel lMed = new JLabel("Medecin");

        JPanel pNomMed = new JPanel();
        JLabel lNomMed = new JLabel("Nom: ");
        JTextField nomMed = new JTextField(15);
        nomMed.setText(med.getString("nom"));
        nomsTF.add(nomMed);
        pNomMed.add(lNomMed);
        pNomMed.add(nomMed);

        JPanel pPrenomMed = new JPanel();
        JLabel lPrenomMed = new JLabel("Prenom: ");
        JTextField prenomMed = new JTextField(15);
        prenomMed.setText(med.getString("prenom"));
        prenomsTF.add(prenomMed);
        pPrenomMed.add(lPrenomMed);
        pPrenomMed.add(prenomMed);

        pMed.add(lMed);
        pMed.add(pNomMed);
        pMed.add(pPrenomMed);

        JPanel pDiagnostic = new JPanel();
        pDiagnostic.setLayout(new BoxLayout(pDiagnostic, BoxLayout.Y_AXIS));
        JLabel lDiagnostic = new JLabel("Diagnostic");
        JTextField diagnostic = new JTextField(15);
        diagnostic.setText(antecedent.getString("diagnostic"));
        diagnosticsTF.add(diagnostic);
        pDiagnostic.add(lDiagnostic);
        pDiagnostic.add(diagnostic);

        JPanel pTraitement = new JPanel();
        pTraitement.setLayout(new BoxLayout(pTraitement, BoxLayout.Y_AXIS));
        JLabel lTraitement = new JLabel("Traitement");
        JTextField traitement = new JTextField(15);
        traitement.setText(antecedent.getString("traitement"));
        traitementsTF.add(traitement);
        pTraitement.add(lTraitement);
        pTraitement.add(traitement);

        JPanel pDebut = new JPanel();
        pDebut.setLayout(new BoxLayout(pDebut, BoxLayout.Y_AXIS));
        JLabel lDebut = new JLabel("Debut");
        JTextField debut = new JTextField(15);
        debut.setText(antecedent.getString("debut"));
        debutsTF.add(debut);
        pDebut.add(lDebut);
        pDebut.add(debut);

        JPanel pFin = new JPanel();
        pFin.setLayout(new BoxLayout(pFin, BoxLayout.Y_AXIS));
        JLabel lFin = new JLabel("Fin");
        JTextField fin = new JTextField(15);
        fin.setText(antecedent.getString("fin"));
        finTF.add(fin);
        pFin.add(lFin);
        pFin.add(fin);

        pAntecedent.add(pMed);
        pAntecedent.add(pDiagnostic);
        pAntecedent.add(pTraitement);
        pAntecedent.add(pDebut);
        pAntecedent.add(pFin);
        return pAntecedent;
    }

    public Antecedents(ApplicationMedecin appMed) {

        page = new JFrame("Antecedents");
        boutons = new JPanel();
        sauvegarder = new JButton("Sauvegarder");
        ajouter = new JButton("Ajouter");


        nomsTF = new ArrayList<JTextField>();
        prenomsTF = new ArrayList<JTextField>();
        datesTF = new ArrayList<JTextField>();
        diagnosticsTF = new ArrayList<JTextField>();
        traitementsTF = new ArrayList<JTextField>();
        debutsTF = new ArrayList<JTextField>();
        finTF = new ArrayList<JTextField>();

        JSONArray antecedents = appMed.patient.getJSONArray("antecedents");

        sauvegarder.addActionListener(e -> {
            if( antecedents.size() < nomsTF.size()){
                for(int i = antecedents.size(); i < nomsTF.size(); i++){
                    antecedents.add(antecedents.getJSONObject(0));
                }
            }
            for (int i = 0; i < nomsTF.size(); i++) {
                JSONObject antecedent = antecedents.getJSONObject(i);
                JSONObject medecin = antecedent.getJSONObject("medecin");
                medecin.put("nom", nomsTF.get(i).getText());
                medecin.put("prenom", prenomsTF.get(i).getText());
                antecedent.put("medecin", medecin);
                antecedent.put("diagnostic", diagnosticsTF.get(i).getText());
                antecedent.put("traitement", traitementsTF.get(i).getText());
                antecedent.put("debut", debutsTF.get(i).getText());
                antecedent.put("fin", finTF.get(i).getText());
                antecedents.set(i, antecedent);
            }
            appMed.modificationAntecedents(antecedents);
        });

        ajouter.addActionListener(e -> {
            JSONObject antecedent = antecedents.getJSONObject(0);
            Object temp = JSONObject.toBean(antecedent, Antecedent.class);
            Antecedent temp2 = (Antecedent)temp;
            JSONObject antecedentTemp = JSONObject.fromObject(temp2);
            JSONObject medecin = antecedentTemp.getJSONObject("medecin");
            medecin.put("nom", "");
            medecin.put("prenom", "");
            antecedentTemp.put("diagnostic", "");
            antecedentTemp.put("traitement", "");
            antecedentTemp.put("debut", "");
            antecedentTemp.put("fin", "");

            page.add(affichageAntecedent(antecedentTemp));
            page.pack();

        });
        boutons.add(sauvegarder);
        boutons.add(ajouter);
        page.add(boutons);



        for (int i = 0; i < antecedents.size(); i++) {

            JSONObject antecedent = antecedents.getJSONObject(i);
            page.add(affichageAntecedent(antecedent));

        }


        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setLayout(new BoxLayout(page.getContentPane(), BoxLayout.Y_AXIS));
        page.pack();
        page.setVisible(true);
    }
}
