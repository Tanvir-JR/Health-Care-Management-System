package patient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Patient {

	private JFrame frmHealthCareManagement;
	private JTable table;
	private JTextField name;
	private JTextField age;
	private JTextField gender;
	private JTextField date;
	private JTextField doctor;
	private JTextField fee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient window = new Patient();
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
	public Patient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHealthCareManagement = new JFrame();
		frmHealthCareManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(Patient.class.getResource("/resource/main.jpg")));
		frmHealthCareManagement.setTitle(" Health Care Management System");
		frmHealthCareManagement.setBounds(100, 100, 1100, 450);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_1 = new JLabel("Age");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_2 = new JLabel("Date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_3 = new JLabel("Patient");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_4 = new JLabel("Doctor");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { name.getText(), age.getText(),gender.getText(), date.getText(), doctor.getText(),fee.getText() });
				String filePath = "Patient.txt";
				File file = new File(filePath);
				try {
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					      for (int i=0;i<model.getRowCount();i++){
					        for (int j=0;j<model.getColumnCount();j++){
					          bw.write(model.getValueAt(i,j).toString()+"\t");
					        }
					        bw.write("\n");
					      }
					      bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewButton_1 = new JButton("Load");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filePath = "Patient.txt";
				File file = new File(filePath);
				try {
				    BufferedReader br = new BufferedReader(new FileReader(file));
				    DefaultTableModel model = (DefaultTableModel) table.getModel();
		             
		             Object[] lines = br.lines().toArray();
		             
		             for(int i=0; i<lines.length; i++)
		             {
		            	 String line = lines[i].toString().trim();
		            	 String[] datarow = line.split("\t");
		            	 model.addRow(datarow);
		             }
		             
		            br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int i = table.getSelectedRow();
			
				if(i>=0) {
					model.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error Deleteing");
				}
			}
		});

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int i = table.getSelectedRow();
			
			if(i>=0) {
				model.setValueAt(name.getText(), i,0);
				model.setValueAt(age.getText(), i, 1);
				model.setValueAt(gender.getText(), i, 2);
				model.setValueAt(date.getText(), i, 3);
				model.setValueAt(doctor.getText(), i, 4);
				model.setValueAt(fee.getText(), i, 5);
			}
			else {
				JOptionPane.showMessageDialog(null, "Error Updating");
			}
			}
		});
		
		
		
		name = new JTextField();
		name.setColumns(10);
		
		age = new JTextField();
		age.setColumns(10);
		
		gender = new JTextField();
		gender.setColumns(10);
		
		date = new JTextField();
		date.setColumns(10);
		
		doctor = new JTextField();
		doctor.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fee");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		fee = new JTextField();
		fee.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmHealthCareManagement.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(358))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel)
												.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(name)
												.addComponent(age, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblNewLabel_4)
													.addGap(18))
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
													.addComponent(btnNewButton)
													.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(18)
													.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(btnNewButton_2)
													.addGap(18)
													.addComponent(btnNewButton_3))
												.addComponent(doctor, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(date, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(gender, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
												.addComponent(fee, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))))
									.addGap(18)))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(doctor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(fee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(30))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Age", "Gender", "Date", "Doctor", "Fee"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		frmHealthCareManagement.getContentPane().setLayout(groupLayout);
	}
}
