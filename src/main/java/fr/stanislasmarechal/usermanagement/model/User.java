package fr.stanislasmarechal.usermanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class representing user data.
 * 
 * @author Stanislas Marechal
 *
 */
@Entity
public class User {
	private static final String PIPE = " | ";
	@Id
	@GeneratedValue
	Long id;
	String email;
	String password;
	String firstName;
	String address;

	public User() {

	}

	public User(String email, String password, String firstName, String address) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("User {");
		sb.append("id=");
		sb.append(id);
		sb.append(PIPE);
		sb.append(firstName);
		sb.append(PIPE);
		sb.append(address);
		sb.append(PIPE);
		sb.append(email);
		sb.append("}");
		return super.toString();
	}
	

}
