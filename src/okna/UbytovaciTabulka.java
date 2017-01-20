package okna;

import javax.swing.table.AbstractTableModel;
import entity.*;

public class UbytovaciTabulka extends AbstractTableModel{
	 private String[] jmenaSloupu = { "First Name", "Last Name", "Sport",
		        "# of Years", "Vegetarian" };
	 
		    private Object[][] data;
		    /*
		    public UbytovaciTabulka(Object[] ){
		    	data
		    }
*/
		    public int getColumnCount() {
		      return jmenaSloupu.length;
		    }

		    public int getRowCount() {
		      return data.length;
		    }

		    public String getColumnName(int cisloSloupce) {
		      return jmenaSloupu[cisloSloupce];
		    }

		    public Object getValueAt(int cisloRadku, int cisloSloupce) {
		      return data[cisloRadku][cisloSloupce];
		    }
}
