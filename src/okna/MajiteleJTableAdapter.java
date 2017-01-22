package okna;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Majitel;
import entity.Ubytovani;

public class MajiteleJTableAdapter extends AbstractTableModel {

	private List<Majitel> majitele;
	
	public MajiteleJTableAdapter(List<Majitel> majitele) {
		this.majitele = majitele;
	}

	@Override
	public int getRowCount() {
		return this.majitele.size();
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
					return this.majitele.get(rowIndex).getJmeno();
				case 1:
					return this.majitele.get(rowIndex).getPrijmeni();
				case 2:
					return this.majitele.get(rowIndex).getTelefon();
				case 3:
					return this.majitele.get(rowIndex).getEmail();
				default:
					throw new Exception("Invalid colum");
			}
		} catch (Exception e) {
			return "NIC";
		}
	}

}

