package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import DBConnection.DBCon;
import DatabaseOperations.Person;

public class AddDetails extends JFrame {

	public static JPanel contentPane;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	public static JFrame frame;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_7;
	public static JTextField textField_6;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					 frame = new AddDetails();
//					 frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddDetails() {
		frame =new JFrame();
		Icon icon = new ImageIcon(this.getClass().getResource("/addressbook_1.png"));
		Icon icon1 = new ImageIcon(this.getClass().getResource("/addressbook_save.png"));
		Icon icon2 = new ImageIcon(this.getClass().getResource("/addressbook_cancel.png"));
		// size of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 539, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		// image on top left corner of frame
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(10, 30, 105, 122);
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("addressbook_1.png")));
		contentPane.add(lblNewLabel);

		// Title - JLabel
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(125, 45, 62, 14);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);

		// Title - JcomboBox - Mr./Ms./Miss
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13));
		comboBox.addItem("Mr.");
		comboBox.addItem("Mrs.");
		comboBox.addItem("Ms.");
		comboBox.setBounds(210, 40, 266, 17);
		contentPane.add(comboBox);

		// Firstname - JLabel
		JLabel lblNewLabel_2 = new JLabel("Firstname:");
		lblNewLabel_2.setBounds(125, 62, 74, 14);
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);

		// Firstname - JtextField
	    textField = new JTextField();
		textField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField.setBounds(210, 60, 266, 16);
		contentPane.add(textField);
		textField.setColumns(10);

		// Surname - JLabel
		JLabel lblNewLabel_3 = new JLabel("Surname:");
		lblNewLabel_3.setBounds(125, 80, 62, 14);
		lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_3);

		// Surname - JtextField
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_1.setBounds(210, 80, 266, 16);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		// Gender - JLabel
		JLabel lblNewLabel_4 = new JLabel("Gender:");
		lblNewLabel_4.setBounds(125, 97, 62, 14);
		lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_4);

		// Gender - JCheckBox - Male/Female/Other
		chckbxNewCheckBox = new JCheckBox("Male");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxNewCheckBox.isSelected()) {
					chckbxNewCheckBox_1.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);

				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(208, 97, 62, 14);
		contentPane.add(chckbxNewCheckBox);

		chckbxNewCheckBox_1 = new JCheckBox("Female");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox_1.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);

				}
			}
		});
		chckbxNewCheckBox_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBounds(274, 97, 74, 14);
		contentPane.add(chckbxNewCheckBox_1);

		chckbxNewCheckBox_2 = new JCheckBox("Other");
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox_2.isSelected()) {
					chckbxNewCheckBox.setSelected(false);
					chckbxNewCheckBox_1.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
		chckbxNewCheckBox_2.setBounds(362, 97, 97, 14);
		contentPane.add(chckbxNewCheckBox_2);

		// Date of Birth - JLabel
		JLabel lblNewLabel_5 = new JLabel("Date of Birth:");
		lblNewLabel_5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(125, 114, 95, 14);
		contentPane.add(lblNewLabel_5);

		// Date of Birth - JDateChooser
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 11));
		dateChooser.setBounds(211, 115, 114, 16);
		contentPane.add(dateChooser);

		// CONTACT DETAILS ------.... - JLabel
		JLabel lblNewLabel_6 = new JLabel("CONTACT DETAILS ------------------------------------------------");
		lblNewLabel_6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(125, 140, 350, 14);
		contentPane.add(lblNewLabel_6);
		
		// Address - JLabel
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(125, 165, 62, 14);
		contentPane.add(lblNewLabel_7);
		
        // Street - JLabel
		JLabel lblNewLabel_8 = new JLabel("Street:");
		lblNewLabel_8.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(210, 166, 46, 14);
		contentPane.add(lblNewLabel_8);
		
        // Street - JtextField
		 textField_2 = new JTextField();
		textField_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_2.setBounds(288, 165, 188, 16);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
        // City - JLabel
		JLabel lblNewLabel_9 = new JLabel("City:");
		lblNewLabel_9.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(210, 185, 46, 14);
		contentPane.add(lblNewLabel_9);

		// City - JtextField
		 textField_3 = new JTextField();
		textField_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_3.setBounds(288, 183, 188, 16);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		// State - JLabel
		JLabel lblNewLabel_10 = new JLabel("State:");
		lblNewLabel_10.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(210, 204, 46, 14);
		contentPane.add(lblNewLabel_10);
		// State - JtextField
		 textField_4 = new JTextField();
		textField_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_4.setBounds(288, 202, 188, 16);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		// Pin Number - JLabel
		JLabel lblNewLabel_11 = new JLabel("Pin Number:");
		lblNewLabel_11.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(210, 222, 77, 14);
		contentPane.add(lblNewLabel_11);

		// Pin Number - JtextField
		 textField_5 = new JTextField();
		textField_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_5.setBounds(288, 220, 188, 16);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		// Phone - JLabel
		JLabel lblNewLabel_12 = new JLabel("Phone:");
		lblNewLabel_12.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_12.setBounds(125, 261, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		// Phone - JcomboBox - +91/+033
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13));
		comboBox_1.addItem("+91");
		comboBox_1.addItem("+033");
		comboBox_1.setBounds(210, 259, 54, 16);
		contentPane.add(comboBox_1);
		
		// Phone - JtextField 
		 textField_7 = new JTextField();
		textField_7.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_7.setBounds(268, 259, 127, 16);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		// Email - JLabel
		JLabel lblNewLabel_14 = new JLabel("Email:");
		lblNewLabel_14.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		lblNewLabel_14.setBounds(125, 311, 46, 14);
		contentPane.add(lblNewLabel_14);

		// Email - JtextField
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
		textField_6.setBounds(210, 311, 266, 17);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		// Save Button
		JButton btnNewButton = new JButton(icon1);
		btnNewButton.setText("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// storing details of users in variables
				String title = comboBox.getSelectedItem().toString();
				String firstName = textField.getText();
				String surName = textField_1.getText();
				String gender = null;
				if(chckbxNewCheckBox.isSelected()) {               // male
					gender = chckbxNewCheckBox.getText();
				}
				if(chckbxNewCheckBox_1.isSelected()) {             // female
					gender=chckbxNewCheckBox_1.getText();
				}
				if(chckbxNewCheckBox_2.isSelected()) {            // other
					gender = chckbxNewCheckBox_2.getText();
				}
				java.util.Date dob = dateChooser.getDate();
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dateOfBirth = formatter.format(dob);
				String street = textField_2.getText();
				String city = textField_3.getText();
				String state = textField_4.getText();
				int pinNumber = Integer.parseInt(textField_5.getText());
				String phone = comboBox_1.getSelectedItem().toString() +" "+ textField_7.getText();
				String email = textField_6.getText();
				//System.out.println(title+firstName+surName+gender+correctDate+street+city+state+pinNumber+phone+email);
				
				Person p = new Person();
				p.addDetails(title,firstName,surName,gender,dateOfBirth,street,city,state,pinNumber,phone,email);
				//p.addDetails(title, firstName, surName, gender, dateOfBirth);
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnNewButton.setBounds(151, 350, 103, 30);
		contentPane.add(btnNewButton);
		

		// Cancel Button 
		JButton btnNewButton_2 = new JButton(icon2);
		btnNewButton_2.setText("CANCEL");
		btnNewButton_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(270, 350, 103, 30);
		contentPane.add(btnNewButton_2);
		frame.setVisible(true);

	}
}
