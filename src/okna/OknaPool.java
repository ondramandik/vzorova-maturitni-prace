package okna;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;

public class OknaPool {

	private static HashMap<String,JFrame>  pool = new HashMap<String,JFrame>();

	public static void add(JFrame okno) {
		OknaPool.pool.put(okno.getClass().getName(), okno);
	}
	
	public static JFrame get(String className) {
		return OknaPool.pool.get(className);
	}
	
	public static void repaint() {
		for(String klic : OknaPool.pool.keySet()) {
			OknaPool.pool.get(klic).repaint();
		}
	}

	public static void remove(JFrame okno) {
		OknaPool.pool.remove(okno.getClass().getName());
	}
	
}
