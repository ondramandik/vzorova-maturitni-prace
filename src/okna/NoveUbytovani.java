package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaze.Databaze;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class NoveUbytovani extends JFrame {

	private JPanel contentPane;


	/**
	 * Okono pro zadnání ubytování od ... do.
	 */
	public NoveUbytovani() {
		this.setTitle("Ubytování");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 663, 300);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(null);
		this.setContentPane(this.contentPane);
		
		
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(30, 68, 56, 16);
		this.contentPane.add(lblOd);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(30, 107, 56, 16);
		this.contentPane.add(lblDo);
		
		
		JComboBox odData = new JComboBox();
		odData.setBounds(123, 65, 170, 22);
		
		Calendar calendar = Calendar.getInstance();

		for (int i = 0; i < 28; ++i) {
		    odData.addItem(new Datum(calendar.getTime()));
		    calendar.add(Calendar.DATE, 1);
		}
		
		this.contentPane.add(odData);
		
		JComboBox doData = new JComboBox();
		doData.setBounds(123, 104, 170, 22);
		
		for (int i = 0; i < 28; ++i) {
		    doData.addItem(new Datum(calendar.getTime()));
		    calendar.add(Calendar.DATE, 1);
		}
		
		this.contentPane.add(doData);
		
		
		//fomátované textFieldy
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		JFormattedTextField odDataField = new JFormattedTextField(format);
		odDataField.setBounds(332, 65, 152, 22);
		this.contentPane.add(odDataField);
		
		JFormattedTextField doDataField = new JFormattedTextField(format);
		doDataField.setBounds(332, 104, 152, 22);
		this.contentPane.add(doDataField);
		
		JComboBox pesComboBox = new JComboBox();
		pesComboBox.setBounds(123, 104, 170, 22);
		for(Pes p : Databaze.getInstance().getPesVsechny()) {
			
		}
		this.contentPane.add(pesComboBox);
		
		setVisible(true);
	}
}
