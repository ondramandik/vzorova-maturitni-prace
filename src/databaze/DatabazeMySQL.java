package databaze;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaze.DatabazeInterface;
import entity.*;

/**
 * Třída dle DatabazeInterface, která reprezentuje databázi v MySQL Serveru.
 * 
 * @see DatabazeInterface
 * @author Ondra Mandik <mandik@spsejecna.cz>
 */
public class DatabazeMySQL  implements DatabazeInterface{

	/**
	 * URL pro pripojeni do databaze
	 */
	private String connectionString;
	
	/**
	 * Uzivatelske jmeno
	 */
	private String username;
	
	/**
	 * Heslo
	 */
	private String password;
	
	/**
	 * Aktualni spojeni do databaze, nebo null kdyz trida pripojena neni
	 */
	private Connection conn = null;
 
	/**
	 * Metoda, ktera konvertuje java.util.Date na java.sql.Date
	 * 
	 * @param sourceDate Datum ve formatu java.util.date
	 * @return Datum ve formatu SQL
	 */
	protected java.sql.Date konvertujDatum(java.util.Date sourceDate) {
		return new java.sql.Date(sourceDate.getTime());
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy Kotec
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Kotec reprezentujici radek v resultSetu
	 * @throws SQLException
	 */
	private Kotec buildKotec(ResultSet rs) throws SQLException {
		int id = rs.getInt("id_kotec");
		String cislo = rs.getString("cislo");
		int kapacita = rs.getInt("kapacita");
		return new Kotec(id,cislo,kapacita);
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy Ubytovani
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Instance dle aktualniho radku
	 * @throws SQLException
	 */
	private Ubytovani buildUbytovani(ResultSet rs) throws SQLException {
		Ubytovani u = new Ubytovani();
		u.setId(rs.getInt("id_ubytovani"));
		u.setIdKotec(rs.getInt("id_kotec"));
		u.setIdMajitel(rs.getInt("id_majitel"));
		u.setIdSluzba(rs.getInt("id_sluzba"));
		u.setIdPes(rs.getInt("id_pes"));
		u.setPrijalIdRecepcni(rs.getInt("prijal_id_recepcni"));
		u.setVydalIdRecepcni(rs.getInt("vydal_id_recepcni"));
		u.setVytvorilIdRecepcni(rs.getInt("vytvoril_id_recepcni"));
		u.setUbytovanDo(rs.getDate("do"));
		u.setUbytovanOd(rs.getDate("od"));
		return u;
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy Majitel
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Instance Ubytovani dle aktualniho radku
	 * @throws SQLException
	 */
	private Majitel buildMajitel(ResultSet rs) throws SQLException {
		Majitel majitel = new Majitel();
		majitel.setId(rs.getInt("id_majitel"));
		majitel.setEmail(rs.getString("email"));
		majitel.setTelefon(rs.getString("tel"));
		majitel.setJmeno(rs.getString("jmeno"));
		majitel.setPrijmeni(rs.getString("prijmeni"));
		majitel.setMesto(rs.getString("mesto"));
		majitel.setPsc(rs.getString("psc"));
		majitel.setUlice(rs.getString("ulice"));
		majitel.setUliceCisloOrientacni(rs.getInt("ulice_cislo_orientacni"));
		majitel.setUliceCisloPopisne(rs.getInt("ulice_cislo_popisne"));
		return majitel;
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy Recepcni
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Instance dle aktualniho radku
	 * @throws SQLException
	 */
	private Recepcni buildRecepcni(ResultSet rs) throws SQLException {
		Recepcni recepcni = new Recepcni();
		recepcni.setId(rs.getInt("id_recepcni"));
		recepcni.setJmeno(rs.getString("jmeno"));
		recepcni.setPrijmeni(rs.getString("prijmeni"));
		recepcni.setUzivatelskeJmeno(rs.getString("uzivatelske_jmeno"));
		return recepcni;
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy VahovaKategorie
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Instance dle aktualniho radku
	 * @throws SQLException
	 */
	private VahovaKategorie buildVahovaKategorie(ResultSet rs) throws SQLException {
		VahovaKategorie vahovaKategorie = new VahovaKategorie();
		vahovaKategorie.setId(rs.getInt("id_vahova_kategorie"));
		vahovaKategorie.setNazev(rs.getString("nazev"));
		vahovaKategorie.setVahaMax(rs.getInt("vaha_max"));
		vahovaKategorie.setVahaMin(rs.getInt("vaha_min"));
		return vahovaKategorie;
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy Pes
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Instance dle aktualniho radku
	 * @throws SQLException
	 */
	private Pes buildPes(ResultSet rs) throws SQLException {
		Pes pes = new Pes();
		pes.setId(rs.getInt("id_pes"));
		pes.setJmeno(rs.getString("jmeno"));
		pes.setIdMajitel(rs.getInt("id_majitel"));
		pes.setIdVahovaKategorie(rs.getInt("id_vahova_kategorie"));
		return pes;
	}
	
	/**
	 * Metoda ktera z aktaulniho radku resultSetu vytvori instanci tridy Sluzba
	 * 
	 * @param rs resultSet nastaveny na konkretni radek
	 * @return Instance dle aktualniho radku
	 * @throws SQLException
	 */
	private Sluzba buildSluzba(ResultSet rs) throws SQLException {
		int id = rs.getInt("id_sluzba");
		String nazev = rs.getString("nazev");
		String popis = rs.getString("popis");
		double cenaZaNoc = rs.getInt("cena_za_noc");
		return new Sluzba(id,nazev,popis,(int)cenaZaNoc);
	}	
	
	public DatabazeMySQL(String host, String port, String db, String user, String pass) throws SQLException, IOException {
		this.connectionString = "jdbc:mysql://"+host+"/"+db;
		this.username = user;
		this.password = pass;	
	}

	@Override
	public void pripojit() throws SQLException {
		if(this.conn == null) {
			this.conn = DriverManager.getConnection(connectionString, username, password);	
		}
	}

	@Override
	public void odpojit() throws SQLException {
		if(this.conn != null) {
			this.conn.close();
		}
	}	

	@Override
	public List<Kotec> getKotecVsechny() throws SQLException {
		ArrayList<Kotec> kotce = new ArrayList<Kotec>();
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id_kotec,cislo,kapacita FROM kotec ORDER BY cislo");
		while(rs.next()) {
			kotce.add(this.buildKotec(rs));
		}
		rs.close();
		stmt.close();
		return kotce;
	}

	@Override
	public Kotec getKotecPodleId(int id) throws SQLException {
		Kotec k = null;
		PreparedStatement stmt = this.conn.prepareStatement("SELECT cislo, kapacita FROM kotec WHERE cislo=?");
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			String cislo = rs.getString(1);
			int kapacita = rs.getInt(2);
			k = new Kotec(id,cislo,kapacita);
		}
		rs.close();
		
		stmt.close();
		return k;
	}

	

	@Override
	public void saveUbytovani(Ubytovani u) throws SQLException {
		PreparedStatement stmt;
		if(u.getId() < 1) {
			stmt = this.conn.prepareStatement(
				"INSERT INTO ubytovani "
				+ "(id_sluzba,id_majitel,id_pes,id_kotec,vytvoril_id_recepcni,prijal_id_recepcni,vydal_id_recepcni,od,do) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)"
				,Statement.RETURN_GENERATED_KEYS
			);
			stmt.setInt(1,u.getIdSluzba());
			stmt.setInt(2,u.getIdMajitel());
			stmt.setInt(3,u.getIdPes());
			stmt.setInt(4,u.getIdKotec());
			stmt.setInt(5,u.getVytvorilIdRecepcni());
			stmt.setInt(6,u.getPrijalIdRecepcni());
			stmt.setInt(7,u.getVydalIdRecepcni());
			stmt.setDate(8,this.konvertujDatum(u.getUbytovanOd()));
			stmt.setDate(9,this.konvertujDatum(u.getUbytovanDo()));
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				u.setId(rs.getInt(1));
			}
			rs.close();
			
		} else {
			stmt = this.conn.prepareStatement(
				"UPDATE ubytovani SET"
				+ "id_sluzba=?,id_majitel=?,id_pes=?,id_kotec=?,vytvoril_id_recepcni=?,prijal_id_recepcni=?,vydal_id_recepcni=?,od=?,do=?) "
				+ "WHERE id_ubytovani=?"
			);
			stmt.setInt(1,u.getIdSluzba());
			stmt.setInt(2,u.getIdMajitel());
			stmt.setInt(3,u.getIdPes());
			stmt.setInt(4,u.getIdKotec());
			stmt.setInt(5,u.getVytvorilIdRecepcni());
			stmt.setInt(6,u.getPrijalIdRecepcni());
			stmt.setInt(7,u.getVydalIdRecepcni());
			stmt.setDate(8,new java.sql.Date(u.getUbytovanOd().getTime()));
			stmt.setDate(9,new java.sql.Date(u.getUbytovanDo().getTime()));
			stmt.setInt(10,u.getId());
			stmt.execute();
		}
		
		stmt.close();
	}

	@Override
	public void removeUbytovani(Ubytovani u) throws SQLException {
		PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM ubytovani WHERE id_ubytovani=?");
		stmt.setInt(1,u.getId());
		stmt.execute();
		stmt.close();
	}

	@Override
	public Ubytovani getUbytovaniPodleId(int id) throws SQLException {
		Ubytovani u = null;
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM ubytovani WHERE id_ubytovani=?");
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			u = this.buildUbytovani(rs);
		}
		rs.close();
		
		stmt.close();
		return u;
	}


	@Override
	public void saveMajitel(Majitel m) throws SQLException {
		PreparedStatement stmt;
		if(m.getId() < 1) {
			stmt = this.conn.prepareStatement(
				"INSERT INTO majitel "
				+ "(jmeno,prijmeni,tel,email,mesto,psc,ulice,ulice_cislo_popisne,ulice_cislo_orientacni) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)"
				,Statement.RETURN_GENERATED_KEYS
			);
			stmt.setString(1,m.getJmeno());
			stmt.setString(2,m.getPrijmeni());
			stmt.setString(3,m.getTelefon());
			stmt.setString(4,m.getEmail());
			stmt.setString(5,m.getMesto());
			stmt.setString(6,m.getPsc());
			stmt.setString(7,m.getUlice());
			stmt.setInt(8,m.getUliceCisloPopisne());
			stmt.setInt(9,m.getUliceCisloOrientacni());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				m.setId(rs.getInt(1));
			}
			rs.close();
			
		} else {
			stmt = this.conn.prepareStatement(
				"UPDATE ubytovani SET"
				+ "jmeno=?,prijmeni=?,tel=?,email=?,mesto=?,psc=?,ulice=?,ulice_cislo_popisne=?,ulice_cislo_orientacni=?) "
				+ "WHERE id_ubytovani=?"
			);
			stmt.setString(1,m.getJmeno());
			stmt.setString(2,m.getPrijmeni());
			stmt.setString(3,m.getTelefon());
			stmt.setString(4,m.getEmail());
			stmt.setString(5,m.getMesto());
			stmt.setString(6,m.getPsc());
			stmt.setString(7,m.getUlice());
			stmt.setInt(8,m.getUliceCisloPopisne());
			stmt.setInt(9,m.getUliceCisloOrientacni());
			stmt.setInt(10,m.getId());
			stmt.execute();
		}
		stmt.close();
	}

	@Override
	public void removeMajitel(Majitel m) throws SQLException {
		PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM majitel WHERE id_majitel=?");
		stmt.setInt(1,m.getId());
		stmt.execute();
		stmt.close();
	}
	
	@Override
	public List<Majitel> getMajitelVsechny() throws SQLException {
		ArrayList<Majitel> majitele = new ArrayList<Majitel>();
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM majitel ORDER BY prijmeni");
		while(rs.next()) {
			majitele.add(this.buildMajitel(rs));
		}
		rs.close();
		stmt.close();
		return majitele;
	}
	
	@Override
	public Majitel getMajitelPodleId(int id) throws SQLException {
		Majitel majitel = null;
		
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM majitel WHERE id_majitel=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			majitel =  this.buildMajitel(rs);
		}
		rs.close();
		stmt.close();
		
		return majitel;		
	}
	
	@Override
	public Recepcni getRecepcniPodlePristupovychUdaju(String uzivatelskeJmeno, String heslo) throws SQLException{
		Recepcni r = null;
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM recepcni WHERE uzivatelske_jmeno=? and heslo=?");
		stmt.setString(1, uzivatelskeJmeno.toLowerCase());
		stmt.setString(2, heslo);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			r = this.buildRecepcni(rs);
		}
		rs.close();
		
		stmt.close();
		return r;
	}


