package konzole;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

import databaze.Databaze;
import entity.Majitel;
import entity.Recepcni;
import okna.Validator;

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
	
	public static String nactiValidni(String coChci, Pattern pattern){
		okna.Validator validator = new Validator(pattern);
		String nacti = "";
		do{
			x
			vypisText(coChci);
			nacti = scanner.nextLine();
			validator.validuj(nacti);
			if(validator.maChybovouHlasku()) {
				vypis(validator.getChybovaHlaska())
			}
		}while(!validator.jeValidni());
		return nacti;
	}
    public static void pridejMajitele(){
    	vypisText("Vytvoreni noveho majitele");
    	vypisText("Jmeno majitele: ");
    	String jmeno = scanner.nextLine();
    	vypisText("Prijmeni majitele: ");
    	String prijmeni = scanner.nextLine();
    	vypisText("Telefonni cislo majitele: ");
    	String telefon = scanner.nextLine();
    	vypisText("Email majitele: ");
    	String mail = scanner.nextLine();
    	vypisText("Bydliste majitele: ");
    	vypisText("Ulice: ");
    	String ulice = scanner.nextLine();
    	vypisText("Cislo popisne: ");
    	String cisloPopisne = scanner.nextLine();
    	vypisText("Cislo oreintacni: ");
    	String cisloOrientacni = scanner.nextLine();
    	vypisText("Mesto: ");
    	String mesto = scanner.nextLine();
    	vypisText("PSC: ");
    	String psc = scanner.nextLine();
    	   	
		Majitel majitel = new Majitel();
		
		
		//majitel.setId(0); 
		majitel.setEmail(mail);
		majitel.setTelefon(telefon);
		majitel.setJmeno(jmeno);
		majitel.setPrijmeni(prijmeni);
		majitel.setMesto(mesto);
		majitel.setPsc(psc);
		majitel.setUlice(ulice);
		majitel.setUliceCisloOrientacni(cisloPopisne);
		majitel.setUliceCisloPopisne(cisloOrientacni);
		Databaze.getInstance().saveMajitel(majitel);
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
				prijmiPsa();
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
				vypisMajitele();
				break;
			case 9:
				vypisPsyKDatu();
				break;
			default:
				break;
				
			}
		}
		
	}
}
