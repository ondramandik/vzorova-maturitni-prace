package trasferObjects;

public class Recepcni {
	private int id;
	private String jmeno;
	private String prijmeni;
	private String uzivatelskeJmeno;
	private String heslo;
	public Recepcni(int id, String jmeno, String prijmeni, String uzivatelskeJmeno, String heslo) {
		super();
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.uzivatelskeJmeno = uzivatelskeJmeno;
		this.heslo = heslo;
	}
	public Recepcni() {
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
	public String getUzivatelskeJmeno() {
		return uzivatelskeJmeno;
	}
	public void setUzivatelskeJmeno(String uzivatelskeJmeno) {
		this.uzivatelskeJmeno = uzivatelskeJmeno;
	}
	public String getHeslo() {
		return heslo;
	}
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
	

}
