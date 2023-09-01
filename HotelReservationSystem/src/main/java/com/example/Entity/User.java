package com.example.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
	@Size(min = 3,max = 20,message = "Name should be Minimum 3 character and Maximum 20 charater long")
	private String name;
	
	@Min(value = 1000000000L, message = "Contact number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Contact number can't be more than 10 digits")
	private long contactNo;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email
	private String email;
	
	@Size(min = 8, max = 61, message = "Password length must be between 8 and 16 characters")
    @Pattern(regexp = "^(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.*\\d)(?=.*[A-Z])(?!.*\\s).*$",
    message = "Password must contain at least one special character, one digit, and one capital letter")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Role> roles;
	
}
