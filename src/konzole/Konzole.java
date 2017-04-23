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
import vyjimky.DatabazeException;
import vyjimky.KonfigurakException;
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
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
			//e.printStackTrace();
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
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
	
	public Date nactiDatum(String text, Date defaultni) {
		do {
			DateFormat format =  new SimpleDateFormat("dd.mm.yyyy");
			String datumVeStringu = nactiValidni(text, new DatumValidator(),format.format(defaultni));
			try {
				return format.parse(datumVeStringu);
			} catch (ParseException e) {
				//do nothing
				vypisTextSOdradkovanim("Nepodarilo se nacist datum. Prekontrolujte si format.");
			}
		} while(true);
		
	}
	
	public Object nactiZListu(String text, List list) {
		vypisText(text);
		for(int i = 0; i < list.size(); i++){
			vypisTextSOdradkovanim( (i + 1) + ")" + list.get(i));
		}
		int index = Integer.parseInt(nactiValidni("Zadej cislo: ",new JenCislaZIntervaluValidator(1,list.size())));
		return list.get(index-1);
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
		} catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
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
			scanner.reset();
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
			case 4: //hotovo Janicka
				prijmyPsa();
				break;
			case 5: //hotovo Janicka
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

	private void prijmyPsa() {
		
	
		try {
			Date datum = nactiDatum("Zadejte datum: ", new Date());
			List<Ubytovani> ubytovani = Databaze.getInstance().getUbytovaniPodleData(datum);
			if(ubytovani.size() == 0) {
				vypisText("K datum "+datum.toString()+" nebyl nalezen žádný záznam.");
			} else {
				System.out.println("Zadej číslo ubytování: ");
				int cisloUbytovani = 1;
				for (Ubytovani u : ubytovani){
					vypisTextSOdradkovanim(cisloUbytovani + ") " + u.toString());
				}
				int vybraneUbytovani  = scanner.nextInt();
				ubytovani.get(vybraneUbytovani-1).setPrijalIdRecepcni(Recepcni.getPrihlasenyRecepcni().getId());
				Databaze.getInstance().saveUbytovani(ubytovani.get(vybraneUbytovani-1));
			}
		} catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
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
				return;
			} else {
				for (Ubytovani u : ubytovani){
					vypisTextSOdradkovanim(u.toString());
				}
			}
		}  catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			vypisTextSOdradkovanim("Nepodarilo se nacist datum. Prekontrolujte si format.");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
		}
	}

	private  void vydejPsa() {
		DateFormat format =  new SimpleDateFormat("dd.mm.yyyy");
		String datumVeStringu = nactiValidni("Zadejte datum: ", new DatumValidator(),format.format(new Date()));
		try {
			Date datum = format.parse(datumVeStringu);
			List<Ubytovani> ubytovani = Databaze.getInstance().getUbytovaniPodleData(datum);
			if(ubytovani.size() == 0) {
				vypisText("K datum "+datumVeStringu+" nebyl nalezen žádný záznam.");
			} else {
				System.out.println("Zadej číslo ubytování: ");
				int cisloUbytovani = 1;
				for (Ubytovani u : ubytovani){
					vypisTextSOdradkovanim(cisloUbytovani + ") " + u.toString());
				}
				int vybraneUbytovani  = scanner.nextInt();
				ubytovani.get(vybraneUbytovani-1).setVydalIdRecepcni(Recepcni.getPrihlasenyRecepcni().getId());
				Databaze.getInstance().saveUbytovani(ubytovani.get(vybraneUbytovani-1));
			}
		}  catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			vypisTextSOdradkovanim("Nepodarilo se nacist datum. Prekontrolujte si format.");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
		}
	}

	private void vytvorUbytovani() {
		vypisTextSOdradkovanim("Vytvoreni noveho ubytovani");
		try {
			Majitel m = (Majitel) nactiZListu("Vyberte majitele",  Databaze.getInstance().getMajitelVsechny());
			Pes p = (Pes) nactiZListu("Vyberte psa",  Databaze.getInstance().getPesVsechny());
			Kotec k = (Kotec) nactiZListu("Vyberte kotec kam psa umístíme",  Databaze.getInstance().getKotecVsechny());
			
			Date datumOd = nactiDatum("Zadejte datum od: ", new Date());
			Date datumDo = nactiDatum("Zadejte datum do: ", new Date());
			
			Ubytovani u = new Ubytovani();
			u.setIdKotec(k.getId());
			u.setIdPes(p.getId());
			u.setIdMajitel(m.getId());
			u.setUbytovanDo(datumDo);
			u.setUbytovanDo(datumOd);
			Databaze.getInstance().saveUbytovani(u);
			
			System.out.println("Ubytovani bylo uspesne ulozeno");
			
		} catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
		} 		
	}

	private void pridejPsa() {
		vypisTextSOdradkovanim("Vytvoreni noveho psa");
		vypisTextSOdradkovanim("Vyber majitele psa: ");
		try {
			List<Majitel> majiteleVsichni = Databaze.getInstance().getMajitelVsechny();
			for(int i = 0; i < majiteleVsichni.size(); i++){
				int cisloMajitele = i + 1;
				vypisTextSOdradkovanim(cisloMajitele + ")" + majiteleVsichni.get(i));
			}
			vypisTextSOdradkovanim("Vyber index majitele psa: ");	
			int indexMajitele = scanner.nextInt();
			scanner.nextLine(); //neco jineho na cisteni?
			if(indexMajitele > 0 && indexMajitele < majiteleVsichni.size()){
				String jmenoPsa = nactiValidni("Zadej jmeno psa: ",new konzole.JenENPismenaValidator());
				Pes novyPes = new Pes(0,jmenoPsa,majiteleVsichni.get(indexMajitele-1).getId());
				Databaze.getInstance().savePes(novyPes);
				vypisTextSOdradkovanim("Upesne jsi pridal noveho psa.");
			}else{
				vypisTextSOdradkovanim("Nebyl zadan existujici index majitele.");
			}
			
		}  catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
		}
	}

	
	/** 
	 * Vypisuje vsechny majitele z databaze ? ocislovane ?
	 */
	private void vypisVsechnyMajitele() {
		try {
			List<Majitel> majiteleVsichni = Databaze.getInstance().getMajitelVsechny();
		for(int i = 0; i < majiteleVsichni.size(); i++){
				int cisloMajitele = i + 1;
				vypisTextSOdradkovanim(cisloMajitele + ")" + majiteleVsichni.get(i));
			}
		} catch (DatabazeException e) {
			vypisTextSOdradkovanim(e.getMessage());
		} catch(SQLException e){
			vypisTextSOdradkovanim("Pri praci s databazi doslo k neocekavane chybe");
		} catch(KonfigurakException e){
			vypisTextSOdradkovanim(e.getMessage());
		}
		
	}
}