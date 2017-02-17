package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	protected boolean validni;
	
	public static final Pattern EMAIL_PATTERN = Pattern.compile(
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	
	public static final Pattern TELEFON_PATTERN = Pattern.compile("\\d{9}");
	
	public static final Pattern PSC_PATTERN = Pattern.compile("\\d{5}");
	
	public static final Pattern PISMENA_PATTERN = Pattern.compile("[a-zA-Z]*");
	
	public static final Pattern ULICE_PATTERN = Pattern.compile("[A-Z0-9][a-zA-Z0-9\\.\\s]+");
	
	public static final Pattern CISLAULICE_PATTERN = Pattern.compile("[1-9][0-9]*");
	
	public Validator(){
		validni = false;
	}
	
	public static Validator getValidator(Pattern pattern){
		if(pattern == EMAIL_PATTERN){
			return new EmailValidator();
		}
		
		return new Validator();
	}
	
	public void validuj(String vyraz) {
		validni = true;
	}

	public String getChybovaHlaska() {
		return null;
	}

	public boolean jeValidni() {
		return validni;
	}
}
