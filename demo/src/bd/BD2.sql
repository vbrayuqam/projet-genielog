PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE patient(assMaladieNum TEXT PRIMARY KEY NOT NULL,
nom TEXT, prenom TEXT, dateNaissance TEXT, genre TEXT, pere TEXT, mere TEXT, villeNaissance TEXT);
INSERT INTO patient VALUES('TREM01038503','Tremblay','Marie','1985-03-01','F','Roger Tremblay','Sophie Tremblay','Montreal');
INSERT INTO patient VALUES('FLEM01048602','Fleury','Martin','1986-04-01','M','Jean Fleury','Olivia Fleury','Quebec');
INSERT INTO patient VALUES('HUBA01058701','Hubert','Alice','1987-05-01','F','William Hubert','Lea Hubert','Gatineau');
CREATE TABLE coordonnees(adresseResident TEXT, telephone TEXT, courriel TEXT, id_number INTEGER PRIMARY KEY AUTOINCREMENT,
id_assMaladie TEXT, FOREIGN KEY(id_assMaladie) REFERENCES patient(assMaladieNum));
INSERT INTO coordonnees VALUES('10 casgrain','438-123-4567','marieTremblay@gmail.ca',1,'TREM01038503');
INSERT INTO coordonnees VALUES('15 jarry','514-987-6543','martinFleury@uqam.ca',2,'FLEM01048602');
INSERT INTO coordonnees VALUES('20 masson','438-564-1928','aliceHubert@uqam.ca',3,'HUBA01058701');
CREATE TABLE medecin(prenom TEXT, nom TEXT, id_medecin TEXT PRIMARY KEY NOT NULL, pass_medecin TEXT);
INSERT INTO medecin VALUES('Richard','Alain','login123','pass123');
INSERT INTO medecin VALUES('Michel','Tremlay','pleine','lune');
CREATE TABLE visites(etablissement TEXT, medecinVuPrenom TEXT, medecinVuNom TEXT, dateVisite TEXT, diagnosticEtablit TEXT, traitementEtablit TEXT, resumeVisite TEXT, notesMedecin TEXT, 
id_number INTEGER PRIMARY KEY AUTOINCREMENT, id_assMaladie TEXT, FOREIGN KEY(id_assMaladie) REFERENCES patient(assMaladieNum));
INSERT INTO visites VALUES('Rosemont','Paul','Rivard','2022-07-01','covid19','moderna','vaccination normale','verification des voies respiratoire',1,'TREM01038503');
INSERT INTO visites VALUES('Rosemont','Guy','Robert','2022-06-01','covid19','pfizer','vaccination normale','verification des voies respiratoire',2,'FLEM01048602');
INSERT INTO visites VALUES('McGill','Suzanne','Dubois','2022-03-01','coupure au dos','point de suture','souffrance intense du patient','faire un test de douleur',3,'HUBA01058701');
CREATE TABLE antecedents(diagnostic TEXT, traitement TEXT, medecinTraitantPrenom TEXT, medecinTraitanTNom TEXT, debutMaladie TEXT, finMaladie TEXT, id_number INTEGER PRIMARY KEY AUTOINCREMENT,
id_assMaladie TEXT, FOREIGN KEY(id_assMaladie) REFERENCES patient(assMaladieNum));
INSERT INTO antecedents VALUES('covid19','moderna','Paul','Rivard','2022-07-01','2022-07-15',1,'TREM01038503');
INSERT INTO antecedents VALUES('covid19','pfizer','Guy','Robert','2022-06-01','2022-06-15',2,'FLEM01048602');
INSERT INTO antecedents VALUES('coupure au dos','point de suture','Suzanne','Dubois','2022-03-01','2022-04-01',3,'HUBA01058701');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('coordonnees',3);
INSERT INTO sqlite_sequence VALUES('antecedents',3);
INSERT INTO sqlite_sequence VALUES('visites',3);
COMMIT;
