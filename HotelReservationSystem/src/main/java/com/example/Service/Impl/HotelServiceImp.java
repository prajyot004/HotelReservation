package com.example.Service.Impl;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Hotel;
import com.example.Entity.Role;
import com.example.Entity.DTO.HdtoForHotel;
import com.example.Entity.DTO.HotelDTO;
import com.example.Repository.HotelRepository;
import com.example.Repository.ManagerRepository;
import com.example.Repository.RoleRepository;
import com.example.Service.HotelService;

@Service
public class HotelServiceImp implements HotelService{

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RoleRepository roleRepository;

	
	// Get list of all hotels 
	@Override
	public List<HdtoForHotel> findallHotels() {
		
		List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                .map(hotel -> modelMapper.map(hotel, HdtoForHotel.class))
                .collect(Collectors.toList());
	}


//	Find Hotel by Hotel Id
	@Override
	public HdtoForHotel findHotelById(int id) {

//		HotelDTO h1 = HotelToDto(hotelRepository.findById(id).get());
		Optional<Hotel> op = hotelRepository.findById(id);
		if(op.isPresent()) {
			HdtoForHotel h1 = modelMapper.map(op.get(), HdtoForHotel.class);
			return h1;
		}
		return null;
	}

	@Override
	public HotelDTO addNewHotel(Hotel h) {
		// TODO Auto-generated method stub
		Role role = new Role();
		Role role2 = new Role();
		role.setRname("user");
		role2.setRname("manager");
		
		Set<Role> st = new HashSet<>();
		st.add(role);
		st.add(role2);
		if(h.getManager().getRoles().isEmpty()) {
			h.getManager().setRoles(st);
			System.out.println("manager roles "+ h.getManager().getRoles());
			Hotel savedHotel =  hotelRepository.save(h);
			return modelMapper.map(savedHotel, HotelDTO.class);
		}
		
		Hotel savedHotel =  hotelRepository.save(h);
		return modelMapper.map(savedHotel, HotelDTO.class);
	}

	@Override
	public String deleteHotelById(int id) {
		// TODO Auto-generated method stub
		hotelRepository.deleteById(id);
		return "Hotel deleted successfully";
	}

	@Override
	public HotelDTO UpdateHotel(Hotel h,int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> op = hotelRepository.findById(id);
		if(op.isPresent()) {
			Hotel h1 = op.get();
			h1.setAbout(h.getAbout());
			h1.setAddress(h.getAddress());
			h1.setBookingType(h.getBookingType());
			h1.setContactNo(h.getContactNo());
			h1.setCostPerDay(h.getCostPerDay());
			h1.setEmail(h.getEmail());
			h1.setHourlyCost(h.getHourlyCost());
			h1.setManager(h.getManager());
			h1.setName(h.getName());
			h1.setNoOfRooms(h.getNoOfRooms());
			h1.setOverallRating(h.getOverallRating());
			h1.setOverview(h.getOverview());
			h1.setPlace(h.getPlace());
			h1.setPlaceOffers(h.getPlaceOffers());
			h1.setReviews(h.getReviews());
			return modelMapper.map(hotelRepository.save(h1), HotelDTO.class);
		}
		
		return null;
	}

	@Override
	public HdtoForHotel getHotelBymanagerid(int id) {
		// TODO Auto-generated method stub
		Hotel h1 = managerRepository.findById(id).get().getHotel();
		
		return modelMapper.map(h1, HdtoForHotel.class);
	}
	
	public HotelDTO HotelToDto(Hotel h) {
		HotelDTO hdto = this.modelMapper.map(h, HotelDTO.class);
		return hdto;
	}
	
	public Hotel DtoToHotel(HotelDTO h) {
		Hotel he = this.modelMapper.map(h, Hotel.class);
		
		return he;
	}

	@Override
	public List<HdtoForHotel> findHotelByName(String name) {
		// TODO Auto-generated method stub
		List<Hotel> hotels = hotelRepository.findByName(name);
		
		return hotels.stream().map(hotel -> modelMapper.map(hotel, HdtoForHotel.class)).collect(Collectors.toList());
	}


	@Override
	public List<HdtoForHotel> findHotelByPlace(String place) {
		// TODO Auto-generated method stub
		List<Hotel> hotels = hotelRepository.findByPlace(place);
		
		return hotels.stream().map(hotel -> modelMapper.map(hotel, HdtoForHotel.class)).collect(Collectors.toList());
	}


	
	@Override
	public List<HdtoForHotel> findHotelByBookingType(String type) {
		// TODO Auto-generated method stub
		List<Hotel> hotels = hotelRepository.findByBookingType(type);
		
		return hotels.stream().map(hotel -> modelMapper.map(hotel, HdtoForHotel.class)).collect(Collectors.toList());
	}
	
//	@Override
//	public List<Hotel> findallHotels() {
//		// TODO Auto-generated method stub
//		return hotelRepository.findAll();
//	}
//
//	@Override
//	public Hotel findHotelById(int id) {
//		// TODO Auto-generated method stub
//		Optional<Hotel> op = hotelRepository.findById(id);
//		if(op.isPresent()) {
//			return op.get();
//		}
//		return null;
//	}
//
//	@Override
//	public Hotel addNewHotel(Hotel h) {
//		// TODO Auto-generated method stub
////		h.getManager().setHotel(h);
//		return hotelRepository.save(h);
//	}
//
//	@Override
//	public String deleteHotelById(int id) {
//		// TODO Auto-generated method stub
//		hotelRepository.deleteById(id);
//		return "hotel deleted";
//	}
//
//	@Override
//	public Hotel UpdateHotel(Hotel h) {
//		// TODO Auto-generated method stub
//		Optional<Hotel> op = hotelRepository.findById(h.getHid());
//		if(op.isPresent()) {
//			Hotel h1 = op.get();
//			h1.setAbout(h.getAbout());
//			h1.setAddress(h.getAddress());
//			h1.setBookingType(h.getBookingType());
//			h1.setContactNo(h.getContactNo());
//			h1.setCostPerDay(h.getCostPerDay());
//			h1.setEmail(h.getEmail());
//			h1.setHourlyCost(h.getHourlyCost());
//			h1.setManager(h.getManager());
//			h1.setName(h.getName());
//			h1.setNoOfRooms(h.getNoOfRooms());
//			h1.setOverallRating(h.getOverallRating());
//			h1.setOverview(h.getOverview());
//			h1.setPlace(h.getPlace());
//			h1.setPlaceOffers(h.getPlaceOffers());
//			h1.setRevies(h.getRevies());
//			return hotelRepository.save(h1);
//		}
//		
//		return null;
//	}
//
//	@Override
//	public Hotel getHotelBymanagerid(int id) {
//		// TODO Auto-generated method stub
//		Optional<Manager>  op = managerRepository.findById(id);
//		if(op.isPresent()) {
//			return op.get().getHotel();
//		}
//		return null;
//	}

}
