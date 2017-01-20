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

import databaze.Databaze;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;

public class NovyPes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public NovyPes() {
		setTitle("Pes");
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jméno psa: ");
		lblNewLabel.setBounds(24, 37, 108, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Majitel: ");
		lblNewLabel_1.setBounds(24, 87, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(148, 34, 201, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnUlozit = new JButton("Uložit");
		btnUlozit.setBounds(24, 328, 120, 25);
		contentPane.add(btnUlozit);
		
		//je potřeba dořešit výjimku
		try {
			//do tabulky se vloží všichni majitele - ?dodělat výběr majitelů podle parametrů?
			table = new JTable(new MajiteleJTableAdapter(Databaze.getInstance().getMajitelVsechny()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setBounds(148, 87, 283, 148);
		contentPane.add(table);
		
		JButton btnNovyMajitel = new JButton("Nový majitel");
		btnNovyMajitel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				new NovyZakaznik();
			}
		});
		btnNovyMajitel.setBounds(24, 276, 120, 25);
		contentPane.add(btnNovyMajitel);
		
		btnUlozit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//uloženi nebo update psa
			}
		});
		
		repaint();
	}
}
