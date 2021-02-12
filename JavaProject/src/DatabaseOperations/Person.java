package DatabaseOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBConnection.DBCon;
import net.proteanit.sql.DbUtils;
import GUI.SearchDetails;

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
	
	public void addDetails(String title, String firstName, String surName, String gender, String dateOfBirth, String street, String city, String state, int pinNumber, String phone,String email) {
		
		Connection con = null;
		Statement st = null;

		try {
			con = DBCon.getConnection();
			PreparedStatement ps = con.prepareCall("INSERT INTO person (title,firstname,surname,gender,dateofbirth,street,city,state,pin,phone,email) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, title);
			ps.setString(2,firstName);
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
        Connection con = null;
        Statement st = null;
        ResultSet rs;
        String[] colum= {"username","password"};
        try {
            con = DBCon.getConnection();
            PreparedStatement ps = con.prepareCall("SELECT * FROM username WHERE username = ? ");
            ps.setString(1, firstname);
            //ps.setString(2, surname);
            rs = ps.executeQuery();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(colum);
        	JTable table = new JTable();
        	table.setModel(model);
        	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        	table.setBounds(50, 140, 200,200);
           // table.setFillsViewportHeight(true);
            while(rs.next()) {
            	model.addRow(new Object[] {rs.getString(1),rs.getString(2)});
            } 
          ;
            SearchDetails.frame.add(table);
        	SearchDetails.frame.repaint();
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
	
}
