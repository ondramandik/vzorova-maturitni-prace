package entity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import databaze.Databaze;


/**
 * Trida pro ubytovani psu do kotce
 * @author Jana Spilkova spilkova@spsejecna.cz
 *
 */
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
	
	/**
	 * Vytvati instanci tridy Ubytovani
	 * @param id Id ubytovani v databazi
	 * @param idMajitel Id majitele psa v databazi
 	 * @param idPes Id psa v databazi
 	 * @param idKotec Id kotce, ve kterem je pes ubytovan
	 * @param vytvorilIdRecepcni Id recepcniho, ktery vytvoril objednavku
	 * @param prijalIdRecepcni Id recepcniho, ktery psa ubytoval
	 * @param vydalIdRecepcni Id recepniho, ktery psa vratil majiteli
	 * @param ubytovanOd Datum, od kdy je pes ubytovan
	 * @param ubytovanDo Datum, do kdy je pes ubytovan
	 */
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
	
	/**
	 * Vytvoreni instance tridy Ubytovani s defaultnimi hodnotami
	 */
	public Ubytovani() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Vraci id ubytovani
	 * @return Id ubytovani
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Nastavuje id ubytovani
	 * @param id Id ubytovani
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vraci id majitele psa
	 * @return Id majitele psa
	 */
	public int getIdMajitel() {
		return idMajitel;
	}
	
	/**
	 * Nastavuje id majitele psa
	 * @param idMajitel Id majitele psa
	 */
	public void setIdMajitel(int idMajitel) {
		this.idMajitel = idMajitel;
	}
	
	/**
	 * Vraci id psa
	 * @return Id psa v databazi
	 */
	public int getIdPes() {
		return idPes;
	}
	
	/**
	 * Nastavuje id psa
	 * @param idPes Id psa
	 */
	public void setIdPes(int idPes) {
		this.idPes = idPes;
	}
	
	/**
	 * Vraci id kotce, ve kterem je pes ubytovan
	 * @return Id kotce
	 */
	public int getIdKotec() {
		return idKotec;
	}
	
	/**
	 * Nastavuje id kotce, ve kterem bude pes ubytovan
	 * @param idKotec Id kotce, ve kterem je pes ubytovan
	 */
	public void setIdKotec(int idKotec) {
		this.idKotec = idKotec;
	}
	
	/**
	 * Vraci id recepcniho, ktery vytvoril objednavku
	 * @return Id recepsniho, ktery vytvoril objednavku
	 */
	public int getVytvorilIdRecepcni() {
		return vytvorilIdRecepcni;
	}
	
	/**
	 * Nastavuje id recepcniho, ktery vytvoril objednavku ubytovani
	 * @param vytvorilIdRecepcni Id recepcniho, ktery vytvoril objednavku ubytovani
	 */
	public void setVytvorilIdRecepcni(int vytvorilIdRecepcni) {
		this.vytvorilIdRecepcni = vytvorilIdRecepcni;
	}
	
	/**
	 * Vraci id recepcniho, ktery prijal psa k ubytovani
	 * @return Id recepsniho, ktery prijal psa k ubytovani
	 */	
	public int getPrijalIdRecepcni() {
		return prijalIdRecepcni;
	}

	/**
	 * Nastavuje id recepcniho, ktery prijal psa k ubytovani
	 * @param prijalIdRecepcni Id recepcniho, ktery prijal psa k ubytovani
	 */
	public void setPrijalIdRecepcni(int prijalIdRecepcni) {
		this.prijalIdRecepcni = prijalIdRecepcni;
	}
	
	/**
	 * Vraci id recepcniho, ktery vydal psa majiteli
	 * @return Id recepcniho, ktery vydal psa majiteli
	 */	
	public int getVydalIdRecepcni() {
		return vydalIdRecepcni;
	}
	
	/**
	 * Nastavuje id recepcniho, ktery vratil psa majiteli
	 * @param vydalIdRecepcni Id recepcniho, ktery vratil psa majiteli
	 */	
	public void setVydalIdRecepcni(int vydalIdRecepcni) {
		this.vydalIdRecepcni = vydalIdRecepcni;
	}
	
	/**
	 * Vraci datum, od kdy je pes ubytovan
	 * @return Datum, od kdy je pes ubytovan
	 */
	public Date getUbytovanOd() {
		return ubytovanOd;
	}
	
	/**
	 * Nastavuje datum, od kdy je pes ubytovan
	 * @param ubytovanOd Nastavuje datum, od kdy je pes ubytovan
	 */
	public void setUbytovanOd(Date ubytovanOd) {
		this.ubytovanOd = ubytovanOd;
	}
	
	/**
	 * Vraci datum, do kdy je pes ubytovan
	 * @return Datum, do kdy je pes ubytovan
	 */
	public Date getUbytovanDo() {
		return ubytovanDo;
	}
	
	/**
	 * Nastavuje datum, do kdy je pes ubytovan
	 * @param ubytovanDo Nastavuje datum, do kdy je pes ubytovan
	 */	
	public void setUbytovanDo(Date ubytovanDo) {
		this.ubytovanDo = ubytovanDo;
	}
	
	/**
	 * Vraci instanci majitele ubytovaneho psa
	 * @return Majitel ubytovaneho psa
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Majitel getMajitel() throws SQLException, IOException{
		return Databaze.getInstance().getMajitelPodleId(this.idMajitel);
	}
	
	/**
	 * Vraci instanci ubytovaneho psa
	 * @return Ubytovany pes
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Pes getPes() throws SQLException, IOException{
		return Databaze.getInstance().getPesPodleId(this.idPes);
	}
	
	/**
	 * Vraci instanci kotce, vekterem je pes ubytovan
	 * @return Kotec, ve kterem je pes ubytovan 
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Kotec getKotec() throws SQLException, IOException{
		return Databaze.getInstance().getKotecPodleId(this.idKotec);
	}
	
	/**
	 * Vraci instanci recepcniho, ktery vytvoril prijal psa k ubytovani
	 * @return Recepcni, ktery prijal psa od majitele
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Recepcni getRecepcniPrijal() throws SQLException, IOException{
		return Databaze.getInstance().getRecepcniPodleId(this.prijalIdRecepcni);
	}

	/**
	 * Vraci instanci recepcniho, ktery vytvoril objednavku na ubytovani
	 * @return Recepcni, ktery vytvoril objednavku
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Recepcni getRecepcniVytvoril() throws SQLException, IOException{
		return Databaze.getInstance().getRecepcniPodleId(this.vytvorilIdRecepcni);
	}

	/**
	 * Vraci instanci recepcniho, ktery predal psa zpet majiteli
	 * @return Recepcni, ktery predal psa majiteli
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Recepcni getRecepcniVydal() throws SQLException, IOException{
		return Databaze.getInstance().getRecepcniPodleId(this.vydalIdRecepcni);
	}	
}
