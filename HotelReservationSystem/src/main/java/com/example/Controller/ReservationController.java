package com.example.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Reservation;
import com.example.Entity.DTO.ReservationDTO;
import com.example.Service.Impl.ReservationServiceImpl;

@RestController
public class ReservationController {
	
	@Autowired
	ReservationServiceImpl reservationServiceImpl;
	
	@PostMapping("/reservation/{hid}/{uid}")
	public ReservationDTO makenewReservation(@RequestBody Reservation r,@PathVariable int hid,@PathVariable int uid) throws Exception, ParseException {
		return reservationServiceImpl.MakeNewReservation(r,hid,uid);
	}
	
	@GetMapping("/reservation")
	public List<ReservationDTO> getallReservation(){
		return reservationServiceImpl.getallReservations();
	}
	
	@GetMapping("/reservation/{uid}")
	public List<ReservationDTO> getReservationByUid(@PathVariable int uid){
		return reservationServiceImpl.getReservationByUserid(uid);
	}
	
	

}
