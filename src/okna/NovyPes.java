package okna;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NovyPes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public NovyPes() {
		setTitle("Pes");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 432);
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
		textField.setBounds(148, 34, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnUlozit = new JButton("Uložit");
		btnUlozit.setBounds(24, 328, 97, 25);
		contentPane.add(btnUlozit);
		
		btnUlozit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				//uloženi nebo update psa
			}
		});
		
		repaint();
	}
}
