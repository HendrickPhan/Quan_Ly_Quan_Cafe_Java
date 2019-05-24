package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import controller.CThemmon;
import controller.Ccheckint;
public class VThemmon {

	private JFrame frame;
	private JTextField txtTenmon;
	private JTextField txtDongia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VThemmon window = new VThemmon();
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
	public VThemmon() {
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
		
		JButton btnTmon = new JButton("Th\u00EAm");
		btnTmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTenmon.getText().equals("")||txtDongia.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please complete the information section");
				else
					if(Ccheckint.check(txtDongia.getText())==false)
							{
						JOptionPane.showMessageDialog(null, "Please enter the number into the unit price");
							}
					else
						{
							txtDongia.getInsets();
							Object[] data=new Object[2];
							data[0]=txtTenmon.getText();
							data[1]=Integer.parseInt(txtDongia.getText());
							try {
								CThemmon.insert(data);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
			}
		});
		btnTmon.setBounds(211, 197, 89, 23);
		frame.getContentPane().add(btnTmon);
		
		JLabel lbTenmon = new JLabel("T\u00EAn m\u00F3n");
		lbTenmon.setBounds(65, 71, 79, 14);
		frame.getContentPane().add(lbTenmon);
		
		txtTenmon = new JTextField();
		txtTenmon.setBounds(154, 68, 193, 20);
		frame.getContentPane().add(txtTenmon);
		txtTenmon.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel.setBounds(65, 122, 79, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtDongia = new JTextField();
		txtDongia.setBounds(154, 119, 193, 20);
		frame.getContentPane().add(txtDongia);
		txtDongia.setColumns(10);
	}

}
