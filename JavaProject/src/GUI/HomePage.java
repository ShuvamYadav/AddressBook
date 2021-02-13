package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Icon icon = new ImageIcon(this.getClass().getResource("/search-icon.png"));
		Icon icon1 = new ImageIcon(this.getClass().getResource("/table-insert-icon.png"));
		Icon icon2 = new ImageIcon(this.getClass().getResource("/addressbook_main.png"));
		Icon icon3 = new ImageIcon(this.getClass().getResource("/Monitor-icon.png"));
		Icon icon4 = new ImageIcon(this.getClass().getResource("/symbol-delete-icon.png"));
		frame = new JFrame("ADDRESSBOOK");
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 748, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton_2 = new JButton(icon1);
		btnNewButton_2.setText("INSERT");
		btnNewButton_2.setBounds(88, 251, 154, 82);
		btnNewButton_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDetails ad = new AddDetails();
				// ad.setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton(icon);
		btnNewButton_3.setText("SEARCH");
		btnNewButton_3.setBounds(288, 235, 154, 50);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchDetails sd = new SearchDetails();
				sd.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		btnNewButton_3.setFocusable(false);
		frame.getContentPane().add(btnNewButton_3);
		// DISPLAY Button
		JButton btnExit = new JButton(icon3);
		btnExit.setText("DISPLAY");
		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AllDisplayDetails add = new AllDisplayDetails();
				add.setVisible(true);
			}
		});
		btnExit.setBounds(490, 252, 154, 82);
		btnExit.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		frame.getContentPane().add(btnExit);
		JButton btnExit_1 = new JButton(icon4);
		btnExit_1.setText("EXIT");
		btnExit_1.setFocusable(false);
		btnExit_1.setBounds(288, 313, 154, 50);
		btnExit_1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
		frame.getContentPane().add(btnExit_1);
		JLabel lblNewLabel = new JLabel(icon2);
		lblNewLabel.setBounds(128, 11, 454, 213);
		frame.getContentPane().add(lblNewLabel);
	}
}