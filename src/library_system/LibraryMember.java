package library_system;

import java.io.Serializable;
import java.time.LocalDate;

public class LibraryMember extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7672499502853032120L;
	private String memberId;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(String memberId, String fName, String lName, String phoneNumber, Address address) {
		super(fName, lName, phoneNumber, address);
		this.memberId = memberId;
		this.checkoutRecord = new CheckoutRecord();
	}

	public CheckoutRecord viewRecord(String id) {

		return new CheckoutRecord();

	}

	public void computeFine() {

	}

	
	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void checkout(LocalDate checkoutDate, LocalDate dueDate, BookCopy book) {
		CheckoutEntry checkoutEntry = new CheckoutEntry(checkoutDate, dueDate, book, this.getCheckoutRecord());
		this.getCheckoutRecord().addCheckoutEntry(checkoutEntry);
	}

	public String getMemberId() {
		return memberId;
	}

	@Override
	public String toString() {
		return "LibraryMember [memberId=" + memberId + "]";
	}
	
	
}
