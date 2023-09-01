package com.example.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "Mid")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Mid;
	
	@NotEmpty(message = "ManagerName  cannot be empty")
	@Size(min = 3,max = 20,message = "ManagerName should be Minimum 3 character and Maximum 20 charater long")
	private String name;
	
	@Min(value = 1000000000L, message = "Contact number must be at least 10 digits")
    @Max(value = 9999999999L, message = "Contact number can't be more than 10 digits")
	private long contactNo;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "manager")
	@JoinColumn(name = "hotel_id")
	@JsonBackReference
	private Hotel hotel;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("hotel")
	private List<Reservation> reservations = new ArrayList<>();
	
	
	
}
