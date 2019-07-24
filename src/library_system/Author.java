package library_system;


public class Author extends Person {

	private String credentials;
    private String shortBio;
	
    public Author(String fName, String lNAme, String phoneNum, Address a,String c, String sB) {
		super(fName, lNAme, phoneNum,a);
		credentials=c;
		shortBio=sB;
	     
	}

	public String getCredentials() {
		return credentials;
	}

	public String getShortBio() {
		return shortBio;
	}
    
    
	
}