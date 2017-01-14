package entity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import databaze.Databaze;

public class Kotec {
	private int id;
	private String cislo;
	private int kapacita;
	
	public static List<Kotec> getVsechnyKotce() throws SQLException, IOException {
		return Databaze.getInstance().getKotecVsechny();
	}
	
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
}
