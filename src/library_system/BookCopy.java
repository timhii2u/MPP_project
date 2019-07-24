package library_system;

import java.io.Serializable;

public class BookCopy implements Serializable{

	private int copyID;
	private boolean availabile;
	private Book book;

	private static final long serialVersionUID = -342214173957734594L;

	
	public BookCopy(Book book, int ID, boolean avail) {
		this.book = book;
		this.copyID = ID;
		this.availabile = avail;
	}


	public boolean isAvailabile() {
		return availabile;
	}

	public void setAvailabile(boolean availabile) {
		this.availabile = availabile;
	}


	public int getCopyID() {
		return copyID;
	}


	public Book getBook() {
		return book;
	}
	
	public String getStatus() {
		if(this.availabile) {
			return "Available";
		}else {
			return "Out";

		}
	}
}
