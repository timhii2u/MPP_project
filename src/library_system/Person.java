package library_system;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 3665880920647848288L;
	private String fName ;
	private String lName;
	private String phoneNum;
	private Address a;
	
	public Person(String fName, String lName, String phoneNum, Address a) {
		this.fName = fName ;
		this.lName =lName;
		this.phoneNum = phoneNum ;
		this.a= a;
	}
	public Person() {
		
	}
	public String getFirstName() {
		return fName;
	}
	public String getLastName() {
		return lName;
	}
	public String getTelephone() {
		return  phoneNum ;
	}
	public Address getAddress() {
		return a;
	}

}
