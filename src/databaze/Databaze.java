package databaze;

import java.io.*;
import java.util.Properties;

public class Databaze {
	public Properties property;
	
	public Databaze(){
		Reader is;
		try {
			is = new FileReader("pristup.ini");
			property.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//String getProperty(String key, String )

}
