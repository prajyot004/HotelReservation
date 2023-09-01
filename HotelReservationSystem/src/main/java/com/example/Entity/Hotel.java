package com.example.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "Hid")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Hid;
	
	@NotBlank(message = "Name is required")
    @Size(min = 4, max = 50, message = "Name must be between 2 and 50 characters")
	private String name;
	
	@NotBlank(message = "Place is required")
    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Place must be between 3 and 20 characters, no special characters, spaces, or numbers allowed")
	private String place;
	
	@NotBlank(message = "Address is required")
    @Size(min = 10, max = 100, message = "Address must be between 3 and 100 characters")
	private String Address;
	
	@Min(value = 1000000000L, message = "Contact number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Contact number can't be more than 10 digits")
	private long ContactNo;
	
	@NotEmpty(message = "Email cannot be empty")
	@Email
	private String Email;
	
	@NotBlank(message = "Atleast mention one facility")
	private String PlaceOffers;
	
	@Positive(message = "Cost per day must be positive")
	@Min(value = 350, message = "Cost per day must be greater than or equal to 350 rs")
	private double CostPerDay;
	
	@Positive(message = "Cost per day must be positive")
	@Min(value = 50, message = "Cost per Hour must be greater than or equal to 50 rs")
	private double HourlyCost;
	
	@NotBlank(message = "Enter Overview of hotel")
	@Size(min = 10,max = 300, message = "size should be less than 300 words and more than 10 words")
	private String Overview;
	
	@Pattern(regexp = "(?i)^(online|offline)$", message = "Booking type must be either 'online' or 'offline' (case-insensitive (\"online,\" \"Online,\" \"OFFLINE,\" \"ofFlinE,\" and so on))")
	private String bookingType;
	
	@Min(value = 1, message = "Number of rooms should be at least 1")
	private int NoOfRooms;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	
	private int overallRating;
	
	@NotBlank(message = "Enter about of your hotel")
	@Size(min = 10,max = 300, message = "size should be less than 300 words and more than 10 words")
	private String about;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@NotNull(message = "manager should be assign to hotel")
	private Manager manager;
	
	
}
