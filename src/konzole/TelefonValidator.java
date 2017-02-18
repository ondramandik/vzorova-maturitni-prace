package konzole;

import java.util.regex.Matcher;

public class TelefonValidator extends konzole.Validator{
	
	public TelefonValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = TELEFON_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "Telefonni cislo zadadavej ve travu 9 cislic bez bemezer.";
	}

}