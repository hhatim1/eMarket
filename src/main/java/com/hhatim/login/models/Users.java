package com.hhatim.login.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, message="First name is too short")
	@Pattern(regexp="[a-zA-Z]*" , message="only letters and spaces")
	private String first_name;
	@Size(min=2, message="Last name is too short")
	@Pattern(regexp="[a-zA-Z]*", message="only letters and spaces")
	private String last_name;
	
	@Email
	@Size(min=2, message="Email is too short")
	private String email;
	//@DateTimeFormat(pattern = "dd/MM/yyyy") was used not correct all the time
	@DateTimeFormat(pattern="yyyy-MM-dd") //from stack overflow: The pattern should be "yyyy-MM-dd"
	//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Past
	private Date birthday;
	@Size(min=3, message="Password is too short")
	private String password;
	private Date createdAt;
	private Date updatedAt;
	private Date lastloggedIn;
	
	@PrePersist()
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	
	@PreUpdate()
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public Date getLastloggedIn() {
		return lastloggedIn;
	}


	public void setLastloggedIn(Date lastloggedIn) {
		this.lastloggedIn = lastloggedIn;
	}
	

}
