package project2;

public class User {
	private String username; 
	private String firstName;
	private String lastName;
	private String password; 
	String webArray[][] = new String[50][2];
	
	public User(String s, String f, String l, String p) {
		username = s; 
		firstName = f;
		lastName = l;
		password = p;
	} 
	public String getUsername() {
		return username; 
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String u) {
		username = u;
	}
	public void setFirstName(String f) {
		firstName = f;
	}
	public void setLastName(String l) {
		lastName = l;
	}
	public void setPassword(String p) {
		password = p;
	}
}
