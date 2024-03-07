package sample;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class student {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
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
	public student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 370, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("student registration");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(85, 11, 205, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(115, 83, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tb1 = new JTextField();
		tb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tb1.setBackground(new Color(202, 251, 255));
		tb1.setBounds(193, 80, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(107, 128, 76, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tb2 = new JTextField();
		tb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		tb2.setBackground(new Color(202, 251, 255));
		tb2.setBounds(193, 125, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("BRANCH");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(107, 166, 66, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox cb1 = new JComboBox();
		cb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		cb1.setBackground(new Color(202, 251, 255));
		cb1.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "CSE", "IT", "DS", "ECE"}));
		cb1.setMaximumRowCount(5);
		cb1.setBounds(193, 162, 86, 22);
		frame.getContentPane().add(cb1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String roll=tb1.getText();
				int id=Integer.parseInt(roll);
				String name=tb2.getText();
				String branch=(String)cb1.getSelectedItem();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mrec");
					String q="insert into students values('"+id+"','"+name+"','"+branch+"')";
					Statement stn=con.createStatement();
					stn.executeUpdate(q);
					JOptionPane.showMessageDialog(btnNewButton, "record inserted");
					con.close();
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(130, 214, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\online lab\\Desktop\\tt.jfif"));
		lblNewLabel_4.setBounds(0, 0, 360, 261);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
