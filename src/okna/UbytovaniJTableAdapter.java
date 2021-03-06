package okna;

import java.util.List;

import javax.swing.table.AbstractTableModel;

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
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			switch(columnIndex) {
				case 0:
					return this.ubytovani.get(rowIndex).getKotec().getCislo();
				case 1:
					return this.ubytovani.get(rowIndex).getPes().getJmeno();
				case 2:
					return this.ubytovani.get(rowIndex).getMajitel().getPrijmeni();
				case 3:
					return this.ubytovani.get(rowIndex).getMajitel().getTelefon();
				default:
					throw new Exception("Invalid colum");
			}
		} catch (Exception e) {
			return "NIC";
		}
	}

}
