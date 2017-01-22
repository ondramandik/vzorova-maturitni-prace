package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaze.Databaze;
import entity.Majitel;
import entity.Recepcni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NovyZakaznik extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField jmenoField;
	private JTextField prijmeniField;
	private JTextField uliceField;
	private JTextField popisneCisloField;
	private JTextField orientacniCisloField;
	private JTextField mestoField;
	private JTextField pscField;
	private JTextField telefonField;
	private JTextField mailField;
	
	private Majitel majitel = null;
	
	private Validator validator = new Validator();

	/**
	 * Vytvoření formuláře NovyZakaznik
	 */
	public NovyZakaznik() {
		setTitle("Zákazník");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJmeno = new JLabel("Jméno:");
		lblJmeno.setBounds(26, 37, 56, 16);
		contentPane.add(lblJmeno);
		
		JLabel lblPrijmeni = new JLabel("Příjmení:");
		lblPrijmeni.setBounds(26, 78, 56, 16);
		contentPane.add(lblPrijmeni);
		
		jmenoField = new JTextField();
		jmenoField.setBounds(154, 34, 116, 22);
		contentPane.add(jmenoField);
		jmenoField.setColumns(10);
		
		prijmeniField = new JTextField();
		prijmeniField.setBounds(154, 75, 116, 22);
		contentPane.add(prijmeniField);
		prijmeniField.setColumns(10);
		
		JLabel lblUlice = new JLabel("Název ulice:");
		lblUlice.setBounds(26, 123, 79, 16);
		contentPane.add(lblUlice);
		
		JLabel lblCisloPopisne = new JLabel("Číslo popisné:");
		lblCisloPopisne.setBounds(26, 165, 90, 16);
		contentPane.add(lblCisloPopisne);
		
		JLabel lblCisloOrientan = new JLabel("Číslo orientační:");
		lblCisloOrientan.setBounds(26, 212, 107, 16);
		contentPane.add(lblCisloOrientan);
		
		uliceField = new JTextField();
		uliceField.setBounds(154, 120, 116, 22);
		contentPane.add(uliceField);
		uliceField.setColumns(10);
		
		popisneCisloField = new JTextField();
		popisneCisloField.setBounds(154, 162, 116, 22);
		contentPane.add(popisneCisloField);
		popisneCisloField.setColumns(10);
		
		orientacniCisloField = new JTextField();
		orientacniCisloField.setBounds(154, 209, 116, 22);
		contentPane.add(orientacniCisloField);
		orientacniCisloField.setColumns(10);
		
		JLabel lblMesto = new JLabel("Město: ");
		lblMesto.setBounds(26, 257, 56, 16);
		contentPane.add(lblMesto);
		
		JLabel lblPSC = new JLabel("PSČ:");
		lblPSC.setBounds(26, 295, 56, 16);
		contentPane.add(lblPSC);
		
		mestoField = new JTextField();
		mestoField.setBounds(154, 244, 116, 22);
		contentPane.add(mestoField);
		mestoField.setColumns(10);
		
		pscField = new JTextField();
		pscField.setBounds(154, 292, 116, 22);
		contentPane.add(pscField);
		pscField.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(26, 340, 56, 16);
		contentPane.add(lblTelefon);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 385, 56, 16);
		contentPane.add(lblEmail);
		
		telefonField = new JTextField();
		telefonField.setBounds(154, 337, 116, 22);
		contentPane.add(telefonField);
		telefonField.setColumns(10);
		
		mailField = new JTextField();
		mailField.setBounds(154, 379, 116, 22);
		contentPane.add(mailField);
		mailField.setColumns(10);
		
		JButton btnUlozit = new JButton("Uložit");
		btnUlozit.setBounds(26, 459, 97, 25);
		contentPane.add(btnUlozit);
		
		btnUlozit.addActionListener(this);
		setVisible(true);
		repaint();
	}
	
	public NovyZakaznik(Majitel majitelPsa) {
		this();
		this.majitel = majitelPsa;
		
		jmenoField.setText(majitelPsa.getJmeno());
		prijmeniField.setText(majitelPsa.getPrijmeni());
		uliceField.setText(majitelPsa.getUlice());
		popisneCisloField.setText(majitelPsa.getUliceCisloPopisne()+"");
	    orientacniCisloField.setText(majitelPsa.getUliceCisloOrientacni()+"");
		mestoField.setText(majitelPsa.getMesto());
		pscField.setText(majitelPsa.getPsc());
		telefonField.setText(majitelPsa.getTelefon());
		mailField.setText(majitelPsa.getEmail());
	}
	
	public void actionPerformed(ActionEvent actionEvent) {
		//uloženi nebo update zákazníka
		//vyjimka neni doresena
		try {
			String jmenoZakaznika = jmenoField.getText().trim();
			String prijmeniZakaznika = prijmeniField.getText().trim();
			String uliceZakaznika = uliceField.getText().trim();
			int cisloPopisneZakaznika = Integer.parseInt(popisneCisloField.getText().trim());
			int cisloOrientacniZakaznika = Integer.parseInt(orientacniCisloField.getText().trim());
			String mestoZakaznika = mestoField.getText().trim();
			String pscZakaznika = pscField.getText().trim();

			String telefonZakaznika = telefonField.getText().trim();
			if(!validator.validace(telefonZakaznika,Validator.TELEFON_PATTERN)) {
				throw new ParseException("Telefonní číslo neni validni",0);
			}
			
			String mailZakaznika = mailField.getText().trim();
			if(!validator.validace(mailZakaznika,Validator.TELEFON_PATTERN)) {
				throw new ParseException("Mail neni validni",0);
			}
			if(majitel == null){
				majitel = new Majitel();
			}
			//majitel.setId(0); 
			majitel.setEmail(mailZakaznika);
			majitel.setTelefon(telefonZakaznika);
			majitel.setJmeno(jmenoZakaznika);
			majitel.setPrijmeni(prijmeniZakaznika);
			majitel.setMesto(mestoZakaznika);
			majitel.setPsc(pscZakaznika);
			majitel.setUlice(uliceZakaznika);
			majitel.setUliceCisloOrientacni(cisloPopisneZakaznika);
			majitel.setUliceCisloPopisne(cisloOrientacniZakaznika);
			Databaze.getInstance().saveMajitel(majitel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e){
			JOptionPane.showMessageDialog(contentPane, e.getMessage());
		}
	}
}
