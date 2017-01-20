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

COMMIT;
