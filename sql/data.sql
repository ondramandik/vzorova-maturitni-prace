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
('Jana','Nováková','jnovakova','tatranka'),
('Petra','Svobodová','psvobodova','MilujuJustina'),
('Kim','Hang Phang','kphang','ninja2017');

INSERT INTO sluzba (nazev, popis, cena_za_noc) VALUES 
('Ubytování se stravou pro malá a støední plemena','Pes bude ubytován v kotci se stravou 3x dennì s krmením.',280),
('Ubytování se stravou pro velká plemena','Pes bude ubytován v kotci se stravou 3x dennì s krmením.',300),
('Ubytování s vlastní stravou','Pes bude ubytován v kotci se stravou, kterou dodál majitel dle jeho pokynù. Vhodné pro alergické psy.',240),


INSERT INTO vahova_kategorie (vaha_min, vaha_max, nazev) VALUES 
(0,10,'Malé plemeno'),
(11,30,'Støední plemeno'),
(30,100,'Velké plemeno');

COMMIT;