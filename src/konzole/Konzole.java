package konzole;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import databaze.Databaze;

import entity.Majitel;
import entity.Recepcni;
import okna.Validator;
import entity.*;

public class Konzole {
	private Scanner scanner;
	
	public Konzole() {
		this.scanner = new Scanner(System.in);
		this.scanner.useDelimiter("\n");
	}
	
	
	
	public void prihlasRecepcniho(){
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
		if (Recepcni.getPrihlasenyRecepcni()==null){
			vypisTextSOdradkovanim("Neplatne prihlasovaci udaje!");
		}
	}
	
	public void vypisMenu(){
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
	
	public String nactiValidni(String text, konzole.Validator validator){
		return nactiValidni(text, validator, null);
	}
	
	public String nactiValidni(String text, konzole.Validator validator, String vychoziHodnota){
		String nacti = "";
		
		if(vychoziHodnota != null) {
			text += " (Výchozí="+vychoziHodnota+")";
		}
		text += ": ";
		
		do{
			vypisText(text);
			
			nacti = scanner.next();
			
			if(vychoziHodnota != null && nacti.equals("")) {
				return vychoziHodnota;
			}
			validator.validuj(nacti);
			if(!validator.jeValidni()) {
				vypisTextSOdradkovanim(validator.getChybovaHlaska());
			}
		}while(!validator.jeValidni());
		return nacti;
	}
	
    public void pridejMajitele(){
    	vypisTextSOdradkovanim("Vytvoreni noveho majitele");
    	String jmeno = nactiValidni("Jmeno majitele: ",new konzole.JenENPismenaValidator());
    	String prijmeni = nactiValidni("Prijmeni majitele: ",new konzole.JenENPismenaValidator());
    	String telefon = nactiValidni("Telefonni cislo majitele: ",new TelefonValidator());
    	String mail = nactiValidni("Email majitele: ",new EmailValidator());
    	vypisTextSOdradkovanim("Bydliste majitele: ");
    	String ulice = nactiValidni("Ulice: ",new UliceValidator());
    	String cisloPopisne = nactiValidni("Cislo popisne: ",new JenCislaValidator());
    	String cisloOrientacni = nactiValidni("Cislo oreintacni: ",new JenCislaValidator());
    	String mesto = nactiValidni("Mesto: ",new konzole.JenENPismenaValidator());
    	String psc = nactiValidni("PSC: ",new PSCValidator());
    	   	
		Majitel majitel = new Majitel();
		
		majitel.setId(0); 
		majitel.setEmail(mail);
		majitel.setTelefon(telefon);
		majitel.setJmeno(jmeno);
		majitel.setPrijmeni(prijmeni);
		majitel.setMesto(mesto);
		majitel.setPsc(psc);
		majitel.setUlice(ulice);
		majitel.setUliceCisloOrientacni(Integer.parseInt(cisloPopisne));
		majitel.setUliceCisloPopisne(Integer.parseInt(cisloOrientacni));
		try {
			Databaze.getInstance().saveMajitel(majitel);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private void vypisTextSOdradkovanim(String text) {
		vypisText(text);
		System.out.println();
	}

	private void vypisText(String text){
		System.out.print(text);
	}

	public void start() {
		while (Recepcni.getPrihlasenyRecepcni()==null){
			prihlasRecepcniho();
		}
		
		boolean jeKonec = false;
		while(!jeKonec){
			vypisMenu();
			int volba = scanner.nextInt();
			switch (volba){
			case 1: //hotovo Alca
				pridejPsa();
				break;
			case 2: //hotovo Alca
				pridejMajitele();
				break;
			case 3: //todo Ondra
				vytvorUbytovani();
				break;
			case 4: //todo Janicka
				prijmyPsa();
				break;
			case 5: //todo Janicka
				vydejPsa();
				break;
			case 6: //hotovo Janicka
				prihlasRecepcniho();
				break;
			case 7: //hotovo Janicka
				jeKonec = true;
				break;
			case 8: //todo Alca
				vypisVsechnyMajitele();
				break;
			case 9: //hotovo Ondra
				vypisPsyKDatu();
				break;
			default:
				break;
				
			}
			scanner.nextLine();
		}
		
	}

	private void vypisPsyKDatu() {
		DateFormat format =  new SimpleDateFormat("dd.mm.yyyy");
		String datumVeStringu = nactiValidni("Zadejte datum: ", new DatumValidator(),format.format(new Date()));
		try {
			Date datum = format.parse(datumVeStringu);
			List<Ubytovani> ubytovani = Databaze.getInstance().getUbytovaniPodleData(datum);
			if(ubytovani.size() == 0) {
				vypisText("K datum "+datumVeStringu+" nebyl nalezen žádný záznam.");
				for (Ubytovani u : ubytovani){
					vypisTextSOdradkovanim(u.toString());
				}
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

	private  void vydejPsa() {
		// TODO Auto-generated method stub
		List<Ubytovani> ubytovani = null;
		try {
			ubytovani = Databaze.getInstance().getUbytovaniPodleData(new Date());
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		for (Ubytovani u : ubytovani){
			vypisTextSOdradkovanim(i+") "+u);
		}
	}

	private void vytvorUbytovani() {
		// TODO Auto-generated method stub
		
	}

	private void pridejPsa() {
		// TODO Auto-generated method stub
		
	}

	
	/** 
	 * Vypisuje vsechny majitele z databaze
	 */
	private void vypisVsechnyMajitele() {
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