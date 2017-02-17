package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import databaze.Databaze;
import entity.Kotec;
import entity.Pes;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class OknoUbytovani extends JFrame {

	private JPanel contentPane;

	public static OknoUbytovani getInstance() {
		OknoUbytovani instance = (OknoUbytovani) OknaPool.get("OknoUbytovani");
		if(instance == null) {
			instance = new OknoUbytovani();
			OknaPool.add(instance);
		}
		return instance;
	}
	
	
	/**
	 * Okono pro zadnání ubytování od ... do.
	 */
	private OknoUbytovani() {
		try {
			this.setTitle("Ubytování");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(100, 100, 663, 300);
	
			
			this.contentPane = new JPanel();
			this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.contentPane.setLayout(new GridLayout(4,2));
			
			
			this.setContentPane(this.contentPane);
			
			JLabel lblOd = new JLabel("Od:");
			this.contentPane.add(lblOd);
			
			//fomátované textFieldy
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			JFormattedTextField odDataField = new JFormattedTextField(format);
			odDataField.setBounds(332, 65, 152, 22);
			this.contentPane.add(odDataField);
			
			
			JLabel lblDo = new JLabel("Do:");
			this.contentPane.add(lblDo);
			
			JFormattedTextField doDataField = new JFormattedTextField(format);
			doDataField.setBounds(332, 104, 152, 22);
			this.contentPane.add(doDataField);
		
			
			JLabel lblPes = new JLabel("Pes:");
			this.contentPane.add(lblPes);
			
			DefaultListModel listModelPsi = new DefaultListModel();
			for(Pes p : Databaze.getInstance().getPesVsechny()) {
				listModelPsi.addElement(p.getJmeno());
			}
			JList psiList = new JList(listModelPsi);
			psiList.setBounds(148, 120, 283, 58);
			contentPane.add(psiList);
			
			JLabel lblKotec= new JLabel("Kotec:");
			this.contentPane.add(lblKotec);
			
			DefaultListModel listModelKotce = new DefaultListModel();
			for(Kotec kotec : Databaze.getInstance().getKotecVsechny()) {
				listModelKotce.addElement(kotec.getCislo() + " (max: " + kotec.getKapacita() + ")");
			}
			JList kotceList = new JList(listModelKotce);
			kotceList.setBounds(148, 190, 283, 58);
			contentPane.add(kotceList);
			
			setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Vyskytla se neočekávná chyba");
			this.setVisible(false);
			this.dispose();
		}
	}
	
	@Override
	public void dispose() {
	    OknaPool.remove(this);
	    super.dispose();
	}
}
