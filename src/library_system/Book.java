package library_system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ui.AddMemeber;
import ui.Main_view;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7931187865731993747L;
	/**
	 * 
	 */
	private String iSBN;
	private String title;
	private List<Author> authors = new ArrayList<Author>();
	private List<BookCopy> copies;
	private int maxCheckoutLength;
	private int numOfCopies;

	public Book() {

	}

	public Book(String isbn, String title, List<Author> authors, int numOfCopies) {
		this.iSBN = isbn;
		this.title = title;
		this.authors = authors;
		copies = new ArrayList<BookCopy>();
		this.maxCheckoutLength =7;
		this.numOfCopies = numOfCopies;
		this.addCopies();
	}

	public void addCopies() {
		for (int i = 1; i <= numOfCopies; i++) {
			copies.add(new BookCopy(this, i, true));
		}
	}

	public String getTitle() {
		return title;
	}

	public List<Author> getAurthors() {
		return authors;
	}

	public List<BookCopy> getCopies() {
		return copies;
	}

	public String getiSBN() {
		return iSBN;
	}

	public int getMax_number_of_days() {
		return maxCheckoutLength;
	}

	public void addCopy(BookCopy copy) {
		if (!copies.contains(copy)) {
			copies.add(copy);
		}

	}
	
	public void add(Author a) {
		if (!authors.contains(a)) {
			 authors.add(a);
		}else {
			Main_view mv= new Main_view();
			JOptionPane.showMessageDialog(mv, "Author is already is there !!");
		}
		
	}
	

	@Override
	public String toString() {
		return "Book [iSBN=" + iSBN + ", title=" + title + ", aurthors=" + authors + ", copies=" + copies
				+ ", max_number_of_days=" + maxCheckoutLength + "]";

	}

}