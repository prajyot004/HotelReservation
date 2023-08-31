package com.example.Service;

import java.util.List;

import com.example.Entity.Hotel;
import com.example.Entity.DTO.HdtoForHotel;
import com.example.Entity.DTO.HotelDTO;

public interface HotelService {
//	public List<Hotel> findallHotels();
//	public Hotel findHotelById(int id);
//	public Hotel addNewHotel(Hotel h);
//	public String deleteHotelById(int id);
//	public Hotel UpdateHotel(Hotel h);
//	public Hotel getHotelBymanagerid(int id);
	
	public List<HdtoForHotel> findallHotels();
	public HdtoForHotel findHotelById(int id);
	public HotelDTO addNewHotel(Hotel h);
	public String deleteHotelById(int id);
	public HotelDTO UpdateHotel(Hotel h,int id);
	public HdtoForHotel getHotelBymanagerid(int id);
	public List<HdtoForHotel> findHotelByName(String name);
	
	public List<HdtoForHotel> findHotelByPlace(String place);
	
	public List<HdtoForHotel> findHotelByBookingType(String type);
	
}
