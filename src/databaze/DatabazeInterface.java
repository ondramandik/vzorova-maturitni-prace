 package databaze;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entity.*;

/**
 * 
 * @author Jana Spilkova spilkova@spsejecna.cz
 *
 */
public interface DatabazeInterface {
	
	/**
	 * Metoda pro připojení do databáze
	 * @throws SQLException Připojení nelze navázat
	 */
	public void pripojit() throws SQLException;
	
	
	/**
	 * Metoda pro odpojení od databáze
	 * @throws SQLException SQL chyba
	 */
	public void odpojit() throws SQLException;
	
	/**
	 * Uloží ubytování do databáze
	 * @param u Ubytování
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public void saveUbytovani(Ubytovani u) throws SQLException;
	
	/**
	 * Ostraní ubytování z databáze
	 * @param u Ubytování
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public void removeUbytovani(Ubytovani u) throws SQLException;
		
	/**
	 * Vyhledá v databázi ubytování podle id
	 * @param id Id ubytování v databázi
	 * @return Instance ubytování daného id
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public Ubytovani getUbytovaniPodleId(int id) throws SQLException;

	/**
	 * Vyhledá všechna ubytování v zadaném datu
	 * @param datum Datum, ve kterém hledám ubytování
	 * @return List ubytování v zadaném datumu
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public List<Ubytovani> getUbytovaniPodleData(Date datum) throws SQLException;

	/**
	 * Vyhledá všechny majitele
	 * @return List všech majitelů
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public List<Majitel> getMajitelVsechny() throws SQLException;;

	/**
	 * Vyhledá majitele s daným id v databázi
	 * @param idMajitel Vyhledávané id majitele
	 * @return Majitel s daným id
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public Majitel getMajitelPodleId(int idMajitel) throws SQLException;
	
	/**
	 * Uloží majitele do databáze
	 * @param m Ukládaný majitel
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public void saveMajitel(Majitel m) throws SQLException;
	
	/**
	 * Odstraní majitele z databáze
	 * @param m Odstraňovaný majitel
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public void removeMajitel(Majitel m) throws SQLException;
	
	/**
	 * Vrací seznam všech psů v databázi
	 * @return List všech psů v databázi
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public List<Pes> getPesVsechny() throws SQLException;
	
	/**
	 * Vrací psa s daným id
	 * @param id Vyhledávané id
	 * @return Pes s daným id
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public Pes getPesPodleId(int id) throws SQLException;
	
	/**
	 * Vloží psa do databáze
	 * @param p Vkládaný pes
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public void savePes(Pes p) throws SQLException;
	
	/**
	 * Odstraní psa z databáze
	 * @param p Odstraňovaný pes
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public void removePes(Pes p) throws SQLException;
	
	/**
	 * Vyhledá v databázi daného recepčního podle id
	 * @param id Id hledaného recepčního
	 * @return Vyhledaný recepční
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public Recepcni getRecepcniPodleId(int id) throws SQLException;
	
	/**
	 * Vyhledá v databázi recepčního s daným přihlašovacím jménem a heslem
	 * @param uzivatelskeJmeno Vyhledávané uživatelské jméno
	 * @param heslo Vyhledávané heslo
	 * @return Vyhledaný recepční
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public Recepcni getRecepcniPodlePristupovychUdaju(String uzivatelskeJmeno, String heslo) throws SQLException;

	/**
	 * Vrátí seznam všech kotců
 	 * @return List všech kotců
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public List<Kotec> getKotecVsechny() throws SQLException;
	
	/**
	 * Vyhledá kotec podle id
	 * @param id Vyhledávané id
	 * @return Vyhledaná kotec
	 * @throws SQLException Chyba s dotazem do databaze
	 */
	public Kotec getKotecPodleId(int id) throws SQLException;
	
}