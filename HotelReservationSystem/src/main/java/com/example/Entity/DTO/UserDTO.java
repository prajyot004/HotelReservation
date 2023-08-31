package com.example.Entity.DTO;

import java.util.List;

import com.example.Entity.Reservation;
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
public class UserDTO {

	private int userId;
	private String name;
	private long contactNo;
	private String email;
}
