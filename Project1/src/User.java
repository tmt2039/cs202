
public class User {
	
	private String email, userName, password, photo, phone;
	private Person person;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserN() {
		return userName;
	}

	public void setUserN(String userN) {
		this.userName = userN;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "User(" + "email='" + email + '\'' + "\n, userN='" + userName + '\'' + "\n, password='" + password + '\''
				+ "\n, photo=' " + photo + '\'' + "\n, phone='" + phone + '}';
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
}
