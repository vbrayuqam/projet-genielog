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

Date de remise: 3 juillet 2022


# Table des matières
1. [Patron Proxy](#proxy)

2. [Patron Facade](#facade)

3. [Patron Builder](#builder)


# Contenu
## Patron Proxy <a name="proxy"></a>
### Diagrammes
![Diagramme de connection app medecin](/diagrammes/PROXYCLASS.png "Diagramme de connection application medecin")
![Diagramme de connection app medecin](/diagrammes/PROXYSEQ.png "Diagramme de connection application medecin")
### Explications
La classe ProxyDossier sert de proxy pour accéder à la classe Dossier. Ainsi dans un contexte où l'application est plus large et différentes vues ou accès sur les dossiers doivent être nécessaires, il est possible de les gérer en utilisant le proxy. Il suffit d'invoquer la fonction désirer sur le proxy et celui-ci fera ce qui est nécessaire dans chaques cas.

## Patron Facade <a name="facade"></a>
### Diagrammes
### Explications


## Patron Builder <a name="sequence"></a>
### Diagrammes
### Explications

