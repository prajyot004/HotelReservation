package com.example.Service;

import java.util.List;

import com.example.Entity.Review;
import com.example.Entity.DTO.ReviewDTO;
import com.example.Entity.DTO.ReviewDTOforHotel;

public interface ReviewService {

	public ReviewDTO postNewReview(Review r,int hid,int uid);
	public ReviewDTO updateReview(Review r,int rid,int uid);
	public Review getReviewById(int id);
	public List<ReviewDTO> getAllReviews();
	public String deleteReservation(int id);
	public List<ReviewDTOforHotel> getReviewsByHotelId(int hid);
	
}
