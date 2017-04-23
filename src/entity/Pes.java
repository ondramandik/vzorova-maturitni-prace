package entity;

import java.io.IOException;
import java.sql.SQLException;

import databaze.Databaze;
import vyjimky.KonfigurakException;

/**
 * Trida pro uchovavani informacich o psovi
 * @author Jana Spilkova spilkova@spsejecna.cz
 *
 */
public class Pes {
	private int id;
	private String jmeno;
	private int idMajitel;
	
	/**
	 * Vytvori instanci tridy pes
	 * @param id Id psa v databazi
	 * @param jmeno Jmeno psa
	 * @param idMajitel Id majitele psa v databazi
	 */
	public Pes(int id, String jmeno, int idMajitel) {
		super();
		this.id = id;
		this.jmeno = jmeno;
		this.idMajitel = idMajitel;
	}
	
	/**
	 * Vytvori instanci tridy Pes s defaultnimi hodnotami
	 */
	public Pes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Vraci id psa v databazi
	 * @return Id psa v databazi
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Nastavuje id psa
	 * @param id Id psa
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vraci jmeno psa
	 * @return Jmeno psa
	 */
	public String getJmeno() {
		return jmeno;
	}
	
	/**
	 * Nastavuje jmeno psa
	 * @param jmeno Jmeno psa
	 */
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	
	/**
	 * Vraci id majitele v databazi
	 * @return Id majitele psa
	 */
	public int getIdMajitel() {
		return idMajitel;
	}
	
	/**
	 * Nastavuje psovi id majitele
	 * @param idMajitel Id majitele psa
	 */
	public void setIdMajitel(int idMajitel) {
		this.idMajitel = idMajitel;
	}

	/**
	 * Vraci instanci majitele psa
	 * @return Majitel psa
	 * @throws SQLException Chyba s dotazem do databaze
	 * @throws IOException Jina chyba
	 */
	public Majitel getMajitel() throws SQLException, KonfigurakException{
		return Databaze.getInstance().getMajitelPodleId(this.idMajitel);
	}

}
