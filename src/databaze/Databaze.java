package databaze;

import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

import vyjimky.DatabazeException;
import vyjimky.KonfigurakException;

/**
 * Trida umoznujici ziskani instance tridy, ktera se skutecne pripojuje do databaze
 * 
 * @author Ondra Mandik
 */
public class Databaze {
	
	/**
	 * Po dobu behu aplikace uchovava instaci tridy pripojene do databaze
	 */
	private static DatabazeInterface instance = null;
	
	/**
	 * Po dobu behu aplikace uchovvava instaci tridy umoznujici pristup ke konfiguracnimu souboru
	 */
	private static Properties konfiguracniSoubor = null;
	
	/**
	 * Podle zadaneho nazvu vraci hodnotu z konfiguracniho souboru
	 * 
	 * @param nazev Klic nebo nazev hodnoty kterou chceme vratit
	 * @return Hodnotu podle zadaneho nazvu
	 * @throws IOException Pokud je soubor nedostupny
	 */
	private static String nactiZKonfiguracnihoSouboru(String nazev) throws KonfigurakException {
		if(konfiguracniSoubor == null) {
			try{
				Reader is = new FileReader("config/konfigurace.ini");
				konfiguracniSoubor = new Properties();
				konfiguracniSoubor.load(is);
			}catch(FileNotFoundException e){
				throw new KonfigurakException("Soubor \"config/konfigurace.ini\" nebyl nalezen");
			}
			catch(IOException e){
				throw new KonfigurakException("Chyba pri cteni ze souboru \"config/konfigurace.ini\"");
			}
		}
		
		return konfiguracniSoubor.getProperty(nazev);
	}
	
	/**
	 * Metoda vraci tridu pro umoznujici praci s databazi podle interfacu
	 * 
	 * @return Trida pro podle interface, ktery umoznuje pracovat s databazi
	 * @throws SQLException Pokud se nepovede pripojit do DB
	 * @throws IOException Pokud se nepovede nacist hodnoty z konfiguracniho souboru
	 */
	public static DatabazeInterface getInstance() throws DatabazeException, KonfigurakException {
		if(instance == null) {
			String host = nactiZKonfiguracnihoSouboru("mysql_host");
			String port = nactiZKonfiguracnihoSouboru("mysql_port");
			String db = nactiZKonfiguracnihoSouboru("mysql_database");
			String user = nactiZKonfiguracnihoSouboru("mysql_username");
			String pass = nactiZKonfiguracnihoSouboru("mysql_password");
			
			instance = new DatabazeMySQL(host, port,db,user,pass);
			instance.pripojit();
		}
		return instance;
	}
	
	public static void odpojit() {
		if(instance != null) {
			try {
				instance.odpojit();
			} catch (SQLException e) {
				//Nebudu delat nic
			}
			instance = null;
		}
	}
	
	/**
	 * Konstruktor tridy pro obsluhu DB vrstvy
	 * 
	 * Tato trida ma pouze staticke metody, pouzitim private konstruktoru tak 
	 * zablokujeme moznost vytovreni instance
	 */
	private Databaze() {
		
	}
}
