package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@Column(length = 50)
	private String username;
	
	@Column(nullable = false, length = 50)
	private String password;
	
	public Usuario() {}
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public boolean passwordMatches(String password) {
		return this.password.equals(password);
	}
}
