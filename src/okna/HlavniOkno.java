package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.util.Calendar;
import java.util.Date;

import databaze.Databaze;

import javax.swing.JTable;

public class HlavniOkno extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public HlavniOkno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Calendar kalendar = Calendar.getInstance();
		Date datum = kalendar.getTime();
		
		//potreba doresit vyjimku
		try {
			table = new JTable(new UbytovaniJTableAdapter(Databaze.getInstance().getUbytovaniPodleData(datum)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setBounds(38, 39, 370, 99);
		contentPane.add(table);
		repaint();
	}
}
