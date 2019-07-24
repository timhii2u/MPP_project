package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import library_system.Authorization;
import library_system.CheckoutRecord;
import library_system.SystemController;

public class GetMemberDetails {
	JFrame frame;
	private JTextField textField;

	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	public void showSearchForm(JPanel panel) {
		
		JLabel lblMemberID = new JLabel("ENTER MEMBER ID");
		lblMemberID.setForeground(new Color(255, 255, 255));
		lblMemberID.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblMemberID.setBounds(160, 109, 200, 39);
		panel.add(lblMemberID);

		textField = new JTextField();
		textField.setFont(new Font("Roboto", Font.PLAIN, 15));
		textField.setBounds(391, 112, 262, 37);
		panel.add(textField);
		textField.setColumns(15);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setBackground(new Color(0, 0, 102));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				if(id.trim().isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Please Enter MemberID");
					return;
				}
				SystemController sc = new SystemController();

				sc.getMemberDetails(id,panel);
			}
		});
		btnSearch.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBounds(450, 202, 202, 47);
		panel.add(btnSearch);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\images\\people-search.png"));
		lblNewLabel.setBounds(23, 79, 202, 180);
		panel.add(lblNewLabel);
	}
}
