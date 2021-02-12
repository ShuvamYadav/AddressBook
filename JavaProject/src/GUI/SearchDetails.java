package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthTextFieldUI;

import DatabaseOperations.Person;

public class SearchDetails extends JFrame {
	public static JFrame frame;

	public static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new SearchDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchDetails() {
		JTextField textField;
		textField = new JTextField();
		JTextField textField_1 = new JTextField();
		Icon icon = new ImageIcon(this.getClass().getResource("/addressbook_1.png"));
		Icon icon1 = new ImageIcon(this.getClass().getResource("/search-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel(icon);
		lblNewLabel_2.setBounds(13, 24, 95, 92);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Firstname:");
		lblNewLabel.setBounds(118, 35, 74, 14);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname:");
		lblNewLabel_1.setBounds(118, 60, 74, 14);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton(icon1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person p=new Person();
				p.searchDetails(textField.getText().toString(), textField_1.getText().toString());
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		btnNewButton.setBounds(175, 93, 90, 35);
		contentPane.add(btnNewButton);
		textField.setBounds(202, 33, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_1.setBounds(202, 60, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);	
	}


}
