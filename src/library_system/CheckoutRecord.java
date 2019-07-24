package library_system;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5687957732730696910L;
	private ArrayList<CheckoutEntry> entryList;
	
	
	
	public CheckoutRecord() {
		this.entryList = new ArrayList();
	}

	public void addCheckoutEntry(CheckoutEntry entry) {
		if(!entryList.contains(entry)) {
			entryList.add(entry);
		}
	}
	
	public ArrayList<CheckoutEntry> getEntryList() {
		return entryList;
	}

	public double computeFine() {
		double fine = 0.0;
		for (CheckoutEntry entry : entryList) {
			if(LocalDate.now().isAfter(entry.getDueDate()) && !entry.isReturned()) {
				fine += 10;
			}
		}
		return fine;
	}

	@Override
	public String toString() {
		return "[entryList=" + entryList.toString() + "]";
	}
	
	
}
