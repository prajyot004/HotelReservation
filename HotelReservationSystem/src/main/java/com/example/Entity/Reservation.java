package com.example.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int ResId;
	
	@OneToOne(cascade = CascadeType.ALL)
	public Hotel hotel;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("roles")
	public User user;

//	private LocalDate checkInDate;
//	private int NoOfDaysToStay;
//	private LocalDate checkOutDate;
//	private LocalDateTime reservationDate;
//
//	private String specialRequests;
//	private int guestCount;
//	private String confirmationCode;
	
//	@JoinColumn(name = )
//	@ManyToOne(cascade = CascadeType.ALL)
////	@JsonManagedReference
//	@JsonManagedReference
//	public Manager manager;
	
//	@ManyToOne
//    @JoinColumn(name = "manager_id")  // This should be the actual column name in your database
//    private Manager manager;
	
//	private String checkInDate;
//	private int NoOfDaysToStay;
//	private String checkOutDate;
//	private String reservationDate;
//
//	private String specialRequests;
//	private int guestCount;
//	private String confirmationCode;
	
	@NotBlank(message = "Check-in date is required")
    private String checkInDate;

    @Min(value = 1, message = "Number of days to stay should be at least 1")
    private int NoOfDaysToStay;

    @NotBlank(message = "Check-out date is required")
    private String checkOutDate;

    @NotBlank(message = "Reservation date is required")
    private String reservationDate;

    private String specialRequests;

    @Min(value = 1, message = "Guest count should be at least 1")
    private int guestCount;

    @NotBlank(message = "Confirmation code is required")
    private String confirmationCode;
	
	

	
	
	
}
