package databaze;

import java.sql.SQLException;
import java.util.List;

import trasferObjects.*;

public interface DatabazeInterface {
	
	public List<Kotec> getKotecVsechny() throws SQLException;
	
	public Kotec getKotecPodleId(int id) throws SQLException;
	
	public int getKotecVolnaMista(Kotec k) throws SQLException;
		
	
	public void saveUbytovani(Ubytovani u) throws SQLException;
	
	public void removeUbytovani(Ubytovani u) throws SQLException;
		
	public Ubytovani getUbytovaniPodleId(int id) throws SQLException;

	public VahovaKategorie getPesVahovaKategorie(Pes pes) throws SQLException;
	
	public Majitel getPesMajitel(Pes pes) throws SQLException;
	
	public Majitel getUbytovaniMajitel(Ubytovani ubytovani) throws SQLException;

	public Sluzba getUbytovaniSluzba(Ubytovani ubytovani) throws SQLException;

	public Pes getUbytovaniPes(Ubytovani ubytovani) throws SQLException;

	public Kotec getUbytovaniKotec(Ubytovani ubytovani) throws SQLException;

	public Recepcni getUbytovaniRecepcniPrijal(Ubytovani ubytovani) throws SQLException;

	public Recepcni getUbytovaniRecepcniVydal(Ubytovani ubytovani) throws SQLException;

	public Recepcni getUbytovaniRecepcniVytvoril(Ubytovani ubytovani) throws SQLException;


	
}
