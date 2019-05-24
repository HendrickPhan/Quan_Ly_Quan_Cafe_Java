package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import controller.CDonvi;
public class VDonvi {

	private JFrame frame;
	private JTextField txtDonvi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VDonvi window = new VDonvi();
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
	public VDonvi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 295, 152);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Th\u00EAm \u0111\u01A1n v\u1ECB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDonvi.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please complete the information section");
				else
				{
					Object[] data=new Object[2];
					data[0]="id";
					data[1]=txtDonvi.getText();
					try {
						CDonvi.insert(data);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(94, 72, 120, 30);
		frame.getContentPane().add(btnNewButton);
		
		txtDonvi = new JTextField();
		txtDonvi.setBounds(117, 24, 120, 20);
		frame.getContentPane().add(txtDonvi);
		txtDonvi.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0110\u01A1n v\u1ECB t\u00EDnh");
		lblNewLabel.setBounds(38, 27, 69, 14);
		frame.getContentPane().add(lblNewLabel);
	}

}
