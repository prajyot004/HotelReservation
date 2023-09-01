package com.example.Service;

import java.util.List;

import com.example.Entity.Reservation;
import com.example.Entity.DTO.ReservationDTO;

public interface ReservationService {

	public ReservationDTO MakeNewReservation(Reservation r,int hid,int uid);
	public ReservationDTO UpdateReservation(Reservation r);
	public ReservationDTO getReservationById(int id);
	public List<ReservationDTO> getallReservations();
	public String deleteReservation(int id);
	public List<ReservationDTO> getReservationByUserid(int uid);
}
