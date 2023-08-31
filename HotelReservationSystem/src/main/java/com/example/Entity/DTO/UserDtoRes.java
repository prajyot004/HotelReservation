package com.example.Entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoRes {

	private int userId;
	private String name;
	private long contactNo;
	private String email;
}
