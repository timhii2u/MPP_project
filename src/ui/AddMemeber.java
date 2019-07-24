package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import library_system.Address;
import library_system.SystemController;
import javax.swing.SwingConstants;

public class AddMemeber {
	public JButton btnaddMember;

	private JTextField txtMemID;
	private JTextField txtMemFisrt;
	private JTextField txtMemLast;
	private JTextField txtStreetAdd;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtPhNumber;

	public AddMemeber() {
	}
	
	
	
	public void addMember(JPanel add_member_panel) {

		JLabel lblmemberID = new JLabel("Member ID");
		lblmemberID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmemberID.setForeground(new Color(255, 255, 255));
		lblmemberID.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblmemberID.setBounds(304, 56, 140, 16);
		add_member_panel.add(lblmemberID);
		
		txtMemID = new JTextField();
		txtMemID.setBounds(470, 56, 259, 22);
		add_member_panel.add(txtMemID);
		txtMemID.setColumns(15);

		
		JLabel lblmemberFirst = new JLabel("First Name");
		lblmemberFirst.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmemberFirst.setForeground(new Color(255, 255, 255));
		lblmemberFirst.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblmemberFirst.setBounds(304, 100, 140, 16);
		add_member_panel.add(lblmemberFirst);
		
		txtMemFisrt = new JTextField();
		txtMemFisrt.setBounds(470, 100, 259, 22);
		add_member_panel.add(txtMemFisrt);
		txtMemFisrt.setColumns(15);


		JLabel lblmemeberLast = new JLabel("Last Name");
		lblmemeberLast.setHorizontalAlignment(SwingConstants.RIGHT);
		lblmemeberLast.setForeground(new Color(255, 255, 255));
		lblmemeberLast.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblmemeberLast.setBounds(304, 150, 140, 16);
		add_member_panel.add(lblmemeberLast);

		txtMemLast = new JTextField();
		txtMemLast.setBounds(470, 150, 259, 22);
		add_member_panel.add(txtMemLast);
		txtMemLast.setColumns(15);
		
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreetName.setForeground(new Color(255, 255, 255));
		lblStreetName.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblStreetName.setBounds(304, 200, 140, 16);
		add_member_panel.add(lblStreetName);
		
		txtStreetAdd = new JTextField();
		txtStreetAdd.setBounds(470, 200, 259, 22);
		add_member_panel.add(txtStreetAdd);
		txtStreetAdd.setColumns(10);



		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblCity.setBounds(304, 250, 140, 16);
		add_member_panel.add(lblCity);

		txtCity = new JTextField();
		txtCity.setBounds(470, 250, 259, 22);
		add_member_panel.add(txtCity);
		txtCity.setColumns(15);
		
		
		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setForeground(new Color(255, 255, 255));
		lblState.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblState.setBounds(304, 300, 140, 16);
		add_member_panel.add(lblState);

		txtState = new JTextField();
		txtState.setBounds(470, 300, 259, 22);
		add_member_panel.add(txtState);
		txtState.setColumns(15);
		
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZipCode.setForeground(new Color(255, 255, 255));
		lblZipCode.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblZipCode.setBounds(304, 350, 140, 16);
		add_member_panel.add(lblZipCode);
		
		txtZip = new JTextField();
		txtZip.setBounds(470, 350, 259, 22);
		add_member_panel.add(txtZip);
		txtZip.setColumns(15);
		
		

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setForeground(new Color(255, 255, 255));
		lblPhoneNumber.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(304, 400, 140, 16);
		add_member_panel.add(lblPhoneNumber);

		txtPhNumber = new JTextField();
		txtPhNumber.setBounds(470, 400, 259, 22);
		add_member_panel.add(txtPhNumber);
		txtPhNumber.setColumns(15);
		

		JButton btnaddMember = new JButton("ADD");
		btnaddMember.setBackground(new Color(0, 0, 102));
		btnaddMember.setForeground(new Color(255, 255, 255));
		btnaddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String memberID = txtMemID.getText();
				String firstName = txtMemFisrt.getText();
				String lastName = txtMemLast.getText();
				String streetName = txtStreetAdd.getText();
				String city = txtCity.getText();
				String state = txtState.getText();
				String zipCode = txtZip.getText();
				String phoneNumber = txtPhNumber.getText();


				if(!(validateMemberFields(add_member_panel))) {
					return;
				}
				
				SystemController sc= new SystemController();
				sc.addMemberToSystem(memberID, firstName, lastName,  phoneNumber ,new Address(streetName ,city ,state , zipCode ));
				
				txtMemID.setText("");;
				txtMemFisrt.setText("");
				txtMemLast.setText("");
				txtStreetAdd.setText("");
			    txtCity.setText("");
				 txtState.setText("");
				txtZip.setText("");
				txtPhNumber.setText("");
              

			}
		});
		btnaddMember.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnaddMember.setBounds(500, 460, 230, 50);
		add_member_panel.add(btnaddMember);

		JLabel lblmemebers = new JLabel("");
		lblmemebers.setBackground(new Color(255, 228, 181));
		lblmemebers.setIcon(
		new ImageIcon(System.getProperty("user.dir") + "\\src\\images\\members-icon.png"));
		lblmemebers.setBounds(32, 56, 241, 282);
		add_member_panel.add(lblmemebers);
	}
	
	private boolean validateMemberFields(JPanel add_member_panel) {
		String memberID = txtMemID.getText();
		String firstName = txtMemFisrt.getText();
		String lastName = txtMemLast.getText();
		String streetName = txtStreetAdd.getText();
		String city = txtCity.getText();
		String state = txtState.getText();
		String zipCode = txtZip.getText();
		String phoneNumber = txtPhNumber.getText();
		
		if(memberID.trim().isEmpty()||firstName.trim().isEmpty()||lastName.trim().isEmpty()||streetName.trim().isEmpty()||city.trim().isEmpty()||
				state.trim().isEmpty()||zipCode.trim().isEmpty()||phoneNumber.trim().isEmpty()) {
			JOptionPane.showMessageDialog(add_member_panel, "Please Fill all the fields");

			return false;

		}
		return true;
	}
	
	
}
