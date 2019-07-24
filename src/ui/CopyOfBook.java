package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;

import library_system.SystemController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class CopyOfBook{

	private JTextField textField;
	private JButton btnaddCopy;

	
	
	public void addCopyOfBook(JPanel add_copy_of_book_panel) {
		

		JLabel lblISBN = new JLabel("ENTER BOOK ISBN");
		lblISBN.setForeground(new Color(255, 255, 255));
		lblISBN.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblISBN.setBounds(170, 78, 200, 53);
		add_copy_of_book_panel.add(lblISBN);

		textField = new JTextField();
		textField.setBounds(380, 91, 243, 34);
		add_copy_of_book_panel.add(textField);
		textField.setColumns(15);

		btnaddCopy = new JButton("ADD COPY");
		btnaddCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String iSBN = textField.getText();
				if(iSBN.trim().isEmpty()) {
					JOptionPane.showMessageDialog(add_copy_of_book_panel, "Please Enter ISBN");
					return;
				}
				SystemController sc = new SystemController();
				sc.addCopyOfBook(iSBN);
				textField.setText("");
			}
		});
		btnaddCopy.setForeground(Color.GREEN);
		btnaddCopy.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnaddCopy.setBounds(420, 166, 200, 44);
		add_copy_of_book_panel.add(btnaddCopy);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\images\\copypng.png"));
		lblNewLabel.setBounds(44, 40, 105, 148);
		add_copy_of_book_panel.add(lblNewLabel);
	}

}
