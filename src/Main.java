import java.sql.SQLException;

import databaze.Databaze;
import databaze.DatabazeInterface;
import trasferObjects.Kotec;
import databaze.DatabazeManager;

public class Main {

	
	private static void test1() {
		DatabazeInterface db;
		try {
			db = DatabazeManager.getDatabaze();
			
			for(Kotec k : db.getKotecVsechny()) {
				System.out.println(k.getCislo() + ": " + k.getKapacita());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		//test1();
		test2();

	}
	
	public static void test2(){
		Databaze d = new Databaze();
	}

}
