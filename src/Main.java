<<<<<<< HEAD
import java.io.IOException;
import java.sql.SQLException;

import databaze.*;
import entity.*;
import okna.Prihlaseni;

=======
>>>>>>> branch 'master' of https://github.com/ondramandik/vzorova-maturitni-prace.git
public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		//test1();
		//test2();
		test3();
	}
	
	private static void test1() {
=======
>>>>>>> branch 'master' of https://github.com/ondramandik/vzorova-maturitni-prace.git
		
	}
	
<<<<<<< HEAD
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
	
	public static void test3(){
		Prihlaseni p = new Prihlaseni();
	}

=======
>>>>>>> branch 'master' of https://github.com/ondramandik/vzorova-maturitni-prace.git
}
