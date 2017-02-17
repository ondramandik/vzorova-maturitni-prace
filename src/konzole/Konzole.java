package konzole;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import databaze.Databaze;
import entity.*;

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
	
	public static void vypisMenu(){
		vypisTextSOdradkovanim("Prihlasen: " + Recepcni.getPrihlasenyRecepcni().getJmenoAPrijmeni());
		vypisTextSOdradkovanim("Vyber akci: ");
		vypisTextSOdradkovanim("1) Pridej psa");
		vypisTextSOdradkovanim("2) Pridej majitele");
		vypisTextSOdradkovanim("3) Vytvor ubytovani");
		vypisTextSOdradkovanim("4) Prijmi psa");
		vypisTextSOdradkovanim("5) Vydej psa");
		vypisTextSOdradkovanim("6) Prihlas jineho recepcniho");
		vypisTextSOdradkovanim("7) Ukonceni programu");
		vypisTextSOdradkovanim("8) Vypis vsechny majitele");
		vypisTextSOdradkovanim("9) Vypis psy ubytovane v zadanem dni");
	}
	

	
	private static void vypisTextSOdradkovanim(String text) {
		vypisText(text);
		System.out.println();
	}

	private static void vypisText(String text){
		System.out.print(text);
	}

	public static void start() {
		if (Recepcni.getPrihlasenyRecepcni()==null){
			prihlasRecepcniho();
		}
		
		boolean jeKonec = false;
		while(!jeKonec){
			vypisMenu();
			int volba = scanner.nextInt();
			switch (volba){
			case 1:
				pridejPsa();
				break;
			case 2:
				pridejMajitele();
				break;
			case 3:
				vytvorUbytovani();
				break;
			case 4:
				pridejPsa();
				break;
			case 5:
				vydejPsa();
				break;
			case 6:
				prihlasRecepcniho();
				break;
			case 7:
				jeKonec = true;
				break;
			case 8:
				vypisVsechnyMajitele();
				break;
			case 9:
				vypisPsyKDatu();
				break;
			default:
				break;
				
			}
			scanner.nextLine();
		}
		
	}

	private static void vypisPsyKDatu() {
		// TODO Auto-generated method stub
		vypisText("Zadej datum: ");
		//String datumVeStringu = scanner.nextLine();
		String datumVeStringu = "11.02.2016";
		Date datum;
		try {
			datum = (new SimpleDateFormat("dd.mm.yyyy")).parse(datumVeStringu);
			List<Ubytovani> ubytovani = Databaze.getInstance().getUbytovaniPodleData(datum);
			for (Ubytovani u : ubytovani){
				vypisTextSOdradkovanim(u.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void vydejPsa() {
		// TODO Auto-generated method stub
		
	}

	private static void vytvorUbytovani() {
		// TODO Auto-generated method stub
		
	}

	private static void pridejMajitele() {
		// TODO Auto-generated method stub
		
	}

	private static void pridejPsa() {
		// TODO Auto-generated method stub
		
	}

	private static void vypisVsechnyMajitele() {
		try {
			List<Majitel> majiteleVsichni = Databaze.getInstance().getMajitelVsechny();
			for (Majitel m : majiteleVsichni){
				vypisTextSOdradkovanim(m.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
