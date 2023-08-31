package com.example.Entity.DTO;

import java.util.Date;
import java.util.List;

import com.example.Entity.Hotel;
import com.example.Entity.Review;
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
public class ReviewDTO {
	
	private int ReviewId;
	
	private User user;
	
	@JsonIgnoreProperties("reviews")
	private Hotel hotel;
	
	private int rating;
	
	private Date reviewDate;
	
	private String comment;

}
