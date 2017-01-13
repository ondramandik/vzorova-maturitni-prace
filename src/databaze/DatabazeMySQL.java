package databaze;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import databaze.DatabazeInterface;
import trasferObjects.*;

public class DatabazeMySQL implements DatabazeInterface{
	
	public static String HOST = "193.85.203.188";
	
	public static String DATABASE = "vzorova_maturitni_prace";
	
	public static int PORT = 3306;
	
	public static String USERNAME = "vmp";
	
	public static String PASSWORD = "test";
	
	private Connection conn = null;
 
	private Kotec buildKotec(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String cislo = rs.getString(2);
		int kapacita = rs.getInt(3);
		return new Kotec(id,cislo,kapacita);
	}
	
	public DatabazeMySQL() throws SQLException {
		this.conn = DriverManager.getConnection("jdbc:mysql://"+DatabazeMySQL.HOST+"/"+DatabazeMySQL.DATABASE,DatabazeMySQL.USERNAME,DatabazeMySQL.PASSWORD);	
	}


	@Override
	public List<Kotec> getKotecVsechny() throws SQLException {
		ArrayList<Kotec> kotce = new ArrayList<Kotec>();
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id_kotec,cislo,kapacita FROM kotec ORDER BY cislo;");
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
		
		PreparedStatement stmt = this.conn.prepareStatement("SELECT cislo, kapacita FROM kotec WHERE cislo=?;");
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
	public int getVolneKotce(Kotec k) throws SQLException {
		//TODO
		int x = -1;
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT SUM(kapacita) FROM kotec;");
		if(rs.next()) {
			x = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		return x;
	}

	@Override
	public void saveUbytovani(Ubytovani u) throws SQLException {
		PreparedStatement stmt;
		if(u.getId() < 1) {
			stmt = this.conn.prepareStatement(
				"INSERT INTO ubytovani "
				+ "(id_sluzba,id_majitel,id_pes,id_kotec,vytvoril_id_recepcni,prijal_id_recepcni,vydal_id_recepcni,od,do) "
				+ "VALUES (?,?,?,?,?,?,?,?,?);"
				,Statement.RETURN_GENERATED_KEYS
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
				+ "WHERE id_ubytovani=?;"
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
		PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM ubytovani WHERE id_ubytovani=?;");
		stmt.setInt(1,u.getId());
		stmt.execute();
		stmt.close();
	}

	@Override
	public Ubytovani getUbytovaniPodleId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VahovaKategorie getPesVahovaKategorie(Pes pes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Majitel getPesMajitel(Pes pes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Majitel getUbytovaniMajitel(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sluzba getUbytovaniSluzba(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pes getUbytovaniPes(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kotec getUbytovaniKotec(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recepcni getUbytovaniRecepcniPrijal(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recepcni getUbytovaniRecepcniVydal(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recepcni getUbytovaniRecepcniVytvoril(Ubytovani ubytovani) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Recepcni getRecepcni(String username, String heslo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getKotecVolnaMista(Kotec k) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
