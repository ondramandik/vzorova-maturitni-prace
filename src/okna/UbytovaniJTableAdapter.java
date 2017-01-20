package okna;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import databaze.Databaze;
import entity.Ubytovani;

public class UbytovaniJTableAdapter extends AbstractTableModel {

	private List<Ubytovani> ubytovani;
	
	public UbytovaniJTableAdapter(List<Ubytovani> ubytovani) {
		this.ubytovani = ubytovani;
	}

	@Override
	public int getRowCount() {
		return this.ubytovani.size();
	}

	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			switch(columnIndex) {
				case 0:
					return this.ubytovani.get(rowIndex).getSluzba().getJmeno();
				default:
					throw new Exception("Invalid colum");
			}
		} catch (Exception e) {
			return "NIC";
		}
	}

}
