package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import library_system.CheckoutEntry;
import library_system.CheckoutRecord;
import library_system.Book;
import library_system.BookCopy;
import library_system.SystemController;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

public class CheckOut {


	private JTable table;
	private JTextField txtSearch;
	private JTable tblbookList;
	private JTable table_1;
	private String[][] cps = new String[5][];


	
	public CheckOut() {
		
	}

	
	public JTable getTable() {
		return table;
	}


	public JTextField getTxtSearch() {
		return txtSearch;
	}

	public JTable getTblbookList() {
		return tblbookList;
	}

	public JTable getTable_1() {
		return table_1;
	}

	
	public void checkOutBook(SystemController sc, JPanel checkout_panel, ArrayList<CheckoutEntry> entr, String id) {
		
		String[] columns = { "ISBN", "Title", "Checkout Date", "DueDate" };
		
		String[][] entrys = new String[entr.size()][];
		for (int i = 0; i < entr.size(); i++) {
			String[] arr = {entr.get(i).getBook().getBook().getiSBN(), entr.get(i).getBook().getBook().getTitle(),entr.get(i).getCheckoutDate().toString(), entr.get(i).getDueDate().toString()}; 
			entrys[i] =  arr;
		}
		checkout_panel.setLayout(null);
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollpane.setBounds(10, 68, 350, 300);
		checkout_panel.add(scrollpane);
		DefaultTableModel model = new DefaultTableModel(entrys, columns);
		table = new JTable(model);
		scrollpane.setViewportView(table);
		
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Roboto", Font.PLAIN, 15));
		txtSearch.setBounds(600, 400, 159, 37);
		txtSearch.setColumns(10);

		checkout_panel.add(txtSearch);

		JButton btnCheck = new JButton("CHECK OUT");
		btnCheck.setBackground(new Color(0, 0, 102));
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheck.setForeground(new Color(255, 255, 255));
		btnCheck.setBounds(600, 500, 159, 37);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtSearch.getText();
				if(isbn.trim().isEmpty()) {
					JOptionPane.showMessageDialog(checkout_panel, "Please Enter ISBN");
					return;
				}
				sc.checkout(isbn, id);
				checkout_panel.removeAll();
				checkout_panel.repaint();
				checkout_panel.revalidate();
				CheckoutRecord rc = sc.getMemberRecord(id);
				checkOutBook(sc,checkout_panel,rc.getEntryList(),id);
			}

		});
		checkout_panel.add(btnCheck);
		
		JPanel pnlsearchbook = new JPanel();
		pnlsearchbook.setBackground(new Color(0, 0, 153));
		pnlsearchbook.setBorder(new TitledBorder(new LineBorder(new Color(255, 20, 147), 2), "Search Results", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		pnlsearchbook.setBounds(400, 75, 400, 280);

		checkout_panel.add(pnlsearchbook);
		pnlsearchbook.setLayout(null);
		pnlsearchbook.setVisible(false);

		JButton btnsearchBook = new JButton("SEARCH BOOK BY ISBN");
		btnsearchBook.setBackground(new Color(0, 0, 102));
		btnsearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtSearch.getText();
				if(isbn.trim().isEmpty()) {
					JOptionPane.showMessageDialog(checkout_panel, "Please Enter ISBN");
					return;
				}
				sc.searchBook(isbn);
				Book foundBook;
				if ((foundBook = sc.searchBook(isbn)) != null) {
					pnlsearchbook.setVisible(true);
					loadBookData(foundBook);
					System.out.println("Found Book::"+ cps.toString());
					String[] column = { "CopyID", "ISBN", "Title", "Status" };
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 0, 424, 400);
					pnlsearchbook.add(scrollPane);
				
					DefaultTableModel model1 = new DefaultTableModel(cps, column);
					tblbookList = new JTable(model1);
					scrollPane.setViewportView(tblbookList);
					tblbookList.setFont(new Font("Roboto", Font.PLAIN, 16));
					scrollpane.setViewportBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

				} else {

					JOptionPane.showMessageDialog(checkout_panel, "Book Not Found!");

				}
			}
		});
		btnsearchBook.setForeground(new Color(255, 255, 255));
		btnsearchBook.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnsearchBook.setBounds(300, 400, 250, 37);
		checkout_panel.add(btnsearchBook);

	
	}
	
	
	private void loadBookData(Book book) {
		
		List<BookCopy> cpList = book.getCopies();

		String[][] cps = new String[cpList.size()][];
		for (int i = 0; i < cpList.size(); i++) {
			String[] arrbk = {Integer.toString(cpList.get(i).getCopyID()), book.getiSBN(),book.getTitle(), cpList.get(i).getStatus()}; 
			cps[i] =  arrbk;
		}
		this.cps = cps;
	}
}
