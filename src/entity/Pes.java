package entity;

import java.io.IOException;
import java.sql.SQLException;

import databaze.Databaze;

public class Pes {
	private int id;
	private String jmeno;
	private int idMajitel;
	private int idVahovaKategorie;
	public Pes(int id, String jmeno, int idMajitel, int idVahovaKategorie) {
		super();
		this.id = id;
		this.jmeno = jmeno;
		this.idMajitel = idMajitel;
		this.idVahovaKategorie = idVahovaKategorie;
	}
	public Pes() {
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
	public int getIdMajitel() {
		return idMajitel;
	}
	public void setIdMajitel(int idMajitel) {
		this.idMajitel = idMajitel;
	}
	public int getIdVahovaKategorie() {
		return idVahovaKategorie;
	}
	public void setIdVahovaKategorie(int idVahovaKategorie) {
		this.idVahovaKategorie = idVahovaKategorie;
	}
	
	public Majitel getMajitel() throws SQLException, IOException{
		return Databaze.getInstance().getMajitelPodleId(this.idMajitel);
	}
	
	public VahovaKategorie getVahovaKategorie() throws SQLException, IOException{
		return Databaze.getInstance().getVahovaKategoriePodleId(this.idVahovaKategorie);
	}

}
