package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Manager;
import com.example.Entity.DTO.ManagerDTO;
import com.example.Entity.DTO.ReservationForManagerDTO;
import com.example.Service.Impl.ManagerServiceImpl;

@RestController
public class ManagerController {
	
	@Autowired
	ManagerServiceImpl managerServiceImpl;
	
	
	@GetMapping("/managers")
	public List<ManagerDTO> getallManagerDTOs(){
		return managerServiceImpl.getallManagerDTOs();
	}
	
	@PostMapping("/managers")
	public Manager addManager(@RequestBody Manager m) {
		return managerServiceImpl.addNewManager(m);
	}
	
	@GetMapping("/managers/{id}")
	public ManagerDTO findbyid(@PathVariable int id) {
		return managerServiceImpl.findManagerById(id);
	}
	
	@PutMapping("/managers")
	public ManagerDTO updatemanager(@RequestBody Manager m) {
		return managerServiceImpl.updateManager(m);
	}
	
	@DeleteMapping("/managers/{id}")
	public String deletemanager(@PathVariable int id) {
		return managerServiceImpl.deleteManagerById(id);
	}
	
	
	@GetMapping("/managersbyhid/{id}")
	public ManagerDTO findbyhid(@PathVariable int id) {
		return managerServiceImpl.findManagerByHotelId(id);
	}
	
	@GetMapping("/managerByName/{name}")
	public List<ManagerDTO> findbyname(@PathVariable String name) {
		return managerServiceImpl.findManagerByName(name);
	}
	
	@GetMapping("/managers/notConfirmed/{mid}")
	public List<ReservationForManagerDTO> getnotconfirmedRes(@PathVariable int mid){
		return managerServiceImpl.NotConfirmedReservation(mid);
	}
	
	@PatchMapping("/managers/confirmReservation/{rid}/{mid}")
	public ReservationForManagerDTO confirmReservation(@PathVariable int rid,@PathVariable int mid) {
		return managerServiceImpl.confirmReservation(rid, mid);
	}
	

}
