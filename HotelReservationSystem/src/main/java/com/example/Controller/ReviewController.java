package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Review;
import com.example.Entity.DTO.ReviewDTO;
import com.example.Entity.DTO.ReviewDTOforHotel;
import com.example.Service.Impl.ReviewServiceImpl;

@RestController
public class ReviewController {

	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	
	
	@PostMapping("/hotel/review/{hid}/{uid}")
	public ReviewDTO postNewReview(@RequestBody Review r,@PathVariable int hid,@PathVariable int uid) {
		return reviewServiceImpl.postNewReview(r, hid, uid);
	}
	
	@GetMapping("/hotel/reviews")
	public List<ReviewDTO> getallreview(){
		return reviewServiceImpl.getAllReviews();
	}
	
	@GetMapping("/hotel/reviews/getByHid/{hid}")
	public List<ReviewDTOforHotel> getReviewsByHid(@PathVariable int hid){
		return reviewServiceImpl.getReviewsByHotelId(hid);
	}
	
	@PutMapping("/hotel/reviews/update/{rid}/{uid}")
	public ReviewDTO updateReview(@RequestBody Review r,@PathVariable int rid,@PathVariable int uid) {
		return reviewServiceImpl.updateReview(r,rid,uid);
	}
	
	
}
