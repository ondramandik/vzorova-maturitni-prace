START TRANSACTION;

INSERT INTO kotec (cislo, kapacita) VALUES 
('1',3),
('2',3),
('3',2),
('4',2),
('5',3),
('K1',1),
('K2',1);

INSERT INTO recepcni (jmeno, prijmeni, uzivatelske_jmeno, heslo) VALUES 
('Jana','Nov�kov�','jnovakova','tatranka'),
('Petra','Svobodov�','psvobodova','MilujuJustina'),
('Kim','Hang Phang','kphang','ninja2017');

INSERT INTO sluzba (nazev, popis, cena_za_noc) VALUES 
('Ubytov�n� se stravou pro mal� a st�edn� plemena','Pes bude ubytov�n v kotci se stravou 3x denn� s krmen�m.',280),
('Ubytov�n� se stravou pro velk� plemena','Pes bude ubytov�n v kotci se stravou 3x denn� s krmen�m.',300),
('Ubytov�n� s vlastn� stravou','Pes bude ubytov�n v kotci se stravou, kterou dod�l majitel dle jeho pokyn�. Vhodn� pro alergick� psy.',240),


INSERT INTO vahova_kategorie (vaha_min, vaha_max, nazev) VALUES 
(0,10,'Mal� plemeno'),
(11,30,'St�edn� plemeno'),
(30,100,'Velk� plemeno');

COMMIT;