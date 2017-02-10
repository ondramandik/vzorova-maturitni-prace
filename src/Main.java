import java.io.IOException;
import java.sql.SQLException;

import databaze.Databaze;
import entity.Osoba;
import okna.OknaPool;
import okna.OknoPrihlaseni;

/**
 * Hlavni trida je pouze pro nastartovani aplikace a spousti Prihlasovaci okno
 */
public class Main {

	public static void main(String[] args) {
		OknoPrihlaseni.getInstance();
		
		try {
			System.out.println(Databaze.getInstance().getMajitelVsechny());
			System.out.println(Databaze.getInstance().getPesVsechny());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
