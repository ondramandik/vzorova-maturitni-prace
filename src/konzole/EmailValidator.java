package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator extends Validator{
	
	public EmailValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = EMAIL_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "Nespravne zadana emailova adresa.";
	}

}
