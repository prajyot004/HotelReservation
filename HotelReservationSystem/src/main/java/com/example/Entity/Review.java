package com.example.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ReviewId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Hotel hotel;

	@Min(value = 1, message = "Rating should be at least 1")
    @Max(value = 5, message = "Rating should not exceed 5")
	private int rating; // Rating out of 5

	@Temporal(TemporalType.TIMESTAMP)
	private Date reviewDate;

	@NotBlank(message = "Comment is required")
	@Column(columnDefinition = "TEXT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private String comment;
}
