# Page de présentation
### Rapport 2
Remis dans le cadre du cours INF5153

Professeur: Gnagnely Serge Dogny

Membres de l'équipe:
- Vincent Bray
	BRAV20069009
- Lucas Poirier
	POIL20048805
- Alex Costa Soares
	SOAA01037905

Date de remise: 7 aout 2022


# Table des matières
1. [Patron Proxy](#proxy)

2. [Patron Facade](#facade)

3. [Patron Builder](#builder)

4. [Différences](#diff)

# Contenu
## Patron Proxy <a name="proxy"></a>
### Diagrammes
![Diagramme de classes proxy](/diagrammes/PROXYCLASS.png "Diagramme de classes proxy")
![Diagramme de séquence proxy](/diagrammes/PROXYSEQ.png "Diagramme de séquence proxy")
### Explications
La classe `ProxyDossier` sert de proxy pour accéder à la classe `Dossier`. Ainsi dans un contexte où l'application est plus large et différentes vues ou accès sur les dossiers doivent être nécessaires, il est possible de les gérer en utilisant le proxy. Il suffit d'invoquer la fonction désirer sur le proxy et celui-ci fera ce qui est nécessaire dans chaques cas.

## Patron Facade <a name="facade"></a>
### Diagrammes
![Diagramme de classes facade](/diagrammes/FACADESYSTEME.png "Diagramme de classes facade")
![Diagramme de séquence facade](/diagrammes/FACADESEQ.png "Diagramme de séquence facade")
### Explications
La facade `SystemeDossier` permet de découpler les accès à la base de données et les interfaces du reste du système. Ainsi les divers services et fonctionnement interne du système sont abstrait par la facade lorsque celle-ci intéragit avec la db et les diverses interfaces.


## Patron Builder <a name="sequence"></a>
### Diagrammes
![Diagramme de classes builder](/diagrammes/BUILDERCLASSES.png "Diagramme de classes builder")
![Diagramme de séquence builder](/diagrammes/SEQBUILDER.png "Diagramme de séquence builder")
### Explications
Étant donné que `Dossier` est un objet composite qui contient plusieurs autres objets qui, eux-mêmes, contiennent plusieurs objets, nous utilisons une classe builder, en l'occurence la classe `ConnecteurBD`, pour gérer la création des dossiers et leurs composants.

## Différences entre l'implémentation et la conception<a name="diff"></a>
À cause de l'utilisation de `Beans` java, les visites et les antécédents sont contenus dans tes tableaux et non des listes. Les `Beans` nous donnaient aussi des problèmes avec la classe abstraite établissement, ainsi nous en avons fait une simple classe et n'avons pas implémenté les classes `Clinique` et `Hopital`. Les informations entre le système dossier et les interfaces sont faites par des objets JSON, ce qui n'était pas représenté dans notre conception.
