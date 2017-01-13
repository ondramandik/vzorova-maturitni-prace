package Databaze;

import java.sql.SQLException;

public class DatabazeManager {

	private static DatabazeInterface db = null;
	
	public static DatabazeInterface getDatabaze() throws SQLException {
		if(DatabazeManager.db == null) {
			DatabazeManager.db = new DatabazeMySQL();
		}
		return DatabazeManager.db;
	}
	
}

