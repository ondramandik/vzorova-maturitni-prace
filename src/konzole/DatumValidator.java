package konzole;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatumValidator extends konzole.Validator{
	
	public DatumValidator() {
		super();
	}

	public void validuj(String vyraz) {
		Pattern pattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)");
		Matcher matcher = pattern.matcher(vyraz);
		validni = matcher.matches();
	}

	public String getChybovaHlaska() {
		return "Datum zadávejte ve formátu DD.MM.RRRR";
	}

}