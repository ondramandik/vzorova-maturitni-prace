package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class UbytovaniPsa extends JFrame {

	private JPanel contentPane;


	/**
	 * Okono pro zadnání ubytování od ... do.
	 */
	public UbytovaniPsa() {
		setTitle("Ubytování");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(30, 68, 56, 16);
		contentPane.add(lblOd);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(30, 107, 56, 16);
		contentPane.add(lblDo);
		
		//?jak zadávat to datum?
		//combobox z datumem
		
		JComboBox odData = new JComboBox();
		odData.setBounds(123, 65, 170, 22);
		
		Calendar calendar = Calendar.getInstance();

		for (int i = 0; i < 28; ++i) {
		    odData.addItem(new Datum(calendar.getTime()));
		    calendar.add(Calendar.DATE, 1);
		}
		
		contentPane.add(odData);
		
		JComboBox doData = new JComboBox();
		doData.setBounds(123, 104, 170, 22);
		
		for (int i = 0; i < 28; ++i) {
		    doData.addItem(new Datum(calendar.getTime()));
		    calendar.add(Calendar.DATE, 1);
		}
		
		contentPane.add(doData);
		
		
		//fomátované textFieldy
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		JFormattedTextField odDataField = new JFormattedTextField(format);
		odDataField.setBounds(332, 65, 152, 22);
		contentPane.add(odDataField);
		
		JFormattedTextField doDataField = new JFormattedTextField(format);
		doDataField.setBounds(332, 104, 152, 22);
		contentPane.add(doDataField);
		
		setVisible(true);
	}
}
