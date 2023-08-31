package com.example.Entity.DTO;

import java.util.Date;

import com.example.Entity.Hotel;
import com.example.Entity.User;
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
public class ReviewDTO2 {
	
	private String UserName;
	
	private int rating;
	
	private Date reviewDate;
	
	private String comment;

}
