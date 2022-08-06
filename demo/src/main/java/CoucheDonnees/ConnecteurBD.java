package CoucheDonnees;

import CoucheLogique.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import sqlite3;


public class ConnecteurBD {

     public static Connection connectionBD(){
         Connection conn = null;
         try{
             Class.forName("org.sqlite.JDBC");
             conn = DriverManager.getConnection("jdbc:sqlite:src/bd/BD2.db");
             System.out.println("Connexion reussie");
             return conn;
         }
         catch(Exception e){
             System.out.println("Connexion échouée");
             return null;
         }
     }


// ------------------------------------ PROXY DOSSIER ---------------------------------------------------------

   

// -------------------------------------   DOSSIER  -----------------------------------------------------------


     public Dossier constructionDossier( String assMaladieNum) {

         Dossier dossierPatient = new Dossier();
         dossierPatient.setAntecedents(patientAntecedents(assMaladieNum));
         dossierPatient.setVisites(patientVisites(assMaladieNum));
         dossierPatient.setPatient(patient( assMaladieNum));
         // la date de version est à null pour le moment


         return dossierPatient;
     }

// -------------------------------------  PATIENT  -----------------------------------------------------------

    public Patient patient( String assMaladieNum) {

         Patient lePatient = new Patient();

         lePatient.setNom(patientNom( assMaladieNum));
         lePatient.setPrenom(patientPrenom( assMaladieNum));
         lePatient.setGenre(patientGenre( assMaladieNum));
         lePatient.setCoords(patientCoordonnee( assMaladieNum));
         lePatient.setPere(patientPere( assMaladieNum));
         lePatient.setMere(patientMere( assMaladieNum));
         lePatient.setVilleNaissance( patientVilleNaissance( assMaladieNum));
         lePatient.setDateNaissance( patientDateNaissance( assMaladieNum));
         // villeOrigine est à null et le nas est le string donné en argument de la fonction patient


         return lePatient;

    }



// --------------------------------début des fonctions de lecture de la table médecin ---------------------------------

     public String medecinLoginPass( String medecinId) {

         Connection conn = connectionBD();
         PreparedStatement preRequete = null;
         ResultSet resultat = null;
         String medecinPass = null;

         try {
             String requeteSQL = "SELECT pass_medecin FROM medecin where id_medecin = ?";
             preRequete = conn.prepareStatement(requeteSQL);
             preRequete.setString(1, medecinId);
             resultat = preRequete.executeQuery();
             medecinPass = resultat.getString(1);
         } catch(SQLException e) {
             System.out.println(" medecin login échoué");

         } finally {
             try {
                 resultat.close();
                 preRequete.close();
                 conn.close();
             } catch(SQLException e) {

             }
         }

         return medecinPass;
     }

    public String medecinNom( String medecinId) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String medecinNom = null;

        try {
            String requeteSQL = "SELECT nom FROM medecin where id_medecin = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, medecinId);
            resultat = preRequete.executeQuery();
            medecinNom = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" medecinNom échoué");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return medecinNom;
    }


    public String medecinPrenom( String medecinId) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String medecinPrenom = null;

        try {
            String requeteSQL = "SELECT prenom FROM medecin where id_medecin = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, medecinId);
            resultat = preRequete.executeQuery();
            medecinPrenom = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" medecinPrenom échoué");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return medecinPrenom;
    }

// ------------------------- fin des fonctions de lecture de la table médecin -----------------------------------





