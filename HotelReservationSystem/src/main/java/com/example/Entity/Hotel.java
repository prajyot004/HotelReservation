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
import javax.validation.constraints.NotNull;
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
	private String name;
	
	@NotBlank(message = "Place is required")
	private String place;
	
	@NotBlank(message = "Address is required")
	private String Address;
	
	@Positive(message = "Contact number must be positive")
	private long ContactNo;
	
	@Email(message = "Email should be valid")
	private String Email;
	
	@NotBlank(message = "Atleast mention one facility")
	private String PlaceOffers;
	
	@Positive(message = "Cost per day must be positive")
	private double CostPerDay;
	
	@Positive(message = "Hourly cost must be positive")
	private double HourlyCost;
	
	@NotBlank(message = "Enter Overview of hotel")
	@Size(min = 10,max = 100, message = "size should be less than 100 words and more than 10 words")
	private String Overview;
	
	@NotBlank(message = "Atleast mention one facility")
	private String bookingType;
	
	@Min(value = 1, message = "Number of rooms should be at least 1")
	private int NoOfRooms;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@Min(value = 0, message = "Overall rating should be at least 0")
    @Max(value = 5, message = "Overall rating should not exceed 5")
	private int overallRating;
	
	@NotBlank(message = "Enter about of your hotel")
	@Size(min = 10,max = 300, message = "size should be less than 300 words and more than 10 words")
	private String about;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	@NotNull(message = "manager should be assign to hotel")
	private Manager manager;
	
	
}
