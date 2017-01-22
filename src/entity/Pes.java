package entity;

import java.io.IOException;
import java.sql.SQLException;

import databaze.Databaze;

public class Pes {
	private int id;
	private String jmeno;
	private int idMajitel;
	public Pes(int id, String jmeno, int idMajitel) {
		super();
		this.id = id;
		this.jmeno = jmeno;
		this.idMajitel = idMajitel;
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

	
	public Majitel getMajitel() throws SQLException, IOException{
		return Databaze.getInstance().getMajitelPodleId(this.idMajitel);
	}

}
