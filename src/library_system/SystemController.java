package library_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data_store.DataAccess;
import data_store.DataController;
import ui.AddBook;
import ui.AddMemeber;
import ui.CheckOut;
import ui.Login;
import ui.Main_view;
import ui.MemberEdit;

public class SystemController {
	private SystemUser currentUser = new SystemUser();
	private ui.CopyOfBook cb = new ui.CopyOfBook();
	private ui.CheckOut co = new ui.CheckOut();
	private Book book;
	private Main_view mv = new Main_view();


	public static Authorization currentAuth = null;

	public SystemController() {

	}

	/*
	 * 
	 * *******************LOGIN ************************
	 * 
	 */

	public void login(String id, String password, Login log) {

		SystemUser nw1 = new SystemUser("4", "1111", Authorization.ADMIN);
		SystemUser nw2 = new SystemUser("5", "11111", Authorization.LIBRARIAN);
		SystemUser nw3 = new SystemUser("6", "111111", Authorization.BOTH);
		DataAccess da = new DataController();


		da.saveUsers("4", nw1);
		da.saveUsers("5", nw2);
		da.saveUsers("6", nw3);

		currentAuth = loginModule(id, password);
		switch (currentAuth) {
		case ADMIN:
			log.getFrame().dispose();

			mv.setVisible(true);
			mv.getCheckout_btn().setVisible(false);
			mv.getPrint_btn().setVisible(false);

			break;
		case LIBRARIAN:
			log.getFrame().dispose();

			mv.setVisible(true);
			mv.getAdd_member_btn().setVisible(false);
			mv.getAdd_book_btn().setVisible(false);
			mv.getAdd_copy_of_book_btn().setVisible(false);
			mv.getEdit_member_btn().setVisible(false);


			break;
		case BOTH:
			log.getFrame().dispose();

			mv.setVisible(true);

			break;

		default:
			JOptionPane.showMessageDialog(log.getBtnLogin(), "Wrong Username or Password");
			break;
		}

	}

	public Authorization loginModule(String id, String password) {
		DataAccess da = new DataController();
		currentUser = da.readUsers(id);
		if (currentUser != null) {
			String passwordFound = currentUser.getPassword();
			if (passwordFound.equals(password)) {
				return currentUser.getAuth();

			} else {
				return Authorization.NONE;

			}
		} else {
			return Authorization.NONE;

		}

	}
	/*
	 * ******************* ADMIN FUNCTIONS ************************
	 */

	public void addMemberToSystem(String id, String fName, String lName, String phoneNumber, Address address) {
		LibraryMember member = new LibraryMember(id, fName, lName, phoneNumber, address);
		LibraryMember lM;
		if ((lM = searchLibMember(id)) != null) {
			JOptionPane.showMessageDialog(mv, "Memeber ID already in use");
			return;
		}
		addNewMember(id, member);
		JOptionPane.showMessageDialog(mv, "Memeber Successfully Added !!");
	}


