package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JenCislaZIntervaluValidator extends JenCislaValidator {

private int dolni;
private int horni;
	
	public JenCislaZIntervaluValidator(int dolni, int horni) {
		this.dolni = dolni;
		this.horni = horni;
	}

	public void validuj(String vyraz) {
		super.validuj(vyraz);
		if(validni){
		  int cislo = Integer.parseInt(vyraz);
		  validni =  (dolni <= cislo) && (horni >= cislo);
		}
	}

	public String getChybovaHlaska() {
		return "Tento udaj obsahuje pouze cislovky. Od " + dolni + " az " + horni ;
	}
}
