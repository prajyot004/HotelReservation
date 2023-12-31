package com.example.Service;

import java.util.List;

import com.example.Entity.Manager;
import com.example.Entity.DTO.ManagerDTO;
import com.example.Entity.DTO.ReservationForManagerDTO;

public interface ManagerServie {
	public List<Manager> getAllManager();
	public ManagerDTO findManagerById(int id);
	public List<ManagerDTO> findManagerByName(String name);
	
	public ManagerDTO findManagerByHotelId(int id);
	public String deleteManagerById(int id);
	public Manager addNewManager(Manager m);
	public ManagerDTO updateManager(Manager m);
	public List<ReservationForManagerDTO> NotConfirmedReservation(int mid);
	public ReservationForManagerDTO confirmReservation(int rid,int mid);
}
