package trasferObjects;

import java.util.Date;

import databaze.DatabazeManager;

public class Ubytovani {
	private int id;
	private int idSluzba;
	private int idMajitel;
	private int idPes;
	private int idKotec;
	private int vytvorilIdRecepcni;
	private int prijalIdRecepcni;
	private int vydalIdRecepcni;
	private Date ubytovanOd;
	private Date ubytovanDo;
	public Ubytovani(int id, int idSluzba, int idMajitel, int idPes, int idKotec, int vytvorilIdRecepcni,
			int prijalIdRecepcni, int vydalIdRecepcni, Date ubytovanOd, Date ubytovanDo) {
		super();
		this.id = id;
		this.idSluzba = idSluzba;
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
	public int getIdSluzba() {
		return idSluzba;
	}
	public void setIdSluzba(int idSluzba) {
		this.idSluzba = idSluzba;
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
	
	public Sluzba getSluzba(){
		return DatabazeManager.getDatabaze().getUbytovaniSluzba(this);
	}
	
	public Majitel getMajitel(){
		return DatabazeManager.getDatabaze().getUbytovaniMajitel(this);
	}
	
	public Pes getPes(){
		return DatabazeManager.getDatabaze().getUbytovaniPes(this);
	}
	
	public Kotec getKotec(){
		return DatabazeManager.getDatabaze().getUbytovaniKotec(this);
	}
	
	public Recepcni getRecepcniPrijal(){
		return DatabazeManager.getDatabaze().getUbytovaniRecepcniPrijal(this);
	}

	public Recepcni getRecepcniVytvoril(){
		return DatabazeManager.getDatabaze().getUbytovaniRecepcniVytvoril(this);
	}

	public Recepcni getRecepcniVydal(){
		return DatabazeManager.getDatabaze().getUbytovaniRecepcniVydal(this);
	}	
}
