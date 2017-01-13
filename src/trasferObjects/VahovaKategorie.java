package trasferObjects;

public class VahovaKategorie {
	private int id;
	private int vahaMin;
	private int vahaMax;
	private String nazev;
	public VahovaKategorie(int id, int vahaMin, int vahaMax, String nazev) {
		super();
		this.id = id;
		this.vahaMin = vahaMin;
		this.vahaMax = vahaMax;
		this.nazev = nazev;
	}
	public VahovaKategorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVahaMin() {
		return vahaMin;
	}
	public void setVahaMin(int vahaMin) {
		this.vahaMin = vahaMin;
	}
	public int getVahaMax() {
		return vahaMax;
	}
	public void setVahaMax(int vahaMax) {
		this.vahaMax = vahaMax;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	
	
}
