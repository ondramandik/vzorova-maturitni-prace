package entity;

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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPsc() {
		return psc;
	}

	public void setPsc(String psc) {
		this.psc = psc;
	}

	public String getUlice() {
		return ulice;
	}

	public void setUlice(String ulice) {
		this.ulice = ulice;
	}

	public int getUliceCisloPopisne() {
		return uliceCisloPopisne;
	}

	public void setUliceCisloPopisne(int uliceCisloPopisne) {
		this.uliceCisloPopisne = uliceCisloPopisne;
	}

	public int getUliceCisloOrientacni() {
		return uliceCisloOrientacni;
	}

	public void setUliceCisloOrientacni(int uliceCisloOrientacni) {
		this.uliceCisloOrientacni = uliceCisloOrientacni;
	}

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

	public Majitel() {
		super();
	}


	

}
