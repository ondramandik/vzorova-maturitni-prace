package entity;

public class Osoba {
	protected int id;
	protected String jmeno;
	protected String prijmeni;
	public Osoba(int id, String jmeno, String prijmeni) {
		super();
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
	}
	public Osoba() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJmeno() {
		return jmeno;
	}
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	public String getPrijmeni() {
		return prijmeni;
	}
	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}
	
}
