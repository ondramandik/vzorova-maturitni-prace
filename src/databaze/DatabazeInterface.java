package databaze;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import entity.*;

public interface DatabazeInterface {
	
	public void pripojit() throws SQLException;
	
	public void odpojit() throws SQLException;
	
	
	public void saveUbytovani(Ubytovani u) throws SQLException;
	
	public void removeUbytovani(Ubytovani u) throws SQLException;
		
	public Ubytovani getUbytovaniPodleId(int id) throws SQLException;

	public List<Ubytovani> getUbytovaniPodleData(Date datum) throws SQLException;

	public List<Majitel> getMajitelVsechny() throws SQLException;;

	
	public Majitel getMajitelPodleId(int idMajitel) throws SQLException;
	
	public void saveMajitel(Majitel m) throws SQLException;
	
	public void removeMajitel(Majitel m) throws SQLException;
	

	public Pes getPesPodleId(int idPes) throws SQLException;
	
	public void savePes(Pes p) throws SQLException;
	
	public void removePes(Pes p) throws SQLException;
	
	
	public Recepcni getRecepcniPodleId(int idSluzba) throws SQLException;
	
	public Recepcni getRecepcni(String username, String heslo) throws SQLException;

	
	public List<Kotec> getKotecVsechny() throws SQLException;
	
	public Kotec getKotecPodleId(int id) throws SQLException;

	
	public VahovaKategorie getVahovaKategoriePodleId(int idVahovaKategorie) throws SQLException;

	public Sluzba getSluzbaPodleId(int id) throws SQLException;

	
}