	public void addBookToSystem(String isbn, String title, List<Author> authors,
			int numOfCopies) {
		book = new Book(isbn, title, authors, numOfCopies);
		Book foundBook;
		if ((foundBook = searchBook(isbn)) != null) {

			if (JOptionPane.showConfirmDialog(null, " Book already exists, Do you want to add it as a copy? ",
					"Request", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
				addCopyOfBook(isbn);
			} else
				return;
		} else {
			addBook(isbn, book);
			JOptionPane.showMessageDialog(mv, "Book Successfully Added!!");

		}
	}

	/*
	 * Add copy of existing book
	 */

	public void addCopyOfBook(String isbn) {

		Book foundBook;
		System.out.println(searchBook(isbn));

		if ((foundBook = searchBook(isbn)) != null) {
			System.out.println(foundBook);
			int num_of_copies = foundBook.getCopies().size();
			foundBook.addCopy(new BookCopy(foundBook, ++num_of_copies, true));
			addBook(isbn, foundBook);
			JOptionPane.showMessageDialog(mv, "Succesfully Added!");

		} else {
			JOptionPane.showMessageDialog(mv,
					"The Book whose Copy you are trying to Add does not Exist in the Data Base!");
			return;

		}

	}

	public Book searchBook(String isbn) {

		DataAccess da = new DataController();
		return da.searchBook(isbn);
	}

	public LibraryMember searchLibMember(String memberId) {

		DataAccess da = new DataController();
		System.out.println("member search " + da.readLibraryMember(memberId));
		return da.readLibraryMember(memberId);

	}

	public void addBook(String isbn, Book book) {

		DataAccess da = new DataController();
		da.saveBook(isbn, book);

	}

	public void addNewMember(String memberId, LibraryMember member) {
		DataAccess da = new DataController();
		da.saveLibraryMember(memberId, member);

	}

	/*
	 * Edit LibMember info functions
	 */
	public void getMemberDetails(String memberID, JPanel edit_member_panel) {
		LibraryMember lM;

		if ((lM = searchLibMember(memberID)) != null) {
			MemberEdit me = new MemberEdit();
			
			edit_member_panel.removeAll();
			
			me.editMember(this,edit_member_panel);
			
			me.getTxtMemID().setText(lM.getMemberId());
			me.getTxtMemFisrt().setText(lM.getFirstName());
			me.getTxtMemLast().setText(lM.getLastName());
			me.getTxtStreetAdd().setText(lM.getAddress().getStreet());
			me.getTxtCity().setText(lM.getAddress().getCity());
			me.getTxtState().setText(lM.getAddress().getState());
			me.getTxtZip().setText(lM.getAddress().getZip());
			me.getTxtPhNumber().setText(lM.getTelephone());

		} else {

			JOptionPane.showMessageDialog(edit_member_panel, "The member doesn'exist!");

		}

	}

	public void confirmEditMember(String id, String fName, String lName, String phoneNumber, Address address) {
		LibraryMember member = new LibraryMember(id, fName, lName, phoneNumber, address);

		addNewMember(id, member);

		

	}

	/*
	 * ********************LIBRARIAN FUNCTIONS ***********************
	 */

	// Get Member details

	public CheckoutRecord getMemberRecord(String memberID) {
		LibraryMember lM;

		if ((lM = searchLibMember(memberID)) != null) {

			CheckoutRecord checkoutRecord = lM.getCheckoutRecord();
			return checkoutRecord;
		} else {
			return null;
		}

	}

	// Display Record in UI

	public void displayMemberRecord(CheckoutRecord rec, String id, JPanel panel) {
		
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
		CheckOut checkout = new CheckOut();
		
		checkout.checkOutBook(this,panel,rec.getEntryList(),id);
		
	}

	
	// checkout function from the UI

	public void checkout(String isbn, String memberID) {

		LibraryMember lM = searchLibMember(memberID);
		// search for book in book store
		Book foundBook = searchBook(isbn);

		// loop through list of copies and check for the first availabile copy

		for (BookCopy copy : foundBook.getCopies()) {

			boolean bookStatus = copy.isAvailabile();

			if (bookStatus) {
				int days = foundBook.getMax_number_of_days();

				lM.checkout(LocalDate.now(), LocalDate.now().plusDays(days), copy);
				
				addNewMember(memberID, lM);

				copy.setAvailabile(false);
				
				addBook(isbn,foundBook);

				JOptionPane.showMessageDialog(mv, "Checkout Successful!");
				return;

			}

		}

		JOptionPane.showMessageDialog(mv, "There is no Copy of this Book Available!");

	}

	/*
	 * 
	 * TODO
	 * 
	 * 
	 * Implement Checkin 
	 */

	public static void main(String[] args) {
		SystemController sc = new SystemController();

		DataAccess da = new DataController();

		System.out.println(da.readUsers("4"));
		sc.loginModule("4", "123");
		System.out.println(sc);
	}

}
