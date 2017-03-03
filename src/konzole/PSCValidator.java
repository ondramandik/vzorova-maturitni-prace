package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PSCValidator extends konzole.Validator{
	
	public static final Pattern PSC_PATTERN = Pattern.compile("\\d{5}");
	
	public PSCValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = PSC_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "PSC zadavejte jako 5 cislic bez mezer.";
	}

}