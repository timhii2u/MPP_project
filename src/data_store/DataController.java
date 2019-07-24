package data_store;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import library_system.Book;
import library_system.LibraryMember;
import library_system.SystemUser;

public class DataController implements DataAccess {
	public static final String BOOKS_OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\data_store\\storage\\books";
	
	public static final String MEMBER_OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\data_store\\storage\\members";
	
	public static final String USER_OUTPUT_DIR = System.getProperty("user.dir")
			+ "\\src\\data_store\\storage\\users";
	
//	public static final String BOOKS_OUTPUT_DIR = System.getProperty("user.dir") 
//			+ "/src/data_store/storage/books";
//	
//	public static final String MEMBER_OUTPUT_DIR = System.getProperty("user.dir")
//			+ "/src/data_store/storage/members";
//	
//	public static final String USER_OUTPUT_DIR = System.getProperty("user.dir")
//			+ "/src/data_store/storage/users";
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	

	public void saveLibraryMember(String id, LibraryMember member) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(MEMBER_OUTPUT_DIR, id);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public LibraryMember readLibraryMember(String id){
		ObjectInputStream in = null;
		LibraryMember member = null;
		try {
			Path path = FileSystems.getDefault().getPath(MEMBER_OUTPUT_DIR, id);
			in = new ObjectInputStream(Files.newInputStream(path));
			member = (LibraryMember) in.readObject();
		}catch (NoSuchFileException e) {
			return null;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return member;
	}
	
	public void saveBook(String isbn, Book book) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(BOOKS_OUTPUT_DIR, isbn);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(book);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public Book searchBook(String isbn) {
		ObjectInputStream in = null;
		Book book = null;
		try {
			Path path = FileSystems.getDefault().getPath(BOOKS_OUTPUT_DIR, isbn);
			in = new ObjectInputStream(Files.newInputStream(path));
			book = (Book) in.readObject();
		} catch (NoSuchFileException e) {
			return null;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return book;
	}

	public void saveUsers(String id, SystemUser systemUser) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(USER_OUTPUT_DIR, id);
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(systemUser);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}

	public SystemUser readUsers(String id) {
		ObjectInputStream in = null;
		SystemUser sysUser = null;
		try {
			Path path = FileSystems.getDefault().getPath(USER_OUTPUT_DIR, id);
			in = new ObjectInputStream(Files.newInputStream(path));
			sysUser = (SystemUser)in.readObject();
		}catch (NoSuchFileException e) {
			return null;
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return sysUser;
	}

}