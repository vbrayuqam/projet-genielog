package CoucheDonnees;

import java.sql.*;

//import sqlite3;


public class ConnecteurBD {
    
     Connection conn = null;

     public static Connection ConnectionDB(){

         try{
             Class.forName("org.sqlite.JDBC");
             Connection conn = DriverManager.getConnection("jdbc:sqlite:src/bd/BD.db");
             System.out.println("Connexion reussie");
             return conn;
         }
         catch(Exception e){
             System.out.println("Connexion échouée");
             return null;
         }
     }



}
