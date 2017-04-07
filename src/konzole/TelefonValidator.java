package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelefonValidator extends konzole.Validator{
	
	public static final Pattern TELEFON_PATTERN = Pattern.compile("\\d{9}");
	
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