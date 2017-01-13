package trasferObjects;

public class Sluzba {
	private int id;
	private String nazev;
	private String popis;
	private int cenaZaNoc;
	
	public Sluzba() {
		super();
	}
	
	public Sluzba(int id, String nazev, String popis, int cenaZaNoc) {
		super();
		this.id = id;
		this.nazev = nazev;
		this.popis = popis;
		this.cenaZaNoc = cenaZaNoc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazev() {
		return nazev;
	}
	@Override
	public String toString() {
		return "Sluzba [id=" + id + ", nazev=" + nazev + ", popis=" + popis + ", cenaZaNoc=" + cenaZaNoc + "]";
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public String getPopis() {
		return popis;
	}
	public void setPopis(String popis) {
		this.popis = popis;
	}
	public int getCenaZaNoc() {
		return cenaZaNoc;
	}
	public void setCenaZaNoc(int cenaZaNoc) {
		this.cenaZaNoc = cenaZaNoc;
	}
}
