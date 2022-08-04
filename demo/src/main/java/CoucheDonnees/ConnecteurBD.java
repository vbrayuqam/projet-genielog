package CoucheDonnees;

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



// ------------------------- début des fonction de lecture de la table patient ----------------------------------

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
}
