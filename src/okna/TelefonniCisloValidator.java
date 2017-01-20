package okna;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelefonniCisloValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String TELEFON_PATTERN = "\\d{9}";

	public TelefonniCisloValidator() {
		pattern = Pattern.compile(TELEFON_PATTERN);
	}

	public boolean validace(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}
