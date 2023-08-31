package com.example.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotEmpty(message = "Name  cannot be empty")
	@Size(min = 3,max = 20)
	private String name;
	
	@NotNull(message = "contact number cannot be empty")
	private long contactNo;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email
	private String email;
	
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 8,max = 16,message = "Password should be minimum 8 character and maximum 16")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Role> roles;
	
}
