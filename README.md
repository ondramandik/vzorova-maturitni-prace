# Vzorová maturitní práce z předmětů PV + DS
Autor: Ing. Jana Spilková, Mgr. Alena Reichlová, Ing. Ondřej Mandík


## Databáze
Pred spustenim systemu je treba vytvorit databazi a naimportovat do ni strukturu, kterou naleznete v SQL skriptu /sql/struktura.sql. 

### Data od zadavatele
Veškerá data dle zadání naleznete ve složce `data`. Tato data, lze importovat do databáze spuštěním SQL skriptu `/sql/data.sql`. 


### E-R model
E-R model databaze v notaci UML naleznete na obrazku ![E-R Model](doc/er.png). Schéma databáze se nachází v 3. normální formě (3NF).


### Entitní integrita
Je zajištěna pomocí uměle přidaných primárních klíčů, které jsou v každé tabulce označeny jako `id_<nazev_tabulky>` a obsahují automaticky generovaná celá čísla počínaje číslem 1.

### Doménová integrita

kotec
* `cislo` - povinné
* `kapacita` - povinné a kladné

majitel
* `jmeno` - povinné, povoleny pouze písmenka
* `prijmeni` - povinné, povoleny pouze písmenka
* `tel` - povinné, ve formátu XXXXXXXXX 
* `email` - povinné, ve formátu xxx@xxx.xx
* `mesto` - povinné, povoleny pouze písmenka
* `psc` - povinné, ve formátu XXXXX
* `ulice` - povoleny písmenka, čísla a tečka
* `ulice_cislo_popisne` - povinné, povoleny pouze kladná čísla bez nuly
* `ulice_cislo_orientacni` - povinné, povoleny pouze kladná čísla bez nuly

CREATE TABLE vahova_kategorie (
  id_vahova_kategorie int(11) NOT NULL auto_increment,
  vaha_min int(11) NOT NULL,
  vaha_max int(11) NOT NULL,
  nazev varchar(45) COLLATE utf8_czech_ci NOT NULL,
  PRIMARY KEY (id_vahova_kategorie)
);

