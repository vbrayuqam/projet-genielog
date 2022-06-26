Cas utilisation

- Medecin modifie dossier
- Patient modifie coordonnees
- acces lecture seule


@startuml UC1

title Lire Dossier

actor Utilisateur as U
participant “Interface Utilisateur” as IU
participant "Systeme Dossier Medical" as S
participant “Base de Donnees” as BD

U -> IU: Entrer numero dossier
IU -> S: Demande Dossier
S -> BD: Demande Dossier
BD --> S: Retour Dossier 
S --> IU: Retour Dossier
IU --> U : Affiche Dossier

@enduml
