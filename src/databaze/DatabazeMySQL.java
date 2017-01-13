package databaze;

import java.sql.Connection;
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
 
	public DatabazeMySQL() throws SQLException {
		this.conn = DriverManager.getConnection("jdbc:mysql://"+DatabazeMySQL.HOST+"/"+DatabazeMySQL.DATABASE,DatabazeMySQL.USERNAME,DatabazeMySQL.PASSWORD);	
	}
	
	@Override
	public void saveKotec(Kotec k) throws SQLException {
		PreparedStatement stmt;
		if(k.getId() < 1) {
			stmt = this.conn.prepareStatement("INSERT INTO kotec (cislo,kapacita) VALUES (?,?);");
			stmt.setString(1,k.getCislo());
			stmt.setInt(2,k.getKapacita());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
				k.setId(rs.getInt(1));
			}
			rs.close();
			
		} else {
			stmt = this.conn.prepareStatement("UPDATE kotec SET cislo=?, kapacita=? WHERE id_kotec=?;");
			stmt.setString(1,k.getCislo());
			stmt.setInt(2,k.getKapacita());
			stmt.setInt(3,k.getId());
			stmt.execute();
		}
		
		stmt.close();
	}

	@Override
	public void removeKotec(Kotec k) throws SQLException {
		PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM kotec WHERE id_kotec=?;");
		stmt.setInt(1,k.getId());
		stmt.execute();
		stmt.close();
	}

	@Override
	public List<Kotec> getKotecVsechny() throws SQLException {
		ArrayList<Kotec> kotce = new ArrayList<Kotec>();
		
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id,cislo,kapacita FROM kotec ORDER BY cislo;");
		while(rs.next()) {
			int id = rs.getInt(1);
			String cislo = rs.getString(2);
			int kapacita = rs.getInt(3);
			Kotec k = new Kotec(id,cislo,kapacita);
			kotce.add(k);
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
	public int getKotecVolnaMista(Kotec k) throws SQLException {
		int x = -1;
		
		Statement stmt = this.conn.createStatement();
		
		//TODO
		ResultSet rs = stmt.executeQuery("SELECT SUM(kapacita) FROM kotec;");
		if(rs.next()) {
			x = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		return x;
	}

	@Override
	public void saveUbytovani(Ubytovani u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUbytovani(Ubytovani u) {
		// TODO Auto-generated method stub
		
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

}
