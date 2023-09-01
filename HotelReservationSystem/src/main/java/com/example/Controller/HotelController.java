package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Hotel;
import com.example.Entity.DTO.HdtoForHotel;
import com.example.Entity.DTO.HotelDTO;
import com.example.Service.Impl.HotelServiceImp;

@RestController
public class HotelController {

	@Autowired
	HotelServiceImp hotelServiceImp;
	
	@GetMapping("/hotel")
	public List<HdtoForHotel> getallHotel(){
		return hotelServiceImp.findallHotels();
	}
	
	@GetMapping("/hotel/{id}")
	public HdtoForHotel gethotelbyid(@PathVariable int id) {
		return hotelServiceImp.findHotelById(id);
	}
	
//	@PostMapping("/hotel")
//	public HotelDTO addHotel(@RequestBody @Valid  Hotel h) {
//		return hotelServiceImp.addNewHotel(h);
//	}
	
	@PostMapping("/hotel")
	public ResponseEntity<Object> addHotel(@RequestBody @Valid  Hotel h) {
		return new ResponseEntity<>(hotelServiceImp.addNewHotel(h),HttpStatus.CREATED);
		
//		BindingResult hotelBindingResult = validateHotel(h);
//
//        // If there are validation errors in the Hotel entity or Manager entity, return them
//        if (hotelBindingResult.hasErrors()) {
//            return ResponseEntity.badRequest().body(hotelBindingResult.getAllErrors());
//        }
//
//        // Continue with saving the hotel
//        hotelServiceImp.addNewHotel(h);
//        return ResponseEntity.ok("Hotel created successfully");
	}
	
	@PutMapping("/hotel/update/{id}")
	public HotelDTO updateHotel(@RequestBody Hotel h,@PathVariable int id) {
		return hotelServiceImp.UpdateHotel(h,id);
	}
	
	@DeleteMapping("/hotel/delete/{id}")
	public String deleteHotelByid(@PathVariable int id) {
		return hotelServiceImp.deleteHotelById(id);
	}
	
	@GetMapping("/hotel/getbymanager/{id}")
	public HdtoForHotel getbymanager(@PathVariable int id) {
		return hotelServiceImp.getHotelBymanagerid(id);
	}
	
	@GetMapping("/hotel/getbyName/{name}")
	public List<HdtoForHotel> getbyHotelName(@PathVariable String name){
		return hotelServiceImp.findHotelByName(name);
	}
	
	@GetMapping("/hotel/getByPlace/{place}")
	public List<HdtoForHotel> getbyplace(@PathVariable String place){
		return hotelServiceImp.findHotelByPlace(place);
	}
	
	@GetMapping("/hotel/getByBookingType/{type}")
	public List<HdtoForHotel> getBybookingType(@PathVariable String type){
		return hotelServiceImp.findHotelByBookingType(type);
	}
	
	private BindingResult validateHotel(@Valid Hotel hotel) {
        // Perform validation for the Hotel entity
        return new BeanPropertyBindingResult(hotel, "hotel");
    }
	
	
	
	
	
//	@GetMapping("/hotel")
//	public List<Hotel> getallHotels(){
//		return hotelServiceImp.findallHotels();
//	}
//	
//	@PostMapping("/hotel")
//	public Hotel addHotel(@RequestBody Hotel h) {
//		return hotelServiceImp.addNewHotel(h);
//	}
//	
//	@GetMapping("/hotel/{id}")
//	public Hotel findbyid(@PathVariable int id) {
//		return hotelServiceImp.findHotelById(id);
//	}
//	
//	@PutMapping("/hotel")
//	public Hotel updateHotel(@RequestBody Hotel hotel) {
//		return hotelServiceImp.UpdateHotel(hotel);
//	}
//	
//	@DeleteMapping("/hotel/{id}")
//	public String deletehotel(@PathVariable int id) {
//		return hotelServiceImp.deleteHotelById(id);
//	}
//	
//	@GetMapping("/hotelbymid/{id}")
//	public Hotel findhotelbymid(@PathVariable int id) {
//		return hotelServiceImp.getHotelBymanagerid(id);
//	}
	
	
}
