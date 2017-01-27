package entity;

/**
 * Trida  pro uchovavani informaci o majiteli psa (telefon, email, adresa).
 * Trida je oddedena od tridy osoba.
 * Trida ocekava data podle README.md, neresi spravnost vstupnich dat.
 * @author Jana Spilkova spilkova@spsejecna.cz
 *
 */
public class Majitel extends Osoba{
	private String telefon;
	private String email;
	private String mesto;
	private String psc;
	private String ulice;
	private int uliceCisloPopisne;
	private int uliceCisloOrientacni;

	@Override
	public String toString() {
		return "Majitel [" + this.jmeno +" " + this.prijmeni + "]";
	}

	/**
	 * Vraci telefon majitele psa
	 * @return Telefon majitele psa
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Nastabuje telefon majitele psa
	 * @param telefon Telefon majitele psa
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	/**
	 * Vraci email majitele psa
	 * @return Email majitele psa
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Nastavuje email majitele psa
	 * @param email Email majitele psa
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Vraci mesto z adresy majitele psa
	 * @return Mesto z adrese majitele psa
	 */
	public String getMesto() {
		return mesto;
	}

	/**
	 * Nastavuje mesto do adresy majitele psa
	 * @param mesto Mesto adresy majitele psa
	 */
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	/**
	 * Vraci PSC z adresy majitele psa
	 * @return PSC z adresy majitele psa
	 */
	public String getPsc() {
		return psc;
	}

	/**
	 * Natavuje PSC adresy majitele psa
	 * @param psc PSC adresy majitele psa
	 */
	public void setPsc(String psc) {
		this.psc = psc;
	}

	/**
	 * Vraci ulici adresy majitele psa
	 * @return Ulice majitele psa
	 */
	public String getUlice() {
		return ulice;
	}

	/**
	 * Nastavuje ulici do adresy majitele psa
	 * @param ulice Ulice adresy majitele psa
	 */
	public void setUlice(String ulice) {
		this.ulice = ulice;
	}

	/**
	 * Vraci cislo popisne adresy majitele psa
	 * @return Cislo popisne adresy majitele psa
	 */
	public int getUliceCisloPopisne() {
		return uliceCisloPopisne;
	}

	
	/**
	 * Nastavuje cislo popisne adresy majitele psa
	 * @param uliceCisloPopisne Cislo popisne adresy majitele psa
	 */
	public void setUliceCisloPopisne(int uliceCisloPopisne) {
		this.uliceCisloPopisne = uliceCisloPopisne;
	}

	/**
	 * Vraci cislo orientacni adresy majitele psa
	 * @return Cislo orientacni adresy majitele psa
	 */
	public int getUliceCisloOrientacni() {
		return uliceCisloOrientacni;
	}

	/**
	 * Nastavuje cislo popisne adresy majitele psa
	 * @param uliceCisloOrientacni Cislo orientacni adresy majitele psa
	 */
	public void setUliceCisloOrientacni(int uliceCisloOrientacni) {
		this.uliceCisloOrientacni = uliceCisloOrientacni;
	}

	/**
	 * Vytvori instanci z tridy majitele psa
	 * @param id Id majitele v databazi
	 * @param jmeno Jmeno majitele
	 * @param prijmeni Prijmeni majitele
	 * @param telefon Telefon majitel
	 * @param email Email majitele
	 * @param mesto Mesto z adresy majitele
	 * @param psc PSC z adresy majitele
	 * @param ulice Ulice z adresy majitele
	 * @param uliceCisloPopisne Cislo popisne z adresy majitele
	 * @param uliceCisloOrientacni Cislo orientacni z adresy majitele
	 */
	public Majitel(int id, String jmeno, String prijmeni, String telefon, String email, String mesto, String psc,
			String ulice, int uliceCisloPopisne, int uliceCisloOrientacni) {
		super(id, jmeno, prijmeni);
		this.telefon = telefon;
		this.email = email;
		this.mesto = mesto;
		this.psc = psc;
		this.ulice = ulice;
		this.uliceCisloPopisne = uliceCisloPopisne;
		this.uliceCisloOrientacni = uliceCisloOrientacni;
	}

	/**
	 * Vytvoreni instance majitele s defaultnimi hodnotami
	 */
	public Majitel() {
		super();
	}


	

}
