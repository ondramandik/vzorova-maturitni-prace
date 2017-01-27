package entity;


/**
 * Trida pro uchovani informaci o osobe (id, jmeno, prijmeni).
 * Trida ocekava data podle README.md, neresi spravnost vstupnich dat.
 * @author Jana Spilkova spilkova@spsejecna.cz
 *
 */
public class Osoba {
	protected int id;
	protected String jmeno;
	protected String prijmeni;
	
	/**
	 * Vytvori instanci tridy Osoba
	 * @param id Id osoby v databazi
	 * @param jmeno Jmeno osoby
	 * @param prijmeni Prijmeni osoby
	 */
	public Osoba(int id, String jmeno, String prijmeni) {
		super();
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
	}
	
	/**
	 * Vytvori instanci tridy Osoba s defaultnimi hodnotami
	 * Id osoby v databazi = 0
	 * Jmeno osoby = null
	 * Prijmeni osoby = null
	 */
	public Osoba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Vraci id osoby podle databaze
	 * @return Id osoby podle databaze
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Nastavuje id osoby podle databaze
	 * @param id Id osoby v databazi
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vraci jmeno osoby
	 * @return Jmeno osoby
	 */
	public String getJmeno() {
		return jmeno;
	}
	
	/**
	 * Nastavuje jmeno osoby
	 * @param jmeno Jmeno osoby
	 */
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	
	/**
	 * Vraci prijmeni osoby
	 * @return Prijmeni osoby
	 */
	public String getPrijmeni() {
		return prijmeni;
	}
	
	/**
	 * Nastavuje prijmeni osoby
	 * @param prijmeni Prijmeni osoby
	 */
	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}
	
	/**
	 * Vrati spojen jmeno a prijimeni
	 * 
	 * @return Jmeno + mezera + Prijmeni
	 */
	public String getJmenoAPrijmeni() {
		return this.getJmeno() + " " + this.getPrijmeni();
	}
	
}
