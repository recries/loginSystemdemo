package dto;

public class AccountDTO {
	private String id, pass,name, email;
	private int user_num;
	
	public AccountDTO() {
	}

	public AccountDTO(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	public AccountDTO(int user_num, String name) {
		this.user_num = user_num;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	
}
