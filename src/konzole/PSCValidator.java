package konzole;

import java.util.regex.Matcher;

public class PSCValidator extends konzole.Validator{
	
	public PSCValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = CISLAULICE_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "PSC zadavejte jako 5 cislic bez mezer.";
	}

}