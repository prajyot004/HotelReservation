package com.example.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

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
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@Positive(message = "Contact number must be positive")
	private long contactNo;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "manager")
	@JoinColumn(name = "hotel_id")
	@JsonBackReference
	private Hotel hotel;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Role> roles = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("hotel")
	private List<Reservation> reservations = new ArrayList<>();
	
	
	
}
