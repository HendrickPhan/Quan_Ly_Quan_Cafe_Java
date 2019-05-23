package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import view.VDangky;
import controller.CDangnhap;
public class VDangnhap {

	private JFrame frame;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VDangnhap window = new VDangnhap();
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
	public VDangnhap() {
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
		
		JButton btnDnhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CDangnhap.login(txtUsername.getText(),txtPassword.getText());
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| IllegalBlockSizeException | BadPaddingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDnhap.setBounds(98, 170, 89, 23);
		frame.getContentPane().add(btnDnhap);
		
		JButton btnDky = new JButton("\u0110\u0103ng k\u00FD");
		btnDky.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				VDangky wieu=new VDangky();
				wieu.main(null);
			}
		});
		btnDky.setBounds(240, 170, 89, 23);
		frame.getContentPane().add(btnDky);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(43, 62, 85, 14);
		frame.getContentPane().add(lbUsername);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBounds(43, 88, 71, 14);
		frame.getContentPane().add(lbPassword);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(138, 59, 191, 20);
		frame.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(138, 85, 191, 20);
		frame.getContentPane().add(txtPassword);
	}
}
