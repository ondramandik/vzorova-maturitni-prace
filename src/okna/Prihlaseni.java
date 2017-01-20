package okna;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import entity.Recepcni;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Prihlaseni extends JFrame {

	private JPanel contentPane;
	private JTextField textJmeno;
	private JPasswordField textHeslo;
	private JLabel labelJmeno;
	private JLabel labelHeslo;
	private JButton buttonPrihlasit;

	/**
	 * Create the frame.
	 */
	public Prihlaseni() {
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setTitle("Přihlášení");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 208);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		contentPane.setLayout(null);
		
		
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
		
		textHeslo = new JPasswordField();
		textHeslo.setBounds(188, 60, 116, 22);
		contentPane.add(textHeslo);
		textHeslo.setColumns(10);
		
		buttonPrihlasit = new JButton("OK");
		buttonPrihlasit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String uzivatelskeJmeno = textJmeno.getText().trim();
				String heslo = new String(textHeslo.getPassword()).trim();
				try {
					Recepcni.prihlas(uzivatelskeJmeno, heslo);
					if (Recepcni.getPrihlasenyRecepcni()==null){
						JOptionPane.showMessageDialog(contentPane, "Neplatné přihlášení!");
					} else {
						new HlavniOkno();
						zavriOkno();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		buttonPrihlasit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonPrihlasit.setBounds(207, 108, 97, 25);
		contentPane.add(buttonPrihlasit);
		
		repaint();
	}
	
	public void zavriOkno(){
		this.dispose();
	}
}
