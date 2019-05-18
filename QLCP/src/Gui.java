import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gui {

	private JFrame fDky;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.fDky.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fDky = new JFrame();
		fDky.setBounds(100, 100, 450, 300);
		fDky.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fDky.getContentPane().setLayout(null);
		
		JButton btnDky = new JButton("Dang ky");
		btnDky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtUsername.getText().equals("")||txtPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(btnDky, "Ban hay dien day du thong tin");
				}
				else
					try {
						String dbURL="jdbc:sqlserver://localhost;databaseName=Dky;user=sa;password=sa";
						Connection con = DriverManager.getConnection(dbURL);
						 if (con != null) 
						      System.out.println("Connected");
						String sql="INSERT INTO [TKhoan] ([Usename],[Password]) values ('han','han')";
						Statement sta=con.createStatement();
						sta.execute(sql);
					}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnDky.setBounds(186, 199, 86, 23);
		fDky.getContentPane().add(btnDky);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(63, 48, 60, 14);
		fDky.getContentPane().add(lbUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(186, 45, 86, 20);
		fDky.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(186, 87, 86, 20);
		fDky.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBounds(63, 90, 46, 14);
		fDky.getContentPane().add(lbPassword);
	}
}
