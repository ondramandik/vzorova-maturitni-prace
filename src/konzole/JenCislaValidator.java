package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JenCislaValidator extends konzole.Validator{
	public static final Pattern CISLAULICE_PATTERN = Pattern.compile("[1-9][0-9]*");
	
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
