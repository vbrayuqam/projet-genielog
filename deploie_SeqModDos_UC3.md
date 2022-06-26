# Textes d'introduction 

## Diagramme de déploiement
```
Un diagramme de déploiement est une représentation de la topologie des
composantes physiques d'un système et les liens de communications entre
ces composantes. Elle sert en autre à donner un portrait général du matériel
d'un système que l'on veut représenter. Dans notre cas, nous avons des 
utilisateurs (médecin, patient et personnel de la santé) qui accède au
système par un site web ou une application mobile ou un logiciel de gestion.
Ceux-ci sont connectés à internet et communiquent avec un serveur web qui se 
charge de la communication avec un base de données ayant les informations sur 
les dossiers de patients.
```

## Séquence de modification d'un dossier d'un patient
```
Il s'agit ici de la séquence de modification des coordonnées d'un patient par 
un médecin dans le dossier du patient. Le médecin accède au dossier du patient 
par le logiciel de gestion (par exemple) avec le numéro d'assurance maladie
du patient. Ayant obtenu les informations du dossier, il fait la demande de 
modification des coordonnées dans le dossier du patient. Une instance 
infoPatient est généré par la suite et c'est celui-ci qui se charge
de la création des nouvelles coordonnées. Par la suite, les antécédent et la 
visite sont mise à jour. Une confirmation de la modification est finalement 
acheminé à l'utilisateur.
```

## Cas d'utilisation de la modification d'un dossier d'un patient par un médecin
```
Le diagramme suivant représente le cas d'utilisation d'un médecin dans la
modification d'un dossier d'un patient. Le médecin rentre le numéro du dossier
dans un interface utilisateur (le logiciel de gestion par exemple). Cette
demande est acheminée au système de dossier médical qui relait cette demande à
une base de données qui retourne les informations du dossier au système et le
relait à l'interface utilisateur qui affiche le dossier au médecin. Le médecin
apporte des modifications au dossier à partir de l'interface . Ce changement
est envoyé au système de dossier médical qui relait ce changement à la base de
de données. La base de données confirme la modification du dossier au système
qui l'achemine à l'interface utilisateur. Ce dernier se charge d'afficher cette
confirmation au médecin.

