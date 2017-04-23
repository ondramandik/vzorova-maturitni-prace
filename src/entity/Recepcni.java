package entity;

import java.io.IOException;
import java.sql.SQLException;

import databaze.Databaze;
import vyjimky.KonfigurakException;

/**
 * Trida pro uchovavani infromaci o recepcnich a o aktualne prihlasenem recepcnim.
 * Dedi od tridy Osoba.
 * @author Jana Spilkova spilkova@spsejecna.cz
 *
 */
public class Recepcni extends Osoba{
		
	private String uzivatelskeJmeno;
	private String heslo;
	private static Recepcni prihlaseny;
	
	/**
	 * Vraci aktualne prihlaseneho recepcniho
	 * @return Aktualne prihlaseny recepcni nebo null, pokud neni prihlaseny uzivatel
	 */
	public static Recepcni getPrihlasenyRecepcni(){
		return prihlaseny;
	}
	
	/**
	 * Zkontroluje uzivatelske jmeno a heslo a prihlasi recepniho, pokud jsou spravne.
	 * @param uzivatelskeJmeno Uzivatelske jmeno recepcniho
	 * @param heslo Heslo recepscniho
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void prihlas(String uzivatelskeJmeno, String heslo) throws SQLException, KonfigurakException{
		odhlas();
		prihlaseny = Databaze.getInstance().getRecepcniPodlePristupovychUdaju(uzivatelskeJmeno, heslo);
	}
	
	/**
	 * Odhlasi recepcniho
	 */
	public static void odhlas(){
		prihlaseny = null;
	}
	
	/**
	 * Vytvori instanci tridy Recepcni
	 * @param id Id recepcniho v databazi
	 * @param jmeno Jmeno recepcniho
	 * @param prijmeni Prijmeni recepcniho
	 * @param uzivatelskeJmeno Uzivatelske jmeno recepcniho
	 * @param heslo Heslo recepcniho
	 */
	public Recepcni(int id, String jmeno, String prijmeni, String uzivatelskeJmeno, String heslo) {
		super(id, jmeno, prijmeni);

		this.uzivatelskeJmeno = uzivatelskeJmeno;
		this.heslo = heslo;
	}
	
	/**
	 * Vytvori instanci tridy Recepcni s defaultnimi hodnotami
	 */
	public Recepcni() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Vraci uzivatelske jmeno recepcniho
	 * @return Uzivatelske jmeno recepcniho
	 */
	public String getUzivatelskeJmeno() {
		return uzivatelskeJmeno;
	}
	
	/**
	 * Nastavuje uzivatelske jmeno recepcniho
	 * @param uzivatelskeJmeno Uzivatelske jmeno recepcniho
	 */
	public void setUzivatelskeJmeno(String uzivatelskeJmeno) {
		this.uzivatelskeJmeno = uzivatelskeJmeno;
	}
	
	/** 
	 * Vraci heslo recepcniho
	 * @return Heslo recepcniho
	 */
	public String getHeslo() {
		return heslo;
	}
	
	/**
	 * Natavuje heslo recepcnimu
	 * @param heslo Heslo recepcniho
	 */
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
	

}
