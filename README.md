# Vzorová maturitní práce z předmětů PV + DS
Autor: Ing. Jana Spilková, Mgr. Alena Reichlová, Ing. Ondřej Mandík


## Databáze
Pred spustenim systemu je treba vytvorit databazi a naimportovat do ni strukturu, kterou naleznete v SQL skriptu /sql/struktura.sql. 

### Data od zadavatele
Veškerá data dle zadání naleznete ve složce `data`. Tato data, lze importovat do databáze spuštěním SQL skriptu `/sql/data.sql`. 


### E-R model
E-R model databaze v notaci UML naleznete na obrazku ![E-R Model](doc/er.png). Schéma databáze se nachází v 3. normální formě (3NF).


### Entitní integrita
Entitní integrita je zajištěna na úrovni databáze pomocí primamárních klíčů, které se nachází 


### Pristupove udaje do DB
Server: 193.85.203.188
Port: 3306
User: vmp
Password: test
Database: vzorova_maturitni_prace

## Zdrojový kód
Zdrový kód naleznete ve složce `/src`

### Unit testy
Veškeré testy aplikace jsou vytvořeny pomocí frameworku Junit. Třídy, které reprezentují testy jsou v v package nazvaném test. 

Pro spuštění testů v prostředí eclipse je potřeba přidat knihovny Junit 4 pomocí následujícího postupu: *Klikněte pravým tlačítkem na projekt > Properties > Java Build Path > Libraries > Add library* a zvolte *Junit 4*. Následně můžete testy spouštět pomocí okna JUnit v eclipse.