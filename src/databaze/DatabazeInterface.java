package databaze;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import trasferObjects.*;

public interface DatabazeInterface {
	
	public List<Kotec> getKotecVsechny() throws SQLException;
	
	public Kotec getKotecPodleId(int id) throws SQLException;

	public void saveUbytovani(Ubytovani u) throws SQLException;
	
	public void removeUbytovani(Ubytovani u) throws SQLException;
		
	public Ubytovani getUbytovaniPodleId(int id) throws SQLException;

	public List<Ubytovani> getUbytovaniPodleData(Date datum) throws SQLException;

	public Majitel getMajitelById(int idMajitel);

	public VahovaKategorie getVahovaKategorieById(int idVahovaKategorie);

	public Recepcni getRecepcni(String username, String heslo);

	public Sluzba getSluzbaById(int idSluzba);

	public Pes getPesById(int idPes);

	public Kotec getKotecById(int idKotec);

	public Recepcni getRecepcniById(int prijalIdRecepcni);
	
	
	
	
}
