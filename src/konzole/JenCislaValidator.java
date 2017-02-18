package konzole;

import java.util.regex.Matcher;

public class JenCislaValidator extends konzole.Validator{
	
	public JenCislaValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = CISLAULICE_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "Tento udaj obsahuje pouze cislovky.";
	}

}
