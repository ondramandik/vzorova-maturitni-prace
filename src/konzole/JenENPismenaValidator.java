package konzole;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JenENPismenaValidator extends konzole.Validator{
	
	public static final Pattern PISMENA_PATTERN = Pattern.compile("[a-zA-Z]*");
	
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