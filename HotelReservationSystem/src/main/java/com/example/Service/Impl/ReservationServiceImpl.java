package com.example.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Hotel;
import com.example.Entity.Manager;
import com.example.Entity.Reservation;
import com.example.Entity.User;
import com.example.Entity.DTO.ReservationDTO;
import com.example.Repository.HotelRepository;
import com.example.Repository.ReservationRepository;
import com.example.Repository.UserRepository;
import com.example.Service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public ReservationDTO resToDto(Reservation r) {
		return modelMapper.map(r, ReservationDTO.class);
	}
	
	public Reservation dtoToRes(ReservationDTO r) {
		return modelMapper.map(r, Reservation.class);
	}
	
	@Override
	public ReservationDTO MakeNewReservation(Reservation r, int hid, int uid) {
		Optional<Hotel> h1 = hotelRepository.findById(hid);

        if (h1.isPresent()) {
            Hotel h2 = h1.get();
            r.setHotel(h2);

            // Get the manager associated with the hotel
            Manager manager = h2.getManager();
            manager.getReservations().add(r);
        }

        Optional<User> u1 = userRepository.findById(uid);
        if (u1.isPresent()) {
            r.setUser(u1.get());
        }
        
        

//        r.getManager().getReservations().add(r);
        Reservation r1 = reservationRepository.save(r);
//        r1.getHotel().setManager();

        return resToDto(r1); 
    }

	@Override
	public ReservationDTO UpdateReservation(Reservation r) {
		// TODO Auto-generated method stub
		Optional<Reservation> op = reservationRepository.findById(r.getResId());
		if(op.isPresent()) {
			Reservation r1 = op.get();
			r1.setCheckInDate(r.getCheckInDate());
			r1.setCheckOutDate(r.getCheckOutDate());
			r1.setConfirmationCode(r.getConfirmationCode());
			r1.setGuestCount(r.getGuestCount());
			r1.setHotel(r.getHotel());
			r1.setReservationDate(r.getReservationDate());
			r1.setSpecialRequests(r.getSpecialRequests());
			r1.setUser(r.getUser());
			return resToDto(reservationRepository.save(r1));
		}
		return null;
	}

	@Override
	public ReservationDTO getReservationById(int id) {
		// TODO Auto-generated method stub
		Optional<Reservation> op = reservationRepository.findById(id);
		if(op.isPresent()) {
			return resToDto(op.get());
		}
		return null;
	}

	@Override
	public List<ReservationDTO> getallReservations() {
		// TODO Auto-generated method stub
		List<Reservation> lst = reservationRepository.findAll();
		return lst.stream().map(res -> resToDto(res)).collect(Collectors.toList());
	}

	@Override
	public String deleteReservation(int id) {
		// TODO Auto-generated method stub
		reservationRepository.deleteById(id);
		
		return "Reservation deleted";
	}
	
	

}
