package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	protected boolean validni;
	
	public Validator(){
		validni = false;
	}
	
	/*
	public static Validator getValidator(Pattern pattern){
		if (pattern == EMAIL_PATTERN){
			return new EmailValidator(pattern);
		}
		
		return new Validator(pattern);
	}
	*/
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
