package trasferObjects;

public class Recepcni extends Osoba{

	private String uzivatelskeJmeno;
	private String heslo;
	public Recepcni(int id, String jmeno, String prijmeni, String uzivatelskeJmeno, String heslo) {
		super(id, jmeno, prijmeni);

		this.uzivatelskeJmeno = uzivatelskeJmeno;
		this.heslo = heslo;
	}
	public Recepcni() {
		super();
		// TODO Auto-generated constructor stub
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
