package konzole;
import java.util.regex.Matcher;

public class JenENPismenaValidator extends konzole.Validator{
	
	public JenENPismenaValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Matcher matcher = PISMENA_PATTERN.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "Smis zadavat pouze pismena anglicke abecedy.";
	}

}