package TrasferObjects;

import Databaze.DatabazeManager;

public class Kotec {
	private int id;
	private String cislo;
	private int kapacita;
	
	
	public Kotec() {
		super();
	}
	public Kotec(int id, String cislo, int kapacita) {
		super();
		this.id = id;
		this.cislo = cislo;
		this.kapacita = kapacita;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCislo() {
		return cislo;
	}
	public void setCislo(String cislo) {
		this.cislo = cislo;
	}
	public int getKapacita() {
		return kapacita;
	}
	public void setKapacita(int kapacita) {
		this.kapacita = kapacita;
	}
		
	public int getVolnaMista(){
		
		return DatabazeManager.getDatabaze().getVolnaMista(this);
	}
	
	
}
