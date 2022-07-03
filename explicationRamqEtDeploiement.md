## Diagramme de déploiement

### Explications

Un diagramme de déploiement est une représentation de la topologie des
composantes physiques d'un système et les liens de communications entre ces
composantes. Elle sert à donner un portrait général du matériel d'un système
que l'on veut représenter. Dans notre cas, nous avons des patients qui accèdent
à leur dossier par l'entremise d'un navigateur web à partir d'un PC ou par
l'entremise d'une application mobile d'un téléphone mobile. Nous avons
également des professionnels médical ( des médecins ou autres) et des employés
de la RAMQ qui accèdent au système par un logiciel de gestion installé sur un
ordinateur.  Les PC, téléphones mobiles et ordinateurs sont connectés à
internet et communiquent avec un serveur web (la couche présentation). Celui-ci
communique avec un serveur application (couche logique) qui se charge de la
communication avec une base de données SQLite3.


## Diagramme de séquence de la création d'un dossier par un employé de la RAMQ

### Explications

Dans cette séquence, on a un employé de la RAMQ qui tente de se connecter au
système avec son identifiant à travers un interface utilisateur. Dans le cas
d'un refus, l'employé reçoit un message d'une connexion refusée. Dans le cas
d'une connexion acceptée, l'employé de la RAMQ utlise l'interface utilisateur
pour créer un dossier à partir d'information qu'il possède. Par la suite, le
système de dossiers crée un dossier d'un patient. Un patient a des coordonnées
lors de la création d'un dossier mais n'a pas d'antécédents ni de visites lors
de la création du dossier (antécdent et visite sont des listes vides). Ensuite,
le dossier est écrit dans un base de données. Enfin, un message de confirmation
est envoyé à l'employé de la RAMQ par l'entremise de l'interface utilisateur.


## Diagramme de séquence de la reconstruction d'un dossier par un employé de la
## RAMQ

### Explications

Dans cette séquence, on a un employé de la RAMQ qui tente se connecter au
système avec son identifiant à travers un interface utilisateur. Dans le cas
d'un refus, l'employé reçoit un message d'une connexion refusée. Dans le cas
d'une connexion acceptée, l'employé de la RAMQ utilise l'interface utilisateur
pour lire le dossier d'un patient. Si le dossier du patient n'existe pas, un
message lui est envoyé de l'inexistence du dossier et l'employé doit suivre la
séquence de création d'un dossier. Dans le cas où le dossier du patient existe,
l'employé utilise l'interface utilisateur pour faire la requête de
reconstruction d'un dossier à partir des informations qu'il possède (à partir
d'une date par exemple). Le système se charge de la création du dossier en
communiquant avec dossier et patient qui se charge de la modification des
coordonnées, des visites et des antécédents. Par la suite, le dossier est écrit
dans une base de données. Enfin, un message est envoyé à l'employé de la RAMQ
par l'entremise de l'interface utilisateur que le dossier est reconstruit.
