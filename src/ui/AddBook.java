package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import library_system.Address;
import library_system.Author;
import library_system.Book;
import library_system.SystemController;

import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class AddBook {

	private JTextField txtTitle;
	private JTextField txtISBN;

	private JTextField txtNumcopies;
	private JTextField txtFirst;
	private JTextField txtStreet;
	private JTextField txtState;
	private JTextField txtPhone;
	private JTextField txtShortBio;
	private JTextField txtLast;
	private JTextField txtCity;
	private JTextField txtzip;
	private JTextField txtCredentials;
	Book b = new Book();
	
	
	
	
	public void addNewBook(JPanel add_book_panel) {

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblTitle.setBounds(66, 152, 220, 16);
		add_book_panel.add(lblTitle);

		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setForeground(Color.WHITE);
		lblISBN.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblISBN.setBounds(66, 201, 220, 16);
		add_book_panel.add(lblISBN);

		JLabel lblNumOfCopies = new JLabel("Number Of Copies");
		lblNumOfCopies.setForeground(Color.WHITE);
		lblNumOfCopies.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNumOfCopies.setBounds(66, 255, 220, 16);
		add_book_panel.add(lblNumOfCopies);

		txtTitle = new JTextField();
		txtTitle.setBounds(253, 151, 248, 22);
		add_book_panel.add(txtTitle);
		txtTitle.setColumns(15);

		txtISBN = new JTextField();
		txtISBN.setFont(new Font("Roboto", Font.PLAIN, 15));
		txtISBN.setBounds(253, 199, 248, 22);
		add_book_panel.add(txtISBN);
		txtISBN.setColumns(15);

		txtNumcopies = new JTextField();
		txtNumcopies.setBounds(253, 254, 248, 22);
		add_book_panel.add(txtNumcopies);
		txtNumcopies.setColumns(15);

		JLabel lblbook = new JLabel("NEW BOOK");
		lblbook.setForeground(Color.WHITE);
		lblbook.setFont(new Font("SansSerif", Font.BOLD, 22));
		lblbook.setBounds(64, 77, 237, 39);
		add_book_panel.add(lblbook);

		

		JPanel pnlAuthor = new JPanel();
		pnlAuthor.setForeground(new Color(230, 230, 250));
		pnlAuthor.setBackground(new Color(128, 128, 128));
		pnlAuthor.setBounds(0, 0, 830, 600);
		pnlAuthor.setLayout(null);

		JLabel label = new JLabel("AUTHORS");
		label.setBounds(29, 50, 146, 29);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("SansSerif", Font.BOLD, 22));
		pnlAuthor.add(label);

		txtFirst = new JTextField();
		txtFirst.setBounds(180, 100, 216, 26);
		txtFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFirst.setColumns(15);
		pnlAuthor.add(txtFirst);
		

		JLabel label_1 = new JLabel("First Name");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(30, 100, 150, 24);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_1);


		txtStreet = new JTextField();
		txtStreet.setBounds(180, 150, 216, 26);
		txtStreet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtStreet.setColumns(15);
		pnlAuthor.add(txtStreet);

		JLabel label_2 = new JLabel("Street Name");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(29, 150, 150, 24);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_2);

		JLabel label_3 = new JLabel("State");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(29, 200, 150, 24);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_3);

		txtState = new JTextField();
		txtState.setBounds(180, 200, 216, 26);
		txtState.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtState.setColumns(10);
		pnlAuthor.add(txtState);

		JLabel label_4 = new JLabel("Phone Number");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(29, 250, 150, 24);
		label_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_4);

		txtPhone = new JTextField();
		txtPhone.setBounds(180, 250, 216, 26);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		pnlAuthor.add(txtPhone);

		JLabel label_5 = new JLabel("ShortBio");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(432, 300, 150, 24);
		label_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_5);

		txtShortBio = new JTextField();
		txtShortBio.setBounds(547, 300, 216, 90);
		txtShortBio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtShortBio.setColumns(50);
		pnlAuthor.add(txtShortBio);

		JLabel label_6 = new JLabel("Last Name");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(432, 100, 150, 24);
		label_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_6);

		txtLast = new JTextField();
		txtLast.setBounds(547, 100, 216, 26);
		txtLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLast.setColumns(15);
		pnlAuthor.add(txtLast);

		JLabel label_7 = new JLabel("City");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(432, 150, 150, 24);
		label_7.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_7);

		txtCity = new JTextField();
		txtCity.setBounds(547, 150, 216, 26);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCity.setColumns(15);
		pnlAuthor.add(txtCity);

		txtzip = new JTextField();
		txtzip.setBounds(547, 200, 216, 26);
		txtzip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtzip.setColumns(10);
		pnlAuthor.add(txtzip);

		JLabel label_8 = new JLabel("Zip Code");
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(432, 200, 150, 24);
		label_8.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_8);

		JLabel label_9 = new JLabel("Credentials");
		label_9.setForeground(Color.WHITE);
		label_9.setBounds(427, 250, 150, 24);
		label_9.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnlAuthor.add(label_9);

		txtCredentials = new JTextField();
		txtCredentials.setBounds(547, 250, 216, 26);
		txtCredentials.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCredentials.setColumns(10);
		pnlAuthor.add(txtCredentials);

		
		JButton btnadd = new JButton("ADD");
		btnadd.setBackground(new Color(51, 102, 204));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtFirst.getText();
				String lastName = txtLast.getText();
				String streetName = txtStreet.getText();
				String city = txtCity.getText();
				String state = txtState.getText();
				String zipcode = txtzip.getText();
				String phoneNumber = txtPhone.getText();
				String credentials = txtCredentials.getText();
				String shortBio = txtShortBio.getText();
				
				if(!(validateAuthorFields(add_book_panel))) {
					return;
				}
				
				Author author = new Author(firstName, lastName, phoneNumber,
						new Address(streetName, city, state, zipcode), credentials, shortBio);
				b.add(author);
				JOptionPane.showMessageDialog(add_book_panel, "Author added Successfully!!");
				txtFirst.setText("");
				txtLast.setText("");
				txtStreet.setText("");
				txtCity.setText("");
				txtState.setText("");
				txtzip.setText("");
				txtPhone.setText("");
				txtCredentials.setText("");
				txtShortBio.setText("");

			}
		});
		btnadd.setBounds(643, 420, 120, 45);
		btnadd.setForeground(Color.WHITE);
		btnadd.setFont(new Font("SansSerif", Font.PLAIN, 18));
		pnlAuthor.add(btnadd);
		
		JButton btnfinish = new JButton("FINISH");
		btnfinish.setBackground(new Color(51, 51, 102));
		btnfinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(validateAllFields(add_book_panel))) {
					return;
				}
				
				SystemController sc = new SystemController();

				sc.addBookToSystem(txtISBN.getText(), txtTitle.getText(), b.getAurthors(),
						Integer.parseInt(txtNumcopies.getText()));
				add_book_panel.removeAll();
				add_book_panel.repaint();
				add_book_panel.revalidate();
				addNewBook(add_book_panel);

			}
		});
		btnfinish.setForeground(Color.WHITE);
		btnfinish.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnfinish.setBounds(620, 500, 143, 54);
		pnlAuthor.add(btnfinish);

		JButton btnnext = new JButton("NEXT");
		btnnext.setBackground(new Color(51, 51, 102));
		btnnext.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnnext.setForeground(Color.WHITE);
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title = txtTitle.getText();
				String isbn = txtISBN.getText();
				String numCopies = txtNumcopies.getText();
				
				if(!(validateBookFields(add_book_panel))) {
					return;
				}
				add_book_panel.removeAll();
				add_book_panel.add(pnlAuthor);

				add_book_panel.repaint();
				add_book_panel.revalidate();
			}
		});
		btnnext.setBounds(345, 332, 156, 54);
		add_book_panel.add(btnnext);
	}
	
	private boolean validateAuthorFields(JPanel add_book_panel) {
		String firstName = txtFirst.getText();
		String lastName = txtLast.getText();
		String streetName = txtStreet.getText();
		String city = txtCity.getText();
		String state = txtState.getText();
		String zipcode = txtzip.getText();
		String phoneNumber = txtPhone.getText();
		String credentials = txtCredentials.getText();
		String shortBio = txtShortBio.getText();
		
		if(firstName.trim().isEmpty()||lastName.trim().isEmpty()||streetName.trim().isEmpty()||city.trim().isEmpty()||
				state.trim().isEmpty()||zipcode.trim().isEmpty()||phoneNumber.trim().isEmpty()||credentials.trim().isEmpty()||shortBio.trim().isEmpty()) {
			JOptionPane.showMessageDialog(add_book_panel, "Please Fill all the fields");

			return false;

		}
		return true;
	}
	
	private boolean validateBookFields(JPanel add_book_panel) {
		
		
		String title = txtTitle.getText();
		String isbn = txtISBN.getText();
		String numCopies = txtNumcopies.getText();
		
		if(title.trim().isEmpty()||isbn.trim().isEmpty()||numCopies.trim().isEmpty()) {
			JOptionPane.showMessageDialog(add_book_panel, "Please Fill all the fields");

			return false;

		}else if(!numCopies.trim().isEmpty()){
			try {
				Integer.parseInt(txtNumcopies.getText());
				return true;
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(add_book_panel, "Number of Copies Field must be Numeric");

				return false;
			}	
		}
		
		return true;
		
	}
	
	
	
	private boolean validateAllFields(JPanel add_book_panel) {
		String firstName = txtFirst.getText();
		String lastName = txtLast.getText();
		String streetName = txtStreet.getText();
		String city = txtCity.getText();
		String state = txtState.getText();
		String zipcode = txtzip.getText();
		String phoneNumber = txtPhone.getText();
		String credentials = txtCredentials.getText();
		String shortBio = txtShortBio.getText();
		
		if(!firstName.trim().isEmpty()||!lastName.trim().isEmpty()||!streetName.trim().isEmpty()||!city.trim().isEmpty()||
				!state.trim().isEmpty()||!zipcode.trim().isEmpty()||!phoneNumber.trim().isEmpty()||!credentials.trim().isEmpty()||
				!shortBio.trim().isEmpty()) {
			JOptionPane.showMessageDialog(add_book_panel, "Please Complete Adding the Author first");

			return false;

		}else if(b.getAurthors().isEmpty()) {
			JOptionPane.showMessageDialog(add_book_panel, "You Must Add atleast one Author");

			return false;

		}else {
			return true;

		}
	}
}
