package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UliceValidator extends konzole.Validator{
	
	public static final Pattern ULICE_PATTERN = Pattern.compile("[A-Z0-9][a-zA-Z0-9\\.\\s]+");
	
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
