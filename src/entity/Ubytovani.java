package entity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import databaze.Databaze;

public class Ubytovani {
	private int id;
	private int idMajitel;
	private int idPes;
	private int idKotec;
	private int vytvorilIdRecepcni;
	private int prijalIdRecepcni;
	private int vydalIdRecepcni;
	private Date ubytovanOd;
	private Date ubytovanDo;
	public Ubytovani(int id, int idMajitel, int idPes, int idKotec, int vytvorilIdRecepcni,
			int prijalIdRecepcni, int vydalIdRecepcni, Date ubytovanOd, Date ubytovanDo) {
		super();
		this.id = id;
		this.idMajitel = idMajitel;
		this.idPes = idPes;
		this.idKotec = idKotec;
		this.vytvorilIdRecepcni = vytvorilIdRecepcni;
		this.prijalIdRecepcni = prijalIdRecepcni;
		this.vydalIdRecepcni = vydalIdRecepcni;
		this.ubytovanOd = ubytovanOd;
		this.ubytovanDo = ubytovanDo;
	}
	public Ubytovani() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdMajitel() {
		return idMajitel;
	}
	public void setIdMajitel(int idMajitel) {
		this.idMajitel = idMajitel;
	}
	public int getIdPes() {
		return idPes;
	}
	public void setIdPes(int idPes) {
		this.idPes = idPes;
	}
	public int getIdKotec() {
		return idKotec;
	}
	public void setIdKotec(int idKotec) {
		this.idKotec = idKotec;
	}
	public int getVytvorilIdRecepcni() {
		return vytvorilIdRecepcni;
	}
	public void setVytvorilIdRecepcni(int vytvorilIdRecepcni) {
		this.vytvorilIdRecepcni = vytvorilIdRecepcni;
	}
	public int getPrijalIdRecepcni() {
		return prijalIdRecepcni;
	}
	public void setPrijalIdRecepcni(int prijalIdRecepcni) {
		this.prijalIdRecepcni = prijalIdRecepcni;
	}
	public int getVydalIdRecepcni() {
		return vydalIdRecepcni;
	}
	public void setVydalIdRecepcni(int vydalIdRecepcni) {
		this.vydalIdRecepcni = vydalIdRecepcni;
	}
	public Date getUbytovanOd() {
		return ubytovanOd;
	}
	public void setUbytovanOd(Date ubytovanOd) {
		this.ubytovanOd = ubytovanOd;
	}
	public Date getUbytovanDo() {
		return ubytovanDo;
	}
	public void setUbytovanDo(Date ubytovanDo) {
		this.ubytovanDo = ubytovanDo;
	}
	public Majitel getMajitel() throws SQLException, IOException{
		return Databaze.getInstance().getMajitelPodleId(this.idMajitel);
	}
	
	public Pes getPes() throws SQLException, IOException{
		return Databaze.getInstance().getPesPodleId(this.idPes);
	}
	
	public Kotec getKotec() throws SQLException, IOException{
		return Databaze.getInstance().getKotecPodleId(this.idKotec);
	}
	
	public Recepcni getRecepcniPrijal() throws SQLException, IOException{
		return Databaze.getInstance().getRecepcniPodleId(this.prijalIdRecepcni);
	}

	public Recepcni getRecepcniVytvoril() throws SQLException, IOException{
		return Databaze.getInstance().getRecepcniPodleId(this.vytvorilIdRecepcni);
	}

	public Recepcni getRecepcniVydal() throws SQLException, IOException{
		return Databaze.getInstance().getRecepcniPodleId(this.vydalIdRecepcni);
	}	
}
