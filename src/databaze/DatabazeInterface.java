package databaze;

import java.util.List;

import trasferObjects.*;

public interface DatabazeInterface {
	
	public void saveKotec(Kotec k);
	
	public void removeKotec(Kotec k);
	
	public List<Kotec> getKotecVsechny();
	
	public Kotec getKotecPodleId(int id);
	
	public int getKotecVolnaMista(Kotec k);
		
	
	public void saveUbytovani(Ubytovani u);
	
	public void removeUbytovani(Ubytovani u);
		
	public Ubytovani getUbytovaniPodleId(int id);
	
}
