package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NovyZakaznik extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the frame.
	 */
	public NovyZakaznik() {
		setTitle("Nový zákazník");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJmno = new JLabel("Jméno:");
		lblJmno.setBounds(26, 37, 56, 16);
		contentPane.add(lblJmno);
		
		JLabel lblPjmen = new JLabel("Příjmení:");
		lblPjmen.setBounds(26, 78, 56, 16);
		contentPane.add(lblPjmen);
		
		textField = new JTextField();
		textField.setBounds(154, 34, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 75, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUlice = new JLabel("Název ulice:");
		lblUlice.setBounds(26, 123, 79, 16);
		contentPane.add(lblUlice);
		
		JLabel lblNewLabel = new JLabel("Číslo popisné:");
		lblNewLabel.setBounds(26, 165, 90, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblsloOrientan = new JLabel("Číslo orientační:");
		lblsloOrientan.setBounds(26, 212, 107, 16);
		contentPane.add(lblsloOrientan);
		
		textField_2 = new JTextField();
		textField_2.setBounds(154, 120, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(154, 162, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(154, 209, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Město: ");
		lblNewLabel_1.setBounds(26, 257, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PSČ:");
		lblNewLabel_2.setBounds(26, 295, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(154, 244, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(154, 292, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(26, 340, 56, 16);
		contentPane.add(lblTelefon);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(26, 385, 56, 16);
		contentPane.add(lblEmail);
		
		textField_7 = new JTextField();
		textField_7.setBounds(154, 337, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(154, 379, 116, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnUloit = new JButton("Uložit");
		btnUloit.setBounds(26, 459, 97, 25);
		contentPane.add(btnUloit);
		
	}
}
