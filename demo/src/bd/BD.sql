PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE patient(assMaladieNum TEXT PRIMARY KEY NOT NULL,
nom TEXT, prenom TEXT, dateNaissance TEXT, genre TEXT, pere TEXT, mere TEXT, villeNaissance TEXT);
INSERT INTO patient VALUES('TREM01038503','Tremblay','Marie','1 mars 1985','F','Roger Tremblay','Sophie Tremblay','Montreal');
INSERT INTO patient VALUES('FLEM01048602','Fleury','Martin','1 avril 1986','M','Jean Fleury','Olivia Fleury','Quebec');
INSERT INTO patient VALUES('HUBA01058701','Hubert','Alice','1 mai 1987','F','William Hubert','Lea Hubert','Gatineau');
CREATE TABLE coordonnees(adresseResident TEXT, telephone TEXT, courriel TEXT, id_number INTEGER PRIMARY KEY AUTOINCREMENT,
id_assMaladie TEXT, FOREIGN KEY(id_assMaladie) REFERENCES patient(assMaladieNum));
INSERT INTO coordonnees VALUES('10 casgrain','438-123-4567','marieTremblay@gmail.ca',1,'TREM01038503');
INSERT INTO coordonnees VALUES('15 jarry','514-987-6543','martinFleury@uqam.ca',2,'FLEM01048602');
INSERT INTO coordonnees VALUES('20 masson','438-564-1928','aliceHubert@uqam.ca',3,'HUBA01058701');
CREATE TABLE medecin(nom TEXT, id_medecin TEXT PRIMARY KEY NOT NULL, pass_medecin TEXT);
INSERT INTO medecin VALUES('Richard Alain','login123','pass123');
INSERT INTO medecin VALUES('Michel Tremlay','pleine','lune');
CREATE TABLE visites(etablissement TEXT, medecinVu TEXT, dateVisite TEXT, diagnosticEtablit TEXT, traitementEtablit TEXT, resumeVisite TEXT, notesMedecin TEXT, 
id_number INTEGER PRIMARY KEY AUTOINCREMENT, id_assMaladie TEXT, FOREIGN KEY(id_assMaladie) REFERENCES patient(assMaladieNum));
INSERT INTO visites VALUES('Rosemont','Paul Rivard','1 juillet 2022','covid19','moderna','vaccination normale','verification des voies respiratoire',1,'TREM01038503');
INSERT INTO visites VALUES('Rosemont','Guy Robert','1 juin 2022','covid19','pfizer','vaccination normale','verification des voies respiratoire',2,'FLEM01048602');
INSERT INTO visites VALUES('McGill','Suzanne Dubois','1 mars 2022','coupure au dos','point de suture','souffrance intense du patient','faire un test de douleur',3,'HUBA01058701');
CREATE TABLE antecedents(diagnostic TEXT, traitement TEXT, medecinTraitant TEXT, debutMaladie TEXT, finMaladie TEXT, id_number INTEGER PRIMARY KEY AUTOINCREMENT,
id_assMaladie TEXT, FOREIGN KEY(id_assMaladie) REFERENCES patient(assMaladieNum));
INSERT INTO antecedents VALUES('covid19','moderna','Paul Rivard','1 juillet 2022','15 juillet 2022',1,'TREM01038503');
INSERT INTO antecedents VALUES('covid19','pfizer','Guy Robert','1 juin 2022','15 juin 2022',2,'FLEM01048602');
INSERT INTO antecedents VALUES('coupure au dos','point de suture','Suzanne Dubois','1 mars 2022','1 avril 2022',3,'HUBA01058701');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('coordonnees',3);
INSERT INTO sqlite_sequence VALUES('antecedents',3);
INSERT INTO sqlite_sequence VALUES('visites',3);
COMMIT;
