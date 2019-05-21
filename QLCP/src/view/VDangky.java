package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import controller.CDangky;;
public class VDangky {

	private JFrame frame;
	public JTextField txtUsername;
	public JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VDangky window = new VDangky();
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
	public VDangky() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(70, 74, 60, 14);
		frame.getContentPane().add(lbUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(167, 71, 86, 20);
		frame.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(167, 114, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBounds(70, 117, 46, 14);
		frame.getContentPane().add(lbPassword);
		
		JButton btnDky = new JButton("Dang ky");
		btnDky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=txtUsername.getText();
				String b=txtPassword.getText(); 
				String[] arr= new String[2];
				arr[0]=a;
				arr[1]=b;
				try {
					CDangky.insert("acc","usename", "password", arr);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidKeyException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalBlockSizeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BadPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDky.setBounds(167, 195, 86, 23);
		frame.getContentPane().add(btnDky);
		
	}
}
