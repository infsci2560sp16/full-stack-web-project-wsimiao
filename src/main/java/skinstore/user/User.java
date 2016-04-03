package skinstore.user;

public class User {
	private String userEmail;
	private String userPass;
	public User(String userEmail, String userPass){
		this.userEmail = userEmail;
		this.userPass = userPass;
		
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	

}
