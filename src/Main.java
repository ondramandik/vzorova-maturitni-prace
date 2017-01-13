import java.sql.SQLException;

import Databaze.DatabazeInterface;
import Databaze.DatabazeManager;
import TrasferObjects.Kotec;

public class Main {

	
	private static void test1() {
		DatabazeInterface db;
		try {
			db = DatabazeManager.getDatabaze();
			
			Kotec k = new Kotec();
			k.setCislo("01");
			k.setKapacita(10);
			
			db.saveKotec(k);
			
			System.out.println(k.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		test1();
		

	}

}
