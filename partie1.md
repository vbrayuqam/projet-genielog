# Page de présentation

### Rapport 1
Remis dans le cadre du cours INM5153

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
![Diagramme de cas d'utilisation](/diagrammes/CAS.png "Diagramme de cas d'utilisation")


![Diagramme de cas d'utilisation détaillé 1](/diagrammes/CU1.png "Diagramme de cas d'utilisation détaillé 1")


![Diagramme de cas d'utilisation détaillé 2](/diagrammes/CU2.png "Diagramme de cas d'utilisation détaillé 2")


![Diagramme de cas d'utilisation détaillé 3](/diagrammes/CU3.png "Diagramme de cas d'utilisation détaillé 3")


## Diagramme(s) de classe <a name="classe"></a>

### Explications
Nous étions un peu confus sur quoi modélisé exactement dû à note manque d'expérience, nous 
avons donc décidéde modélise la logique d'affaire interne du programme (couche logique). Nous
avons commencé par constater que nous avons besoin du classe utilisateur, ainsi les différentes
classes d'utilisateur vont hérité de celle-ci et implémenter leurs comportements distincts. Le 
concept largement manipulé par le système nous semblait être un dossier, nous l'avons donc
représenté par une classe. Un dossier, à notre sens, est constituer d'une liste de visites, d'une liste
d'antécédent ainsi que des informations d'un patient. Chacun de ces concepts à donc été représenter
sous forme de classes qui constituent un dossier. Nous avons aussi modélisé le concept de coordonées et
d'établissement sous forme de classe. Car ceux-ci implique plusieurs informations distinctes.

### Diagramme
![Diagramme de classe](/diagrammes/CLASSE.png "Diagramme de classe")


## Diagramme(s) de séquence <a name="sequence"></a>
![Diagramme de séquence LIRE](/diagrammes/SEQLIRE.png "Diagramme de séquence LIRE")
![Diagramme de séquence MOD](/diagrammes/SEQMOD.png "Diagramme de séquence MOD")
![Diagramme de séquence COORD](/diagrammes/SEQCOORD.png "Diagramme de séquence COORD")


## Diagramme(s) de package <a name="package"></a>

### Explications

Nous avons décidé de couper notre programme en plusieurs couche. Chacune de ces couches
sera encapsulé dans son propre package. Ceci nous permets de réutilisé/réusiné une couche
pour l'utilisé dans une autre conception plus tard. Nous avons deux couches de présentation, une
pour le coté web et une pour le coté mobile. Chacunes d'elles encapsule un modèle MVC. La logique 
d'affaire du programe se trouve dans la couche logique. Dans la couche données nous avons mit la classe
qui servira de connecteur à la base de données du système.

### Diagramme
![Diagramme de package](/diagrammes/PACK.png "Diagramme de package")


## Diagramme(s) de composants <a name="comp"></a>
![Diagramme de composants](/diagrammes/COMP.png "Diagramme de composants")


## Diagramme(s) de déploiement <a name="dep"></a>
![Diagramme de déploiement](/diagrammes/DEP.png "Diagramme de déploiement")

## Justifications GRASP <a name="grasp"></a>

### Patron Contrôleur

Dans nos couches de présentation nous utilisons le patron de contrôleur dans le cadre
d'un modèle MVC (Modèle/Vue/Contrôleur). Le contrôlleur propre à chacune des couches
coordone les messages externes sans se coupler au objet internes.

### Patron Polymorphisme

Nos sous-classes de la classe abstraire Utilisateur utilise le patron de polymorphisme. Nous 
pouvons ainsi leur donner des comportements différent lorsque la même fonction est appelée sur les
classes ainsi que dans les divers contextes d'utilisation.

### Patron Spécialiste de l'information

Pour les classes Établissement, Coordonnées, infoPatient, Visite et Antécédent nous utilisons le
patron de spécialiste de l'information. Toute ces classes représente des concept distinct qui 
contiennent plusieurs données internes. Ces données sont donc encapsuler dans ces classes et elles
peuvent poser des actions envers celles-ci (les données) car ce sont elles (les classes) qui 
les connaissent.

### Patron Créateur

Pour la majorité des classes qui contiennemt des objets issue d'autre classes 
(aggrégations, références), nous utilisons le patron de créateur. La classe contenant les objets
est donc responsable de les créer. Un bon exemple de ceci serait notre classe Dossier, qui construit les objets de type Antécédent, Visite et InfoPatient.

### Patron Forte cohésion

Nous utilisons le patron forte cohésion dans notre conception. Ainsi plusieurs de nos classes
peuvent être utilisées a des fins que nous n'avons pas prévus. Par exemple, la classe coordonées
peut être utilisé pour représenter des coordonées autres que celle d'établissements ou de patients.