// ------------------------- début des fonctions de lecture de la table patient ----------------------------------

    public String patientNom( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientNom = null;

        try {
            String requeteSQL = "SELECT nom FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientNom = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" requete nom du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return patientNom;
    }

    public String patientPrenom( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientPrenom = null;

        try {
            String requeteSQL = "SELECT prenom FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientPrenom = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" requete prenom du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return patientPrenom;
    }

    public DateSys patientDateNaissance( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientDateNaissance = null;
        DateSys dateNaissance = new DateSys();
        int patientDateAnnee;
        int patientDateMois;
        int patientDateJour;


        try {

            String requeteSQL = "SELECT dateNaissance FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientDateNaissance = resultat.getString(1);
            patientDateAnnee = Integer.parseInt(patientDateNaissance.substring(0,4));
            patientDateMois = Integer.parseInt(patientDateNaissance.substring(5,7));
            patientDateJour = Integer.parseInt(patientDateNaissance.substring(8,10));
            dateNaissance.setAnnee(patientDateAnnee);
            dateNaissance.setMois(patientDateMois);
            dateNaissance.setJour(patientDateJour);

        } catch(SQLException e) {
            System.out.println(" requete dateNaissance du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return dateNaissance;
    }

    public String patientGenre( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientGenre = null;

        try {
            String requeteSQL = "SELECT genre FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientGenre = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" requete genre du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return patientGenre;
    }

    public String patientPere( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientPere = null;

        try {
            String requeteSQL = "SELECT pere FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientPere = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" requete pere du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return patientPere;
    }


    public String patientMere( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientMere = null;

        try {
            String requeteSQL = "SELECT mere FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientMere = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" requete mere du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return patientMere;
    }

    public String patientVilleNaissance( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientVilleNaissance = null;

        try {
            String requeteSQL = "SELECT villeNaissance FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientVilleNaissance = resultat.getString(1);
        } catch(SQLException e) {
            System.out.println(" requete villeNaissance du patient échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        return patientVilleNaissance;
    }


// ------------------------ fin des fonctions de lecture de la table patient ------------------------------------




// ------------------------ Lecture des coordonnées d'un patient ------------------------------------------------

    public Coordonnees patientCoordonnee(String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientAdresseResident = null;
        String patientTelephone = null;
        String patientCourriel = null;

        try {
            String requeteSQL = "SELECT * FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientAdresseResident = resultat.getString("adresseResident");
            patientTelephone = resultat.getString("telephone");
            patientCourriel = resultat.getString("courriel");

        } catch(SQLException e) {
            System.out.println(" requete patientCoordonnee échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }

        Coordonnees patientCoordonnee = new Coordonnees();
        patientCoordonnee.setAdresse(patientAdresseResident);
        patientCoordonnee.setTelephone(patientTelephone);
        patientCoordonnee.setCourriel(patientCourriel);



        return patientCoordonnee;
    }

// ------------------------------ fin de la lecture des coordonnées d'un patient --------------------------------






// ------------------------------ début de la lecture des antécédents --------------------------------------------

    public Antecedent[] patientAntecedents(String assMaladieNum) {



        int numAntecedents = numAntecedents(assMaladieNum);


        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;

        Antecedent[] patientAntecedents = new Antecedent[numAntecedents];
        Medecin[] medecin = new Medecin[numAntecedents];
        DateSys[] dateDebutResultat = new DateSys[numAntecedents];
        DateSys[] dateFinResultat = new DateSys[numAntecedents];
        int tabInit = 0;

        String dateDebut = "";
        int dateDebutAnneeParse;
        int dateDebutMoisParse;
        int dateDebutJourParse;

        String dateFin = "";
        int dateFinAnneeParse;
        int dateFinMoisParse;
        int dateFinJourParse;


        try {

            String requeteSQL = "SELECT * FROM antecedents where id_assMaladie = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();

            while(resultat.next()) {

                patientAntecedents[tabInit] = new Antecedent();
                medecin[tabInit] = new Medecin();
                medecin[tabInit].setNom(resultat.getString("medecinTraitantNom"));
                medecin[tabInit].setPrenom(resultat.getString("medecinTraitantPrenom"));

                dateDebut = resultat.getString("debutMaladie");
                dateDebutAnneeParse = Integer.parseInt(dateDebut.substring(0,4));
                dateDebutMoisParse = Integer.parseInt(dateDebut.substring(5,7));
                dateDebutJourParse = Integer.parseInt(dateDebut.substring(8,10));
                dateDebutResultat[tabInit].setAnnee(dateDebutAnneeParse);
                dateDebutResultat[tabInit].setMois(dateDebutMoisParse);
                dateDebutResultat[tabInit].setJour(dateDebutJourParse);

                dateFin = resultat.getString("finMaladie");
                dateFinAnneeParse = Integer.parseInt(dateFin.substring(0,4));
                dateFinMoisParse = Integer.parseInt(dateFin.substring(5,7));
                dateFinJourParse = Integer.parseInt(dateFin.substring(8,10));
                dateFinResultat[tabInit].setAnnee(dateFinAnneeParse);
                dateFinResultat[tabInit].setMois(dateFinMoisParse);
                dateFinResultat[tabInit].setJour(dateFinJourParse);



                patientAntecedents[tabInit].setDiagnostic(resultat.getString("diagnostic"));
                patientAntecedents[tabInit].setTraitement(resultat.getString("traitement"));
                patientAntecedents[tabInit].setMedecin(medecin[tabInit]);
                patientAntecedents[tabInit].setDebut(dateDebutResultat[tabInit]);
                patientAntecedents[tabInit].setFin(dateFinResultat[tabInit]);

                tabInit++;

            }


        } catch(SQLException e) {
            System.out.println(" requete patientAntecedents échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }


        return patientAntecedents;
    }

// -------------------------------------------------------------------------------------------------------------

    public int numAntecedents (String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        int numAntecedents = 0;
        String dummyString = null;


        try {

            String requeteSQL = "SELECT COUNT(*) FROM antecedents where id_assMaladie = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();

            dummyString = resultat.getString(1);
            numAntecedents = Integer.parseInt(dummyString);


            //numAntecedents = resultat.getInt(1);



        } catch(SQLException e) {
            System.out.println(" requete numAntecedents échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }


        return numAntecedents;

    }


// ------------------------------ fin de la lecture des antécédents -----------------------------------------------





// ------------------------------ début de la lecture des visites --------------------------------------------


    public Visite[] patientVisites(String assMaladieNum) {

        int numVisites = numVisites(assMaladieNum);

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;

        Visite[] patientVisites = new Visite[numVisites];
        Medecin[] medecin = new Medecin[numVisites];
        Etablissement[] etablissement = new Etablissement[numVisites];
        DateSys[] dateVisite = new DateSys[numVisites];
        int tabInit = 0;

        String dateVisiteParse = "";
        int dateVisiteAnneeParse;
        int dateVisiteMoisParse;
        int dateVisiteJourParse;


        try {

            String requeteSQL = "SELECT * FROM visites where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();

            while(resultat.next()) {

                patientVisites[tabInit] = new Visite();
                medecin[tabInit] = new Medecin();
                medecin[tabInit].setNom(resultat.getString("medecinVuNom"));
                medecin[tabInit].setPrenom(resultat.getString("medecinVuPrenom"));
                etablissement[tabInit].setNom(resultat.getString("etablissement"));


                dateVisiteParse = resultat.getString("dateVisite");
                dateVisiteAnneeParse = Integer.parseInt(dateVisiteParse.substring(0,4));
                dateVisiteMoisParse = Integer.parseInt(dateVisiteParse.substring(5,7));
                dateVisiteJourParse = Integer.parseInt(dateVisiteParse.substring(8,10));
                dateVisite[tabInit].setAnnee(dateVisiteAnneeParse);
                dateVisite[tabInit].setMois(dateVisiteMoisParse);
                dateVisite[tabInit].setJour(dateVisiteJourParse);


                patientVisites[tabInit].setDiagnostic(resultat.getString("diagnosticEtablit"));
                patientVisites[tabInit].setTraitement(resultat.getString("traitementEtablit"));
                patientVisites[tabInit].setResume(resultat.getString("resumeVisite"));
                patientVisites[tabInit].setNotes(resultat.getString("notesMedecin"));
                patientVisites[tabInit].setMedecin(medecin[tabInit]);
                patientVisites[tabInit].setEtablissement(etablissement[tabInit]);
                patientVisites[tabInit].setDate(dateVisite[tabInit]);


                tabInit++;

            }


        } catch(SQLException e) {
            System.out.println(" requete patientAntecedents échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }


        return patientVisites;
    }

//  --------------------------------------------------------------------------------------------------------------

    public int numVisites (String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        int numVisites = 0;


        try {

            String requeteSQL = "SELECT COUNT(*) FROM visites where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();

            numVisites = resultat.getInt(1);



        } catch(SQLException e) {
            System.out.println(" requete numVisites échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }


        return numVisites;


    }


// ------------------------------ fin de la lecture des visites ---------------------------------------------------







// -------------------------------------- ÉCRITURE -----------------------------------------------------------------



// ------------------------------ début  écriture d'antécédents dans la BD --------------------------------------------
    
    public static void ecritureBDAntecedent (Antecedent unAntecedent, String assMaladieNum){
        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String diagnostic = unAntecedent.getDiagnostic();
        String traitement = unAntecedent.getTraitement();
        String medecinTraitant = unAntecedent.getMedecin().getNom();
        String debutMaladie = String.valueOf(unAntecedent.getDebut());
        String finMaladie = String.valueOf(unAntecedent.getFin());


        try {
            String requeteSQL = "INSERT INTO antecedents(diagnostic, traitement, medecinTraitant, debutMaladie, finMaladie, id_assMaladie) VALUES(?,?,?,?,?,?)";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, diagnostic);
            preRequete.setString(2, traitement);
            preRequete.setString(3, medecinTraitant);
            preRequete.setString(4, debutMaladie);
            preRequete.setString(5, finMaladie);
            preRequete.setString(6, assMaladieNum);
            preRequete.executeUpdate();

        } catch(SQLException e) {
            System.out.println(" requete patientCoordonnee échouée");

        } finally {
            try {
                resultat.close();
                preRequete.close();
                conn.close();
            } catch(SQLException e) {

            }
        }



    }

 // ------------------------------ fin  écriture d'antécédents dans la BD --------------------------------------------




// ------------------------------ début  écriture de visites dans la BD --------------------------------------------
    public static void ecritureBDVisite( Visite nouvelleVisite, String assMaladieNum) {
/*

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String etablissement = nouvelleVisite.getEtablissement()    // etablissement est un string dans la bd (un nom)
                                                                    // et notre implémentation a seulement
                                                                    // des coordonnées et une liste de salles
*/



    }

// ------------------------------ fin  écriture de visites dans la BD --------------------------------------------


}