	@Override
	public Recepcni getRecepcniPodleId(int id) throws SQLException {
		Recepcni r = null;
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM recepcni WHERE id_recepcni=?");
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			r = this.buildRecepcni(rs);
		}
		rs.close();
		
		stmt.close();
		return r;
	}
	

	@Override
	public List<Ubytovani> getUbytovaniPodleData(java.util.Date datum) throws SQLException {
		ArrayList<Ubytovani> ubytovani = new ArrayList<Ubytovani>();
		
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM ubytovani WHERE od>=? and do<=? ORDER BY od");
		stmt.setDate(1, this.konvertujDatum(datum));
		stmt.setDate(2, this.konvertujDatum(datum));
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			ubytovani.add(this.buildUbytovani(rs));
		}
		rs.close();
		stmt.close();
		
		return ubytovani;		
	}

	@Override
	public void savePes(Pes p) throws SQLException {
		PreparedStatement stmt;
		if(p.getId() < 1) {
			stmt = this.conn.prepareStatement(
				"INSERT INTO pes (jmeno, id_majitel, id_vahova_kategorie) VALUES (?,?,?)"
				,Statement.RETURN_GENERATED_KEYS
			);
			stmt.setString(1,p.getJmeno());
			stmt.setInt(2,p.getIdMajitel());
			stmt.setInt(3,p.getIdVahovaKategorie());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				p.setId(rs.getInt(1));
			}
			rs.close();
			
		} else {
			stmt = this.conn.prepareStatement("UPDATE pes SET jmeno=?, id_majitel=?, id_vahova_kategorie=? WHERE id_pes=?");
			stmt.setString(1,p.getJmeno());
			stmt.setInt(2,p.getIdMajitel());
			stmt.setInt(3,p.getIdVahovaKategorie());
			stmt.setInt(4,p.getId());
			stmt.execute();
		}
		stmt.close();
	}

	@Override
	public void removePes(Pes p) throws SQLException {
		PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM pes WHERE id_pes=?");
		stmt.setInt(1,p.getId());
		stmt.execute();
		stmt.close();
	}

	@Override
	public Pes getPesPodleId(int id) throws SQLException {
		Pes pes = null;
		
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM pes WHERE id_pes=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			pes =  this.buildPes(rs);
		}
		rs.close();
		stmt.close();
		
		return pes;		
	}

	@Override
	public VahovaKategorie getVahovaKategoriePodleId(int id) throws SQLException {
		VahovaKategorie vahovaKategorie = null;
		
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM vahova_kategorie WHERE id_vahova_kategorie=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			vahovaKategorie =  this.buildVahovaKategorie(rs);
		}
		rs.close();
		stmt.close();
		
		return vahovaKategorie;		
	}

	
	
	@Override
	public Sluzba getSluzbaPodleId(int id) throws SQLException {
		
		Sluzba sluzba = null;
		
		PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM sluzba WHERE id_sluzba=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			sluzba =  this.buildSluzba(rs);
		}
		rs.close();
		stmt.close();
		
		return sluzba;	
	}

	
}