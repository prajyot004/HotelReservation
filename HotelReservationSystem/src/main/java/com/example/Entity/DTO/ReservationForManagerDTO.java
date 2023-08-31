package com.example.Entity.DTO;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.Entity.Hotel;
import com.example.Entity.Manager;
import com.example.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationForManagerDTO {

	public int ResId;

	public UserDTO user;

//	private LocalDate checkInDate;
//	private int NoOfDaysToStay;
//	private LocalDate checkOutDate;
//	private LocalDateTime reservationDate;
//
//	private String specialRequests;
//	private int guestCount;
//	private String confirmationCode;
	
	
  // This should be the actual column name in your database
//    private Manager manager;
	
	private String checkInDate;
	private int NoOfDaysToStay;
	private String checkOutDate;
	private String reservationDate;

	private String specialRequests;
	private int guestCount;
	private String confirmationCode;
	
}
