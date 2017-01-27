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
	
	
	public List<Pes> getPesVsechny() throws SQLException;
	
	public Pes getPesPodleId(int id) throws SQLException;
	
	public void savePes(Pes p) throws SQLException;
	
	public void removePes(Pes p) throws SQLException;
	
	
	public Recepcni getRecepcniPodleId(int id) throws SQLException;
	
	public Recepcni getRecepcniPodlePristupovychUdaju(String uzivatelskeJmeno, String heslo) throws SQLException;

	
	public List<Kotec> getKotecVsechny() throws SQLException;
	
	public Kotec getKotecPodleId(int id) throws SQLException;
	
}