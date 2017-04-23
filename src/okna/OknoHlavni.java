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
import vyjimky.KonfigurakException;

import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class OknoHlavni extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	public static OknoHlavni getInstance() {
		OknoHlavni instance = (OknoHlavni) OknaPool.get("OknoHlavni");
		if(instance == null) {
			instance = new OknoHlavni();
			OknaPool.add(instance);
		}
		return instance;
	}
	
	
	/**
	 * Create the frame.
	 */
	private OknoHlavni() {
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
				OknoZakaznik.getInstance();
			}
		});
		novy.add(novyZakaznik);
		
        JMenuItem novyPes = new JMenuItem("Nový pes");
		novyPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				OknoPes.getInstance();
			}
		});
		novy.add(novyPes);
		
		JMenuItem noveUbytovani = new JMenuItem("Nové ubytování");
		noveUbytovani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				OknoUbytovani.getInstance();
			}
		});
		novy.add(noveUbytovani);
		
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
		} catch(KonfigurakException e){
			System.out.println(e.getMessage());
		}
		table.setBounds(38, 39, 370, 99);
		contentPane.add(table);
	
		repaint();
	}
	
	@Override
	public void dispose() {
	    OknaPool.remove(this);
	    super.dispose();
	}
}
