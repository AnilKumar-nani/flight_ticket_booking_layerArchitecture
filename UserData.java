package flight_layer_architecture;

public class UserData {
	private String name;
	private String mobNum;
	private String gender;
	private String dob;
	private String email;
	private String password;
	public UserData() {}
	
	public UserData(String name, String mobNum, String gender, String dob, String email, String password) {
		super();
		this.name = name;
		this.mobNum = mobNum;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
