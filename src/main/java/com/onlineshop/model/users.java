package com.onlineshop.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_data")
public class users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	 String  username;
	
	 String email;
	 String password;
	 String registeras;
	
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getRegisteras() {
		return registeras;
	}
	public void setRegisteras(String registeras) {
		this.registeras = "user";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id,username, email, password, registeras);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		users other = (users) obj;
		return Objects.equals(id, other.id) && Objects.equals(username, other.username) && Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(registeras, other.registeras);
	}
	@Override
	public String toString() {
		return "users [id=" + id + ", username=" + username + ", email=" + email + ", registeras=" + registeras + "]";
	}
	
	
	
	
	
	
}
