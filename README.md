# Vzorová maturitní práce z předmětů PV + DS
Autor: Ing. Jana Spilková, Mgr. Alena Reichlová, Ing. Ondřej Mandík


## E-R model
E-R model databáze naleznete na obrazku: ![E-R Model](doc/er.png). 

Schéma databáze se nachází v 3. normální formě (3NF). Všechny objekty byly pojmenovány bez háčků a čárek. Schéma bylo vytovořeno pro RDMBS MySQL, po menších úpravách lze využít i pro jiné databázové systémy.

## Entitní integrita
Je zajištěna pomocí uměle přidaných primárních klíčů, které jsou v každé tabulce označeny jako `id_<nazev_tabulky>` a obsahují automaticky generovaná celá čísla počínaje číslem 1.

## Doménová integrita

U klíčů (primárních i cizích) je nastavena jako kladné celé číslo a povinnost je dána dle nastavení referenční integrity. U neklíčových atributů je nastavena dle následujícího rozpisu.

**kotec**
* `cislo` - povinné
* `kapacita` - povinné a kladné

**majitel**
* `jmeno` - povinné, povoleny pouze písmenka
* `prijmeni` - povinné, povoleny pouze písmenka
* `tel` - povinné, ve formátu XXXXXXXXX 
* `email` - povinné, ve formátu xxx@xxx.xx
* `mesto` - povinné, povoleny pouze písmenka
* `psc` - povinné, ve formátu XXXXX
* `ulice` - povoleny písmenka, čísla a tečka
* `ulice_cislo_popisne` - povinné, povoleny pouze kladná čísla bez nuly
* `ulice_cislo_orientacni` - povinné, povoleny pouze kladná čísla bez nuly

**pes**
* `jmeno` - povinné, povolena pouze písmenka

**recepcni** *(Všechny hodnoty jsou napevno načteny ze vzorových dat a nepřepodkládá se, že je někdo bude upravovovat)*
* `jmeno`, povinné, pouze písmenka
* `prijmeni`, povinné, pouze písmenka
* `uzivatelske_jmeno` povnné pouze malé znaky anglické abecedy
* `heslo`, povinné, min 8. znaků, min. 1x číslo a min. 1x písmenko

**ubytovani**
* `od`, povinné, větší nebo rovno než `do`
* `do`, povinné, menší nebo rovno než `od`
  

## Referenční integrita
Je zajištěna dle následujícího seznamu všech vazeb:

* **ubytovani -- kotec** 
	* Povinná vazba, každé ubytování musí mít kotec. 
	* Kotec nelze smazat, pokud je něj navázáno ubytování, ani změnit ID.
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
	

## Indexy 
Databáze obsahuje několik indexů, popsaných v následujícím výčtu:

* UQ **recepcni.uzivatelske_jmeno** Unikátní index v tabulce `recepcni` nad sloupcem `uzivatelske_jmeno` zajišťuje unikátnost uživatelského jména a zrychluje vyhledání uživatele při přihlášení.


* UQ **kotec.cislo** Unikátní index v tabulce `kotec` nad sloupcem `cislo` zajišťuje unikátnost označení kotce, neboť lze předpokládat jeho přirozenou unikátnost.


* UQ **majitel.email** Unikátní index v tabulce `majitel` nad sloupcem `email` zajišťuje unikátnost e-mailu majitele psa. Tento index přispívá k zachování entitní integrity tabulky majitelů, konkrétně zamezuje dvojí registraci stejného uživatele.


* IDX **(majitel.jmeno, majitel.prijmeni)** Složený index v tabulce `majitel` nad sloupci `jmeno` a `prijmeni` zefektivňuje vyhledávání uživatele podle jména a příjímení.

## Import struktury databáze
Pred spustenim systemu je treba vytvorit databazi a naimportovat do ni strukturu, kterou naleznete v SQL skriptu `/sql/struktura.sql`. 

## Import dat od zadavatele do databáze
Veškerá data dle zadání naleznete ve složce `data`. Tato data, lze importovat do databáze spuštěním SQL skriptu `/sql/data.sql`.

## Přístupové údaje do databáze
	Server: 193.85.203.188
	Port: 3306
	User: vm
	Password: test
	Database: vzorova_maturitni_prac

## Klientská aplikace
Zdrový kód naleznete ve složce `/src`

## Požadavky na spuštění
* MySQL Server, min. verze 2014 s importovanými daty i strukturou
* Internetové připojení, min. 2Mb/s
* Diskový prostor, min, 10 MB
* Java Runtime Enviroment min. verze 8

## Postup instalace
* Přejděte do složky `/release` a nastavte konfigurační soubor na hodnoty Vaší databáze

* Přejděte do složky `/release` a spusťte aplikaci příkazem:
`java -jar maturitni-prace.jar`

* Přihlašte se pomocí účtu:

`Uživatelské jméno: jnovakova`

`Heslo: tatranka`
	
* DOPSAT dale

## Unit testy
Veškeré testy aplikace jsou vytvořeny pomocí frameworku Junit. Třídy, které reprezentují testy jsou v v package nazvaném test. 

Pro spuštění testů v prostředí eclipse je potřeba přidat knihovny Junit 4 pomocí následujícího postupu: *Klikněte pravým tlačítkem na projekt > Properties > Java Build Path > Libraries > Add library* a zvolte *Junit 4*. Následně můžete testy spouštět pomocí okna JUnit v eclipse.