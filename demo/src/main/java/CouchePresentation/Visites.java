package CouchePresentation;
import CoucheLogique.Visite;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Visites {

    ApplicationMedecin appMed;

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
    private List<JTextField> resumesTF;
    private List<JTextField> notesTF;

    JPanel affichageVisite(JSONObject visite) {
        JPanel pVisite = new JPanel();
        pVisite.setLayout(new FlowLayout());
        JSONObject med = visite.getJSONObject("medecin");System.out.println(med.toString());

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

        JPanel pDate = new JPanel();
        pDate.setLayout(new BoxLayout(pDate, BoxLayout.Y_AXIS));
        JLabel lDate = new JLabel("Date");
        JTextField date = new JTextField(15);
        date.setText(appMed.formatDate(visite.getJSONObject("date")));
        datesTF.add(date);
        pDate.add(lDate);
        pDate.add(date);

        JPanel pDiagnostic = new JPanel();
        pDiagnostic.setLayout(new BoxLayout(pDiagnostic, BoxLayout.Y_AXIS));
        JLabel lDiagnostic = new JLabel("Diagnostic");
        JTextField diagnostic = new JTextField(15);
        diagnostic.setText(visite.getString("diagnostic"));
        diagnosticsTF.add(diagnostic);
        pDiagnostic.add(lDiagnostic);
        pDiagnostic.add(diagnostic);

        JPanel pTraitement = new JPanel();
        pTraitement.setLayout(new BoxLayout(pTraitement, BoxLayout.Y_AXIS));
        JLabel lTraitement = new JLabel("Traitement");
        JTextField traitement = new JTextField(15);
        traitement.setText(visite.getString("traitement"));
        traitementsTF.add(traitement);
        pTraitement.add(lTraitement);
        pTraitement.add(traitement);

        JPanel pResume = new JPanel();
        pResume.setLayout(new BoxLayout(pResume, BoxLayout.Y_AXIS));
        JLabel lResume = new JLabel("Resume");
        JTextField resume = new JTextField(15);
        resume.setText(visite.getString("resume"));
        resumesTF.add(resume);
        pResume.add(lResume);
        pResume.add(resume);

        JPanel pNotes = new JPanel();
        pNotes.setLayout(new BoxLayout(pNotes, BoxLayout.Y_AXIS));
        JLabel lNotes = new JLabel("Notes");
        JTextField notes = new JTextField(15);
        notes.setText(visite.getString("notes"));
        notesTF.add(notes);
        pNotes.add(lNotes);
        pNotes.add(notes);

        pVisite.add(pMed);
        pVisite.add(pDate);
        pVisite.add(pDiagnostic);
        pVisite.add(pTraitement);
        pVisite.add(pResume);
        pVisite.add(pNotes);
        return pVisite;
    }

    public Visites(ApplicationMedecin applicationMedecin) {
        
        appMed = applicationMedecin;

        page = new JFrame("Visites");
        boutons = new JPanel();
        sauvegarder = new JButton("Sauvegarder");
        ajouter = new JButton("Ajouter");

        nomsTF = new ArrayList<JTextField>();
        prenomsTF = new ArrayList<JTextField>();
        datesTF = new ArrayList<JTextField>();
        diagnosticsTF = new ArrayList<JTextField>();
        traitementsTF = new ArrayList<JTextField>();
        resumesTF = new ArrayList<JTextField>();
        notesTF = new ArrayList<JTextField>();

        JSONArray visites = appMed.patient.getJSONArray("visites");

        sauvegarder.addActionListener(e -> {
            if( visites.size() < nomsTF.size()){
                for(int i = visites.size(); i < nomsTF.size(); i++){
                    visites.add(visites.getJSONObject(0));
                }
            }
            for (int i = 0; i < nomsTF.size(); i++) {
                JSONObject visite = visites.getJSONObject(i);
                JSONObject medecin = visite.getJSONObject("medecin");
                medecin.put("nom", nomsTF.get(i).getText());
                medecin.put("prenom", prenomsTF.get(i).getText());
                visite.put("medecin", medecin);
                visite.put("date", datesTF.get(i).getText());
                visite.put("diagnostic", diagnosticsTF.get(i).getText());
                visite.put("traitement", traitementsTF.get(i).getText());
                visite.put("resume", resumesTF.get(i).getText());
                visite.put("notes", notesTF.get(i).getText());
                visites.set(i, visite);
            }
            appMed.modificationVisites(visites);
        });

        ajouter.addActionListener(e -> {
            JSONObject visite = visites.getJSONObject(0);
            Object temp = JSONObject.toBean(visite, Visite.class);
            Visite temp2 = (Visite)temp;
            JSONObject visiteTemp = JSONObject.fromObject(temp2);
            JSONObject medecin = visiteTemp.getJSONObject("medecin");

            medecin.put("nom", "");
            medecin.put("prenom", "");
            visiteTemp.put("date", "");
            visiteTemp.put("diagnostic", "");
            visiteTemp.put("traitement", "");
            visiteTemp.put("resume", "");
            visiteTemp.put("notes", "");

            page.add(affichageVisite(visiteTemp));
            page.pack();

        });
        boutons.add(sauvegarder);
        boutons.add(ajouter);
        page.add(boutons);



        for (int i = 0; i < visites.size(); i++) {

            JSONObject visite = visites.getJSONObject(i);
            page.add(affichageVisite(visite));

        }


        page.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        page.setLayout(new BoxLayout(page.getContentPane(), BoxLayout.Y_AXIS));
        page.pack();
        page.setVisible(true);
    }
}
