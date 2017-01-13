# vzorova-maturitni-prace
Vzorova maturitni prace pro SPSE Jecna z predmetu PV+DS 

# Data
Veskera data poskytnuta zakaznakem naleznete ve slozce data. Do databaze naimportujete data pomoci SQL skriptu /sql/data.sql.


# Databaze
Pred spustenim systemu je treba vytvorit databazi a naimportovat do ni strukturu, kterou naleznete v SQL skriptu /sql/struktura.sql. 

## E-R model
E-R model databaze v notaci UML naleznete na obrazku doc/e-r_model.png. 

## Pristupove udaje do DB
Server: 193.85.203.188
Port: 3306
User: vmp
Password: test
Database: vzorova_maturitni_prace

# Nastaveni Eclipse projektu

Protoze nastaveni eclipse projektu neni v Gitu, musite pro spravne nastaveni projektu udelat nasledujici kroky

* Kliknete pravym tlacitkem mysi na projekt a zvolte Properties > Java Build Path. 
* V pravo kliknete na Add Jars a vyberte vsechny soubory ve slozce /lib/ ktere reprezentuji JDBC konektory
