package databaze;

import java.sql.SQLException;

import databaze.DatabazeInterface;

public class DatabazeManager {

	private static DatabazeInterface db = null;
	
	public static DatabazeInterface getDatabaze() throws SQLException {
		if(DatabazeManager.db == null) {
			DatabazeManager.db = new DatabazeMySQL();
		}
		return DatabazeManager.db;
	}
	
}

