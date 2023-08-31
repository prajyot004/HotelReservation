package com.example.Entity.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.Entity.Manager;
import com.example.Entity.Review;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class HdtoForRes {
	private int Hid;
	
	private String name;
	
	private String place;
	
	private String Address;
	
	private long ContactNo;
	
	private String Email;
	
	private String PlaceOffers;
	
	private double CostPerDay;
	
	private double HourlyCost;
	
	private String Overview;
	
	private String BookingType;
	
	private int NoOfRooms;
	
//	private List<Review> revies;
	
	private int overallRating;
	
	private String about;
	
	private ManagerDto2 manager;
}
