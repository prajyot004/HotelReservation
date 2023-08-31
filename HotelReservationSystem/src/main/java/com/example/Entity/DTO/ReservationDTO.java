package com.example.Entity.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.example.Entity.Hotel;
import com.example.Entity.Manager;
import com.example.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ReservationDTO {

	int ResId;
	
	HdtoForRes hotel;
	
	UserDtoRes user;
	
//	private LocalDate checkInDate;
//	private int NoOfDaysToStay;
//	private LocalDate checkOutDate;
//	private LocalDateTime reservationDate;
//
//	private String specialRequests;
//	private int guestCount;
//	private String confirmationCode;
	
//	public Manager manager;
	
	private String checkInDate;
	private int NoOfDaysToStay;
	private String checkOutDate;
	private String reservationDate;

	private String specialRequests;
	private int guestCount;
	private String confirmationCode;
	
}
