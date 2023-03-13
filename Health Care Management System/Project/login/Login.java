package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import main.Main;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class Login {

	private JFrame frmHealthCareManagement;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmHealthCareManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHealthCareManagement = new JFrame();
		frmHealthCareManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHealthCareManagement.setTitle(" Health Care Management System");
		frmHealthCareManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/resource/main.jpg")));
		frmHealthCareManagement.setBounds(100, 100, 370, 350);
		frmHealthCareManagement.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Login System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(59, 10, 249, 70);
		frmHealthCareManagement.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(59, 125, 76, 32);
		frmHealthCareManagement.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(59, 167, 76, 35);
		frmHealthCareManagement.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(145, 134, 147, 19);
		frmHealthCareManagement.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String username = textField.getText();
					String password = passwordField.getText();
					
					if(username.contains("project") && password.contains("demo")) {
						textField.setText(null);
						passwordField.setText(null);
						
						Main.main(null);
						frmHealthCareManagement.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
				}
					
			}
		});
		
		passwordField.setBounds(145, 177, 147, 19);
		frmHealthCareManagement.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				if(username.contains("project") && password.contains("demo")) {
					textField.setText(null);
					passwordField.setText(null);
					
					Main.main(null);
					frmHealthCareManagement.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
			}

		});
		btnNewButton.setBounds(123, 232, 85, 21);
		frmHealthCareManagement.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_1.setBounds(123, 278, 85, 21);
		frmHealthCareManagement.getContentPane().add(btnNewButton_1);
	}
}
