package view;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import controller.CKhachhang;
import controller.CThemmon;
import controller.Ccheckint;
import java.awt.Button;
import javax.swing.JScrollPane;
import dataconnect.Dataconnet;
import net.proteanit.sql.DbUtils;
public class VKhachhang {

	private JFrame frame;
	private JTextField txtHoten;
	private JTextField txtSDT;
	private JTextField txtDiachi;
	private JTextField txtEmail;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VKhachhang window = new VKhachhang();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public VKhachhang() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnThm = new JButton("Th\u00EAm");
		btnThm.setBounds(152, 190, 89, 35);
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtHoten.getText().equals("")||txtSDT.getText().equals("")||txtDiachi.getText().equals("")||txtEmail.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please complete the information section");
				else
					if(Ccheckint.check(txtSDT.getText())==false||txtSDT.getText().length()!=10)
							{				
						JOptionPane.showMessageDialog(null, "Please enter the phone number with ten numbers into the unit price");
							}
					else
						{
							Object[] data=new Object[5];
							data[0]="id";
							data[1]=txtHoten.getText();
							data[2]=Integer.parseInt(txtSDT.getText());
							data[3]=txtDiachi.getText();
							data[4]=txtEmail.getText();
							try {
								CKhachhang.insert(data);
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnThm);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel.setBounds(27, 59, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("S\u0110T");
		lblNewLabel_1.setBounds(27, 84, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_2.setBounds(27, 109, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(27, 137, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtHoten = new JTextField();
		txtHoten.setBounds(81, 56, 221, 20);
		frame.getContentPane().add(txtHoten);
		txtHoten.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(81, 81, 221, 20);
		txtSDT.setColumns(10);
		frame.getContentPane().add(txtSDT);
		
		txtDiachi = new JTextField();
		txtDiachi.setBounds(81, 109, 221, 20);
		txtDiachi.setColumns(10);
		frame.getContentPane().add(txtDiachi);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(81, 134, 221, 20);
		txtEmail.setColumns(10);
		frame.getContentPane().add(txtEmail);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 59, 517, 233);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Load d\u1EEF li\u1EC7u kh\u00E1ch h\u00E0ng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mysql = " select * from KhachHangThanThiet";
				PreparedStatement ps = null;
				try {
					ps = Dataconnet.connet().prepareStatement(mysql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					rs = ps.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		btnNewButton.setBounds(544, 25, 149, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
