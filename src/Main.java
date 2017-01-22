import databaze.*;
import entity.*;

public class Main {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	private static void test1() {
		
		try {
			DatabazeInterface db = Databaze.getInstance();
			for(Kotec k : db.getKotecVsechny()) {
				System.out.println(k.getCislo() + ": " + k.getKapacita());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Databaze.odpojit();
		}
	}
	
	public static void test2(){
		try {
			
			Majitel m = new Majitel();
			m.setJmeno("Karel");
			m.setPrijmeni("Novak");
			m.setTelefon("123123123");
			System.out.println(m.getId());

			
			DatabazeInterface db = Databaze.getInstance();
			db.saveMajitel(m);
			
			System.out.println(m.getId());
			
			for(Majitel m2 : db.getMajitelVsechny()) {
				System.out.println(m2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Databaze.odpojit();
		}
	}

}
