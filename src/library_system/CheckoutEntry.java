package library_system;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


public class CheckoutEntry implements Serializable {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy book;
	private CheckoutRecord checkoutRecord;
	private boolean returned;
	
	public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, BookCopy book, CheckoutRecord checkoutRecord) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.book = book;
		this.checkoutRecord = checkoutRecord;
		checkoutRecord.addCheckoutEntry(this);
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public BookCopy getBook() {
		return book;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	

	public boolean isReturned() {
		return returned;
	}

	public void setReturnedStatus(boolean returned) {
		this.returned = returned;
	}

	@Override
	public String toString() {
		return "CheckoutEntry [checkoutDate=" + checkoutDate + ", dueDate=" + dueDate + ", book=" + book.getBook().getiSBN()
				+"]";
	}
	
	
}