CREATE TABLE pes (
  id_pes int(11) NOT NULL auto_increment,
  jmeno int(11) NOT NULL,
  id_majitel int(11) NOT NULL,
  id_vahova_kategorie int(11) NOT NULL,
  PRIMARY KEY (id_pes),
  KEY idx_pes_vahova_kategorie (id_vahova_kategorie),
  KEY idx_pes_majitel (id_majitel),
  CONSTRAINT fk_pes_majitel FOREIGN KEY (id_majitel) REFERENCES majitel (id_majitel) ON DELETE CASCADE,
  CONSTRAINT fk_pes_vahova_kategorie FOREIGN KEY (id_vahova_kategorie) REFERENCES vahova_kategorie (id_vahova_kategorie)
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

CREATE TABLE sluzba (
  id_sluzba int(11) NOT NULL auto_increment,
  nazev varchar(200) COLLATE utf8_czech_ci NOT NULL,
  popis text COLLATE utf8_czech_ci NOT NULL,
  cena_za_noc double unsigned NOT NULL,
  PRIMARY KEY (id_sluzba)
);

CREATE TABLE ubytovani (
  id_ubytovani int(11) NOT NULL auto_increment,
  id_sluzba int(11) NOT NULL,
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
  KEY fk_ubytovani_sluzba_idx (id_sluzba),
  KEY fk_ubytovani_vytvoril_recepcni_idx (vytvoril_id_recepcni),
  KEY fk_ubytovani_vydal_recepcni_idx (vydal_id_recepcni),
  KEY fk_ubutovani_prijal_recepcni_idx (prijal_id_recepcni),
  CONSTRAINT fk_ubytovani_pes FOREIGN KEY (id_pes) REFERENCES pes (id_pes) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_majitel FOREIGN KEY (id_majitel) REFERENCES majitel (id_majitel) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_kotec FOREIGN KEY (id_kotec) REFERENCES kotec (id_kotec) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_sluzba FOREIGN KEY (id_sluzba) REFERENCES sluzba (id_sluzba) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_vytvoril_recepcni FOREIGN KEY (vytvoril_id_recepcni) REFERENCES recepcni (id_recepcni) ON UPDATE CASCADE,
  CONSTRAINT fk_ubytovani_vydal_recepcni FOREIGN KEY (vydal_id_recepcni) REFERENCES recepcni (id_recepcni) ON UPDATE CASCADE,
  CONSTRAINT fk_ubutovani_prijal_recepcni FOREIGN KEY (prijal_id_recepcni) REFERENCES recepcni (id_recepcni) ON UPDATE CASCADE
);


Zajišťuje se pro všecny \textbf{neklíčové atributy}.
	\item V dokumentaci se uvádí \textbf{jakým způsobem} je u každého atributu zajištěna.

	\item Nejsou to pouze datové typy.
\item Není to pouze \texttt{NULL} a \texttt{NOT NULL}.
	\item Pokud je část doménové integrity čitelná z E-R modelu, můžete na něj odkázat.
	\item Neuvádějte zbytečně definice.

\begin{tabular}{|l|l|l|p{70pt}|}
\hline
\footnotesize\sf\bf Tabulka.Atribut   & \footnotesize\sf\bf Datový typ  & \footnotesize\sf\bf IS NULL & \footnotesize\sf\bf Omezení                                          \\
\hline
ZBOZI.CENA        & DOUBLE      & NO   & ZBOZI.CENA\textgreater0                        \\
\hline
ZAKAZNIK.TELEFON  & VARCHAR(11) & YES  & XXX XXX XXX                             \\
\hline
ZAKAZNIK.PRIJMENI & VARCHAR(45) & NO   & \footnotesize\sf Pouze alfabetické znaky v rozmezí 2 až 45 znaků. \\
\hline
...&...& ...   & ...\\

\end{tabular}


### Referenční integrita
Je zajištěna dle následujícího seznamu všech vazeb:

* **ubytovani -- kotec** 
	* Povinná vazba, každé ubytování musí mít kotec. 
	* Kotec nelze smazat, pokud je něj navázáno ubytování, ani změnit ID.
	* Změní-li se službe ID, změna se kaskádově propíše i do tabulky ubytování.

* **ubytovani -- sluzba**
	* Povinná vazba, každé ubytování musí mít službu. 
	* Služba nelze smazat, pokud je na ni vazba z ubytování.
	* Změní-li se službe ID, změna se kaskádově propíše i do tabulky ubytování.

* **ubytovani -- majitel**
	* Povinná vazba, každé ubytování musí mít majitele. 
	* Majitel nelze smazat, pokud je na něj vazba z ubytování.
	* Změní-li se majiteli ID, změna se kaskádově propíše i do tabulky ubytování.

* **ubytovani -- pes**
	* Povinná vazba, každé ubytování musí mít psa. 
	* Pes nelze smazat, pokud je na něj vazba z ubytování.
	* Změní-li se psovi ID, změna se kaskádově propíše i do tabulky ubytování.

* **pes -- majitel**
	* Povinná vazba, každý pes musí mít majitele. 
	* Majitel nelze smazat, pokud je na něj vazba ze psa.
	* Změní-li se majiteli ID, změna se kaskádově propíše i do tabulky pes.
	
* **pes -- vahova_kategorie **
	* Povinná vazba, každý pes musí mít majitele. 
	* Majitel nelze smazat, pokud je na něj vazba ze psa.
	* Změní-li se majiteli ID, změna se kaskádově propíše i do tabulky pes.

### Přístupové údaje do databáze

	Server: 193.85.203.188
	Port: 3306
	User: vm
	Password: test
	Database: vzorova_maturitni_prac

## Zdrojový kód
Zdrový kód naleznete ve složce `/src`

### Unit testy
Veškeré testy aplikace jsou vytvořeny pomocí frameworku Junit. Třídy, které reprezentují testy jsou v v package nazvaném test. 

Pro spuštění testů v prostředí eclipse je potřeba přidat knihovny Junit 4 pomocí následujícího postupu: *Klikněte pravým tlačítkem na projekt > Properties > Java Build Path > Libraries > Add library* a zvolte *Junit 4*. Následně můžete testy spouštět pomocí okna JUnit v eclipse.