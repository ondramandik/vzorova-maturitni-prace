package trasferObjects;

public class Majitel extends Osoba{
	private String telefon;
	private String email;
	private String mesto;
	private String psc;
	private String ulice;
	private int uliceCisloPopisne;
	private int uliceCisloOrientacni;

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
		// TODO Auto-generated constructor stub
	}


	

}
