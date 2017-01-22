START TRANSACTION;

DROP TABLE IF EXISTS ubytovani;
DROP TABLE IF EXISTS pes;
DROP TABLE IF EXISTS majitel;
DROP TABLE IF EXISTS recepcni;
DROP TABLE IF EXISTS kotec;

CREATE TABLE kotec (
  id_kotec int(11) NOT NULL auto_increment,
  cislo varchar(2) COLLATE utf8_czech_ci NOT NULL,
  kapacita int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id_kotec),
  UNIQUE KEY uq_cislo (cislo)
);

CREATE TABLE majitel (
  id_majitel int(11) NOT NULL auto_increment,
  jmeno varchar(150) COLLATE utf8_czech_ci NOT NULL,
  prijmeni varchar(150) COLLATE utf8_czech_ci NOT NULL,
  tel varchar(6) COLLATE utf8_czech_ci NOT NULL,
  email varchar(255) COLLATE utf8_czech_ci DEFAULT NULL,
  mesto varchar(210) COLLATE utf8_czech_ci DEFAULT NULL,
  psc varchar(5) COLLATE utf8_czech_ci DEFAULT NULL,
  ulice varchar(200) COLLATE utf8_czech_ci DEFAULT NULL,
  ulice_cislo_popisne int(10) unsigned DEFAULT NULL,
  ulice_cislo_orientacni int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (id_majitel),
  UNIQUE KEY uq_email (email),
  KEY idx_jmeno_prijmeni (jmeno,prijmeni)
);

CREATE TABLE pes (
  id_pes int(11) NOT NULL auto_increment,
  jmeno int(11) NOT NULL,
  id_majitel int(11) NOT NULL,
  PRIMARY KEY (id_pes),
  KEY idx_pes_majitel (id_majitel),
  CONSTRAINT fk_pes_majitel FOREIGN KEY (id_majitel) REFERENCES majitel (id_majitel) ON DELETE CASCADE
);

CREATE TABLE recepcni (
  id_recepcni int(11) NOT NULL auto_increment,
  jmeno varchar(150) NOT NULL,
  prijmeni varchar(150) NOT NULL,
  uzivatelske_jmeno varchar(150) COLLATE utf8_czech_ci NOT NULL,
  heslo varchar(255) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (id_recepcni),
  UNIQUE KEY uq_uzivatelske_jmeno (uzivatelske_jmeno)
);


CREATE TABLE ubytovani (
  id_ubytovani int(11) NOT NULL auto_increment,
  id_majitel int(11) NOT NULL,
  id_pes int(11) NOT NULL,
  id_kotec int(11) NOT NULL,
  vytvoril_id_recepcni int(11) NOT NULL,
  prijal_id_recepcni int(11) DEFAULT NULL,
  vydal_id_recepcni int(11) DEFAULT NULL,
  od date NOT NULL,
  `do` date NOT NULL,
  PRIMARY KEY (id_ubytovani),
  KEY fk_ubytovani_pes_idx (id_pes),
  KEY fk_ubytovani_majitel_idx (id_majitel),
  KEY fk_ubytovani_kotec_idx (id_kotec),
  KEY fk_ubytovani_vytvoril_recepcni_idx (vytvoril_id_recepcni),
  KEY fk_ubytovani_vydal_recepcni_idx (vydal_id_recepcni),
  KEY fk_ubutovani_prijal_recepcni_idx (prijal_id_recepcni),
  CONSTRAINT fk_ubytovani_pes FOREIGN KEY (id_pes) REFERENCES pes (id_pes) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_majitel FOREIGN KEY (id_majitel) REFERENCES majitel (id_majitel) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_kotec FOREIGN KEY (id_kotec) REFERENCES kotec (id_kotec) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_vytvoril_recepcni FOREIGN KEY (vytvoril_id_recepcni) REFERENCES recepcni (id_recepcni) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_vydal_recepcni FOREIGN KEY (vydal_id_recepcni) REFERENCES recepcni (id_recepcni) ON UPDATE CASCADE,
  CONSTRAINT fk_ubutovani_prijal_recepcni FOREIGN KEY (prijal_id_recepcni) REFERENCES recepcni (id_recepcni) ON UPDATE CASCADE
);

COMMIT;
