package okna;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Majitel;
import entity.Pes;

public class PsiJTableAdapter extends AbstractTableModel {

	private List<Pes> psi;
	
	public PsiJTableAdapter(List<Pes> psi) {
		this.psi = psi;
	}

	@Override
	public int getRowCount() {
		return this.psi.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			Pes pes = this.psi.get(rowIndex);
			Majitel majitel = pes.getMajitel();
			switch(columnIndex) {
				case 0:
					return pes.getJmeno();
				case 1:
					return majitel.getJmenoAPrijmeni();
				default:
					throw new Exception("Invalid colum");
			}
		} catch (Exception e) {
			return "NIC";
		}
	}

}

