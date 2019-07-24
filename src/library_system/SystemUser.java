package library_system;

import java.io.Serializable;

public class SystemUser extends Person implements Serializable {

	private static final long serialVersionUID = 107406355909657558L;

	private String userId;
	private String password;
	private Authorization auth;

	

	public SystemUser(String userId, String password, Authorization auth) {
		super();
		this.userId=userId;
		this.password=password;
		this.auth=auth;
	}
	
	public SystemUser() {
		userId=null;
		password=null;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public Authorization getAuth() {
		return auth;
	}

	@Override
	public String toString() {
		return "Users [UsersId=" + userId + ", password=" + password + ", auth=" + auth + "]";
	}
	
	

}
