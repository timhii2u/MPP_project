package data_store;


import library_system.Book;
import library_system.LibraryMember;
import library_system.SystemUser;

public interface DataAccess {
	public void saveLibraryMember(String name, LibraryMember member);
	public LibraryMember readLibraryMember(String name);
	public void saveBook(String iSBN, Book book);
	public Book searchBook(String iSBN);
	public void saveUsers(String id, SystemUser member);
	public SystemUser readUsers(String id);
}
