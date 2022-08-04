package CoucheDonnees;

import CoucheLogique.Antecedent;
import CoucheLogique.Coordonnees;
import CoucheLogique.Identifiants;
import CoucheLogique.Visite;

import java.sql.*;

//import sqlite3;


public class ConnecteurBD {

     public static Connection connectionBD(){
         Connection conn = null;
         try{
             Class.forName("org.sqlite.JDBC");
             conn = DriverManager.getConnection("jdbc:sqlite:src/bd/BD.db");
             System.out.println("Connexion reussie");
             return conn;
         }
         catch(Exception e){
             System.out.println("Connexion échouée");
             return null;
         }
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
            System.out.println(" medecin login échoué");

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

    public String patientDateNaissance( String assMaladieNum) {

        Connection conn = connectionBD();
        PreparedStatement preRequete = null;
        ResultSet resultat = null;
        String patientDateNaissance = null;

        try {
            String requeteSQL = "SELECT dateNaissance FROM patient where assMaladieNum = ?";
            preRequete = conn.prepareStatement(requeteSQL);
            preRequete.setString(1, assMaladieNum);
            resultat = preRequete.executeQuery();
            patientDateNaissance = resultat.getString(1);
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

        return patientDateNaissance;
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


// ------------------------------ fin de la lecture des antécédents -----------------------------------------------






// ------------------------------ début de la lecture des visites --------------------------------------------


// ------------------------------ fin de la lecture des visites -----------------------------------------------





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
    public static void ecritureBDVisite( Visite nouvelleVisite ) {
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
