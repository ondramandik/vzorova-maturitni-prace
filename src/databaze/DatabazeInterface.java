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

	public VahovaKategorie getPesVahovaKategorie(Pes pes);
	
	public Majitel getPesMajitel(Pes pes);
	
	public Majitel getUbytovaniMajitel(Ubytovani ubytovani);

	public Sluzba getUbytovaniSluzba(Ubytovani ubytovani);

	public Pes getUbytovaniPes(Ubytovani ubytovani);

	public Kotec getUbytovaniKotec(Ubytovani ubytovani);

	public Recepcni getUbytovaniRecepcniPrijal(Ubytovani ubytovani);

	public Recepcni getUbytovaniRecepcniVydal(Ubytovani ubytovani);

	public Recepcni getUbytovaniRecepcniVytvoril(Ubytovani ubytovani);


	
}
