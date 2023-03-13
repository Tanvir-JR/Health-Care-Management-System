package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import doctor.Doctor;
import drugs.Drugs;
import employee.Employee;
import nurse.Nurse;
import patient.Patient;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Main {

	private JFrame frmHealthCareManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHealthCareManagement = new JFrame();
		frmHealthCareManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/resource/main.jpg")));
		frmHealthCareManagement.setTitle(" Health Care Management System");
		frmHealthCareManagement.setBounds(100, 100, 471, 165);
		frmHealthCareManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient.main(null);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Doctor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor.main(null);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Health Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_2 = new JButton("Nurse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nurse.main(null);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Employee");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee.main(null);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Drugs");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drugs.main(null);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmHealthCareManagement.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3)))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_3)))
		);
		frmHealthCareManagement.getContentPane().setLayout(groupLayout);
	}
}
