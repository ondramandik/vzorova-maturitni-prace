package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import java.util.Calendar;
import java.util.Date;

import databaze.Databaze;
import entity.Recepcni;

import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HlavniOkno extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public HlavniOkno() {
		setTitle("Aktualně ubytovani psi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu novy = new JMenu("Nový");
		menu.add(novy);
		
		JMenuItem novyZakaznik = new JMenuItem("Nový zákazník");
		
		novyZakaznik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

			}
		});
		
		novy.add(novyZakaznik);
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
