package com.example.Entity.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.Entity.Hotel;
import com.example.Entity.Reservation;
import com.example.Entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ManagerDTO {
	
	private int Mid;
	
	private String name;
	
	private long contactNo;
	
	@JsonIgnoreProperties("manager")
	private HotelDTO hotel;
	
	
	private List<Role> roles = new ArrayList<>();
	
	private List<ReservationForManagerDTO> reservations;
	
}
