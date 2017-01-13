package Databaze;

import java.sql.SQLException;
import java.util.List;
import TrasferObjects.*;

public interface DatabazeInterface {
	
	public void saveKotec(Kotec k) throws SQLException;
	
	public void removeKotec(Kotec k) throws SQLException;
	
	public List<Kotec> getKotecVsechny() throws SQLException;
	
	public Kotec getKotecPodleId(int id) throws SQLException;
	
	public int getKotecVolnaMista(Kotec k) throws SQLException;

	public void saveUbytovani(Ubytovani u) throws SQLException;
	
	public void removeUbytovani(Ubytovani u) throws SQLException;
		
	public Ubytovani getUbytovaniPodleId(int id) throws SQLException;
	
}
