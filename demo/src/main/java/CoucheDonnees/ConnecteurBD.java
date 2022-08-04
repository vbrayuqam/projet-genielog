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



}
