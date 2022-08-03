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



}
