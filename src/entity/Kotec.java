package entity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import databaze.Databaze;
import vyjimky.KonfigurakException;

/**
 * Trida pro kotec, vlastnost id, cislo kotce a pocet psu, kteri se vejdou do kotce
 * @author Jana Spilkova <spilkova@spsejecna.cz>
 *
 */

public class Kotec {
	private int id;
	private String cislo;
	private int kapacita;
	
	/**
	 * Zjistuje vsechny kotce v databazi
	 * 
	 * @return seznam vsech kotců v databazi
	 * @throws SQLException
	 * @throws IOException
	 */
	public static List<Kotec> getVsechnyKotce() throws SQLException, KonfigurakException {
		return Databaze.getInstance().getKotecVsechny();
	}
	
	/**
	 * 
	 * @return Id kotce v databazi
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Nastavi id kotce v databazi
	 * 
	 * @param id Id kotce v databazi
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vraci nazev kotce
	 * 
	 * @return Nazev kotce
	 */
	public String getCislo() {
		return cislo;
	}
	
	/**
	 * Nastavuje nazev kotce
	 * @param cislo Nazev kotce
	 */
	public void setCislo(String cislo) {
		this.cislo = cislo;
	}
	
	/**
	 * Vraci pocet psu, kteri mohou byt v kotci ubytovani
	 * @return Pocet psu, kteri mohou byt v kotci ubytovani
	 */
	public int getKapacita() {
		return kapacita;
	}
	
	/**
	 * Nastavuje pocet psu, kteri mohou byt v kotci ubytovani, musi byt kladne cislo
	 * @param kapacita Pocet psu, kteri mohou byt v kotci ubytovani
	 * @throws IllegalArgumentException Pocet kotcu musi byt kladny
	 */
	public void setKapacita(int kapacita) throws IllegalArgumentException{
		if (kapacita <= 0) 
			throw new IllegalArgumentException("Kapacita musí být kladné číslo!");
		this.kapacita = kapacita;
	}	
}
