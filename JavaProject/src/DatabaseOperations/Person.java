package DatabaseOperations;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DBConnection.DBCon;
import GUI.AddDetails;
import GUI.SearchDetails;
import net.proteanit.sql.DbUtils;

public class Person {
	private String title;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String street;
	private String city;
	private String state;
	private int pinNumber;
	private String phone;
	private String email;
	Connection con = null;
	Statement st = null;
	ResultSet rs;

	public void addDetails(String title, String firstName, String surName, String gender, String dateOfBirth,
			String street, String city, String state, int pinNumber, String phone, String email) {

		Connection con = null;
		Statement st = null;

		try {
			con = DBCon.getConnection();
			PreparedStatement ps = con.prepareCall(
					"INSERT INTO person (title,firstname,surname,gender,dateofbirth,street,city,state,pin,phone,email) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2, firstName);
			ps.setString(3, surName);
			ps.setString(4, gender);
			ps.setString(5, dateOfBirth);
			ps.setString(6, street);
			ps.setString(7, city);
			ps.setString(8, state);
			ps.setLong(9, pinNumber);
			ps.setString(10, phone);
			ps.setString(11, email);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Saved!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();

		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}

	}

	public void searchDetails(String firstname, String surname) {
		JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 465, 250);
		SearchDetails.contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		JButton btnNewButton_1 = new JButton("DELETE");
		Icon icon = new ImageIcon(this.getClass().getResource("/addressbook_cancel.png"));
		btnNewButton_1.setIcon(icon);
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_1.setBounds(200, 93, 120, 35);
		SearchDetails.contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 15));
		btnNewButton_2.setBounds(330, 93, 120, 35);
		Icon icon1 = new ImageIcon(this.getClass().getResource("/Text-Edit-icon.png"));
		btnNewButton_2.setIcon(icon1);

		SearchDetails.contentPane.add(btnNewButton_2);

		SearchDetails.contentPane.repaint();

		try {
			con = DBCon.getConnection();
			PreparedStatement ps = con.prepareCall("SELECT * FROM person WHERE firstname = ? AND surname = ?");
			ps.setString(1, firstname);
			ps.setString(2, surname);
			rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					deleteDetails(table.getValueAt(table.getSelectedRow(), 0).toString());

				}

			});

			btnNewButton_2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateDetails(table.getValueAt(table.getSelectedRow(), 0).toString());

				}

			});

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();

		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se2) {
				se2.printStackTrace();
			}
		}
	}

	public void updateDetails(String id) {
		JButton button = new JButton("UPDATE");
		button.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
		Icon icon = new ImageIcon(this.getClass().getResource("/Text-Edit-icon.png"));
		button.setIcon(icon);
		button.setBounds(390, 350, 120, 30);
		try {
			con = DBCon.getConnection();
			PreparedStatement ps = con.prepareCall("SELECT * FROM person WHERE id = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, id);
			rs = ps.executeQuery();
			// AddDetails.main(null);
			rs.next();
			new AddDetails();
			AddDetails.textField.setText(rs.getString(3));
			AddDetails.textField_1.setText(rs.getString(4));
			AddDetails.textField_2.setText(rs.getString(7));
			AddDetails.textField_3.setText(rs.getString(8));
			AddDetails.textField_4.setText(rs.getString(9));
			AddDetails.textField_5.setText(rs.getString(10));
			AddDetails.textField_6.setText(rs.getString(12));
			AddDetails.textField_7.setText(rs.getString(11));
			AddDetails.frame.add(button);
			AddDetails.btnNewButton.setVisible(false);
			AddDetails.frame.repaint();
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					PreparedStatement sp;
					try {
						sp = con.prepareCall(
								"UPDATE person SET firstname=? , surname = ?,street = ?,city = ?,state =?,pin =?,phone = ?, email = ? WHERE id = ?");
						sp.setString(1, AddDetails.textField.getText());
						sp.setString(2, AddDetails.textField_1.getText());
						sp.setString(3, AddDetails.textField_2.getText());
						sp.setString(4, AddDetails.textField_3.getText());
						sp.setString(5, AddDetails.textField_4.getText());
						sp.setString(6, AddDetails.textField_5.getText());
						sp.setString(7, AddDetails.textField_7.getText());
						sp.setString(8, AddDetails.textField_6.getText());
						sp.setString(9, id);
						sp.executeUpdate();
						AddDetails.frame.dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error!");
			e.printStackTrace();
		}

	}

	public void deleteDetails(String id) {

		int input = JOptionPane.YES_NO_OPTION;
		JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the entry?", "WARNING", input);
		if (input == JOptionPane.YES_OPTION) {
			// Person p = new Person();
			try {
				con = DBCon.getConnection();
				PreparedStatement ps = con.prepareCall("DELETE FROM person WHERE id=?");
				ps.setString(1, id);
				ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		} else {
			System.exit(0);
		}

	}
}
