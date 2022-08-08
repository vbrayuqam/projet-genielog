# Utilisation générale du programme

## Base de données
En ce moment, la BD  *BD2.db* est déjà présente dans le fichier *demo/src/bd/* ainsi que le script *BD2.sql*.
La connection avec la BD se fait par la fonction *connectionBD* dans la classe *ConnecteurBD* de la couche 
de données.
Pour supprimer la BD *BD2.db*, il suffit de se rendre dans le fichier *demo/src/bd/ et de lancer la commande :
```
rm BD2.db
```
Pour recréer la BD *BD2.db*, il suffit de se rendre dans le fichier *demo/src/bd/* et de lancer la commande :
```
sqlit3 BD2.db
```
Par la suite, il faut lancer dans *sqlite3* la commande suivante :
```
.read ./BD2.sql
.quit
```
Ainsi, on obtient la BD *BD2.db*


## Compilation
Pour compiler le programme, se rendre à la racine du projet (le dossier demo) et lancer cette commande :

``` 
mvn package
``` 

## Exécution
Pour exécuter le programme, se rendre à la racine du projet (le dossier demo) et lancer cette commande :
``` 
mvn exec:java

``` 

## Utilisation
Pour le login,     
utilisateur : login123    
pass : pass123    
ou    
utilisateur : pleine    
pass: lune    

Pour le numéro d'assurance maladie,    
TREM01038503     
ou     
FLEM01048602     
ou     
HUBA01058701     

Les dates doivent respecter le format *AAAA-MM-JJ*