package vyjimky;

import java.sql.SQLException;

public class DatabazeException extends SQLException {
	public DatabazeException(String chybovaHlaska){
		super(chybovaHlaska);
	}

}
