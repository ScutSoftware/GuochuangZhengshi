package com.lis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="t_user")
public class User implements Serializable{
	
	@Id
	@GenericGenerator(name="generator", strategy="assigned")
	@GeneratedValue(generator="generator")
	@Column(name="Name", nullable=false, unique=true)
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a_zA-Z0-9]+$",message="Username must be alphanumeric with no spaces")
	private String name ;
	
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	@Column(name="Password", nullable=false, length=20)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
	
}
