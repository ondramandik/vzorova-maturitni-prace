package okna;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private Matcher matcher;
	
	public static final Pattern EMAIL_PATTERN = Pattern.compile(
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	public static final Pattern TELEFON_PATTERN = Pattern.compile("\\d{9}");
	
	public static final Pattern PSC_PATTERN = Pattern.compile("\\d{5}");
	
	public static final Pattern PISMENA_PATTERN = Pattern.compile("[a-zA-Z]*");
	
	public static final Pattern ULICE_PATTERN = Pattern.compile("[A-Z0-9][a-zA-Z0-9\\.\\s]+");
	
	public static final Pattern CISLAULICE_PATTERN = Pattern.compile("[1-9][0-9]*");
	
	public boolean validace(final String hex, Pattern pattern) {
		matcher = pattern.matcher(hex);
		return matcher.matches();
	}


}
