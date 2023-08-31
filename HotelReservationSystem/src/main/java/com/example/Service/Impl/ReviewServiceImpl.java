package com.example.Service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Hotel;
import com.example.Entity.Reservation;
import com.example.Entity.Review;
import com.example.Entity.User;
import com.example.Entity.DTO.ReviewDTO;
import com.example.Entity.DTO.ReviewDTOforHotel;
import com.example.Repository.HotelRepository;
import com.example.Repository.ReviewRepository;
import com.example.Repository.UserRepository;
import com.example.Service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	

	@Override
	public ReviewDTO updateReview(Review r,int rid,int uid) {
		// TODO Auto-generated method stub
		Optional<Review> op = reviewRepository.findById(rid);
		Optional<User> op2 = userRepository.findById(uid);
		if(op.isPresent() && op2.isPresent()) {
			Review r1 = op.get();
			if(r1.getUser().getUserId() == uid) {
				r1.setComment(r.getComment());
				r1.setHotel(r.getHotel());
				r1.setRating(r.getRating());
				r1.setReviewDate(r.getReviewDate());
				r1.setUser(r.getUser());
				Review savedReview =  reviewRepository.save(r1);
				return modelMapper.map(savedReview, ReviewDTO.class);				
			}
			
		}
		return null;
	}

	@Override
	public Review getReviewById(int id) {
		// TODO Auto-generated method stub
		Optional<Review> op = reviewRepository.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public List<ReviewDTO> getAllReviews() {
		// TODO Auto-generated method stub
		List<Review> lst = reviewRepository.findAll();
		return lst.stream().map(rv -> modelMapper.map(rv, ReviewDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteReservation(int id) {
		// TODO Auto-generated method stub
		Optional<Review> op = reviewRepository.findById(id);
		if(op.isPresent()) {
			reviewRepository.deleteById(id);
		}
		return "Review deleted" ;
		
	}

	@Override
	public ReviewDTO postNewReview(Review r, int hid, int uid) {
		// TODO Auto-generated method stub
		
		Optional<Hotel> h1 = hotelRepository.findById(hid);

		Optional<User> user = userRepository.findById(uid);
		
		if(user.isPresent()) {
			r.setUser(user.get());
			
		}
		
		if(h1.isPresent()) {
			r.setHotel(h1.get());
			Hotel hotel = h1.get();
			hotel.getReviews().add(r);
			
		}
		
		Review r1 = reviewRepository.save(r);
		
		
		return modelMapper.map(r1, ReviewDTO.class);
	}

	
	
	@Override
	public List<ReviewDTOforHotel> getReviewsByHotelId(int hid) {
		// TODO Auto-generated method stub
		Optional<Hotel> op = hotelRepository.findById(hid);
		if(op.isPresent()) {
			List<Review> lst = op.get().getReviews();
			return lst.stream().map(rv -> modelMapper.map(rv, ReviewDTOforHotel.class )).collect(Collectors.toList());
		}
		return null;
	}

	

}
