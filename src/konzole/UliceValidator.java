package konzole;

import java.util.regex.Matcher;

public class UliceValidator extends konzole.Validator{
	
	public UliceValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = ULICE_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "Spatny format, jeste prepis";
	}

}
