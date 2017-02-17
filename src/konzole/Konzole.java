package konzole;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import entity.Recepcni;

public class Konzole {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void prihlasRecepcniho(){
		vypisText("Zadej pridej prihlasovaci jmeno: ");
		String uzivatelskeJmeno = scanner.nextLine();
		vypisText("Zadej heslo: ");
		String heslo = scanner.nextLine();
		try {
			Recepcni.prihlas(uzivatelskeJmeno, heslo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void vypisText(String text){
		System.out.print(text);
	}
}
