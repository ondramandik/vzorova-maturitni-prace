import java.io.IOException;
import java.sql.SQLException;

import databaze.Databaze;
import konzole.Konzole;
import okna.OknoPrihlaseni;

/**
 * Hlavni trida je pouze pro nastartovani aplikace a spousti Prihlasovaci okno
 */
public class Main {

	public static void main(String[] args) {
		Konzole konzole = new Konzole();
		konzole.start();
		
		/*OknoPrihlaseni.getInstance();
		
		try {
			System.out.println(Databaze.getInstance().getMajitelVsechny());
			System.out.println(Databaze.getInstance().getPesVsechny());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
