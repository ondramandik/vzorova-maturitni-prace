package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prihlaseni extends JFrame {

	private JPanel contentPane;
	private JTextField textJmeno;
	private JTextField textHeslo;
	private JLabel labelJmeno;
	private JLabel labelHeslo;
	private JButton buttonPrihlasit;

	/**
	 * Create the frame.
	 */
	public Prihlaseni() {
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setTitle("Přihlášení");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 208);
		setVisible(true);
		//setLayout(new FlowLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setLayout(new FlowLayout());
		
		labelJmeno = new JLabel("Přihlašovací jméno: ");
		labelJmeno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelJmeno.setBounds(28, 29, 151, 20);
		contentPane.add(labelJmeno);
		
		labelHeslo = new JLabel("Heslo: ");
		labelHeslo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelHeslo.setBounds(28, 62, 56, 16);
		contentPane.add(labelHeslo);
		
		textJmeno = new JTextField();
		textJmeno.setBounds(188, 27, 116, 22);
		contentPane.add(textJmeno);
		textJmeno.setColumns(10);
		
		textHeslo = new JTextField();
		textHeslo.setBounds(188, 60, 116, 22);
		contentPane.add(textHeslo);
		textHeslo.setColumns(10);
		
		buttonPrihlasit = new JButton("OK");
		buttonPrihlasit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//sem udelat prihlaseni
			}
		});
		buttonPrihlasit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPrihlasit.setBounds(207, 108, 97, 25);
		contentPane.add(buttonPrihlasit);
	}
}
