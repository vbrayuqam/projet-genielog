# Page de présentation

  

### Rapport 1

Remis dans le cadre du cours INF5153

  

# Table des matières

1. [Diagramme(s) de cas d'utilisation](#cas)

2. [Diagramme(s) de classe](#classe)

3. [Diagramme(s) de séquence](#sequence)

4. [Diagramme(s) de package](#package)

5. [Diagramme(s) de composants](#comp)

6. [Diagramme(s) de déploiement](#dep)

6. [Justificaitons GRASP](#grasp)

  

# Contenu

  

## Diagramme(s) de cas d'utilisation <a name="cas"></a>

![Diagramme de cas d'utilisation](/diagrammes/CAS.png  "Diagramme de cas d'utilisation")

  
  

![Diagramme de cas d'utilisation détaillé 1](/diagrammes/CU1.png  "Diagramme de cas d'utilisation détaillé 1")

  
  

![Diagramme de cas d'utilisation détaillé 2](/diagrammes/CU2.png  "Diagramme de cas d'utilisation détaillé 2")

  
  

![Diagramme de cas d'utilisation détaillé 3](/diagrammes/CU3.png  "Diagramme de cas d'utilisation détaillé 3")

  
  

## Diagramme(s) de classe <a name="classe"></a>

  

### Explications

Nous étions un peu confus sur quoi modélisé exactement dû à note manque d'expérience, nous avons donc décidéde modélise la logique d'affaire interne du programme (couche logique). Nous avons commencé par constater que nous avons besoin du classe utilisateur, ainsi les différentes classes d'utilisateur vont hérité de celle-ci et implémenter leurs comportements distincts. Le concept largement manipulé par le système nous semblait être un dossier, nous l'avons donc représenté par une classe. Un dossier, à notre sens, est constituer d'une liste de visites, d'une liste d'antécédent ainsi que des informations d'un patient. Chacun de ces concepts à donc été représenter sous forme de classes qui constituent un dossier. Nous avons aussi modélisé le concept de coordonées et d'établissement sous forme de classe. Car ceux-ci implique plusieurs informations distinctes. Les établissements (ainsi que les patients) auront donc des coordonnées. Les visites eux, auront un établissement.
  

### Diagramme

![Diagramme de classe](/diagrammes/CLASSE.png  "Diagramme de classe")
 
  

## Diagramme(s) de séquence <a name="sequence"></a>

### Sequence pour la lecture d'un dossier

L'utilisateur va appeler sa methode lireDossier avec un numero de dossier en parametre. Le Dossier en question va transformer toutes les informations qu'il contient en structure texte et retourner le tout pour que celui-ci puisse etre affiche

### Diagramme

![Diagramme de séquence LIRE](/diagrammes/SEQLIRE.png  "Diagramme de séquence LIRE")

### Séquence de modification d'un dossier d'un patient

Il s'agit ici de la séquence de modification du dossier d'un patient par
un médecin dans le dossier du patient. Le médecin accède au dossier du patient par le logiciel de gestion (par exemple) avec le numéro d'assurance maladie du patient. Ayant obtenu les informations du dossier, il fait la demande de modification du dossier dans le dossier du patient. La classe Dossier genere une nouvelle instance pour le patient avec les nouvelles informations. Elle, ensuite, cree des instances d'antecedents, visites et coordonnees ainsi qu'infoPatient pour le nouveau dossier. Une confirmation de la modification est finalement acheminé à l'utilisateur.

### Diagramme

![Diagramme de séquence MOD](/diagrammes/SEQMOD.png  "Diagramme de séquence MOD")

### Sequence de modification des coordonnees


Il s'agit ici de la séquence de modification des coordonnees d'un patient par celui-ci. Le patient accède au dossier a travers le site web avec son numéro d'assurance maladie du patient. Ayant obtenu les informations du dossier, il fait la demande de modification des coordonnées dans le dossier du patient. Une instance infoPatient est généré par la suite et c'est celui-ci qui se charge de la création des nouvelles coordonnées. Par la suite, les antécédent et la visite sont mise à jour. Une confirmation de la modification est finalement acheminé à l'utilisateur.
 
 ### Diagramme

![Diagramme de séquence COORD](/diagrammes/SEQCOORD.png  "Diagramme de séquence COORD")


## Diagramme(s) de package <a name="package"></a>
 

### Explications
  

Nous avons décidé de couper notre programme en plusieurs couche. Chacune de ces couches sera encapsulé dans son propre package. Ceci nous permets de réutilisé/réusiné une couche pour l'utilisé dans une autre conception plus tard. Nous avons deux couches de présentation, une pour le coté web et une pour le coté mobile. Chacunes d'elles encapsule un modèle MVC. La logique d'affaire du programe se trouve dans la couche logique. Dans la couche données nous avons mit la classe qui servira de connecteur à la base de données du système.


### Diagramme

![Diagramme de package](/diagrammes/PACK.png  "Diagramme de package")

  
  

## Diagramme(s) de composants <a name="comp"></a>

### Explications

La carte d'assurance-maladie permet, a travers l'application medecin, d'acceder et de le lire ou y faire des modifications, tout dependant des privileges de l'utilisateur. Le site web permet au patient d'acceder a une partie du dossier et en modifier les coordonnees

### Diagramme

![Diagramme de composants](/diagrammes/COMP.png  "Diagramme de composants")

   

## Diagramme de déploiement <a name="dep"></a>

### Explications

Un diagramme de déploiement est une représentation de la topologie des composantes physiques d'un système et les liens de communications entre ces composantes. Elle sert en autre à donner un portrait général du matériel d'un système que l'on veut représenter. Dans notre cas, nous avons des utilisateurs (médecin, patient et personnel de la santé) qui accède au système par un site web ou une application mobile ou un logiciel de gestion. Ceux-ci sont connectés à internet et communiquent avec un serveur web qui se charge de la communication avec un base de données ayant les informations sur les dossiers de patients.

### Diagramme

![Diagramme de déploiement](/diagrammes/DEP.png  "Diagramme de déploiement")


## Justifications GRASP <a name="grasp"></a>

  

### Patron Contrôleur

  

Dans nos couches de présentation nous utilisons le patron de contrôleur dans le cadre d'un modèle MVC (Modèle/Vue/Contrôleur). Le contrôlleur propre à chacune des couches coordonne les messages externes sans se coupler au objet internes.

  

### Patron Polymorphisme

  

Nos sous-classes de la classe abstraire Utilisateur utilise le patron de polymorphisme. Nous pouvons ainsi leur donner des comportements différent lorsque la même fonction est appelée sur les classes ainsi que dans les divers contextes d'utilisation.

  

### Patron Spécialiste de l'information

  

Pour les classes Établissement, Coordonnées, infoPatient, Visite et Antécédent nous utilisons le patron de spécialiste de l'information. Toute ces classes représente des concept distinct qui contiennent plusieurs données internes. Ces données sont donc encapsuler dans ces classes et elles peuvent poser des actions envers celles-ci (les données) car ce sont elles (les classes) qui les connaissent.

  

### Patron Créateur

  

Pour la majorité des classes qui contiennemt des objets issue d'autre classes (aggrégations, références), nous utilisons le patron de créateur. La classe contenant les objets est donc responsable de les créer. Un bon exemple de ceci serait notre classe Dossier, qui construit les objets de type Antécédent, Visite et InfoPatient.

  

### Patron Forte cohésion

  

Nous utilisons le patron forte cohésion dans notre conception. Ainsi plusieurs de nos classes peuvent être utilisées a des fins que nous n'avons pas prévus. Par exemple, la classe coordonnées peut être utilisé pour représenter des coordonnées autres que celle d'établissements ou de patients.
