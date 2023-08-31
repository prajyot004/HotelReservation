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
import com.example.Entity.DTO.HdtoForHotel;
import com.example.Entity.DTO.ManagerDTO;
import com.example.Repository.HotelRepository;
import com.example.Repository.ManagerRepository;
import com.example.Service.ManagerServie;

@Service
public class ManagerServiceImpl  implements ManagerServie{

	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		return managerRepository.findAll();
	}

	public List<ManagerDTO> getallManagerDTOs(){
		List<Manager> managers = managerRepository.findAll();
		return managers.stream()
				.map(manager -> modelMapper.map(manager, ManagerDTO.class))
				.collect(Collectors.toList());
//		List<ManagerDTO> mdl = new ArrayList<>();
//		for(Manager mg :  managers) {
//			mdl.add(entityToDto(mg));
//		}
//		
//		return  mdl;
		
	}
	
	public ManagerDTO manToDto(Manager m) {
		ManagerDTO mdto = modelMapper.map(m, ManagerDTO.class);
//		mdto.getHotel().setManager(null);
		
		return mdto;
	}
	
	public Manager DtoToMan(ManagerDTO m) {
		return modelMapper.map(m, Manager.class);
	}
	
	
	@Override
	public ManagerDTO findManagerById(int id) {
		// TODO Auto-generated method stub
		Optional<Manager> op = managerRepository.findById(id);
		if(op.isPresent()) {
			ManagerDTO md = manToDto(op.get());
			return md;
		}
		return null;
		
	}

	@Override
	public List<ManagerDTO> findManagerByName(String name) {
		// TODO Auto-generated method stub
		List<Manager> managers = managerRepository.findByName(name);
//		hotels.stream().map(hotel -> modelMapper.map(hotel, HdtoForHotel.class)).collect(Collectors.toList());
		return managers.stream().map(man -> modelMapper.map(man, ManagerDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ManagerDTO findManagerByHotelId(int id) {
		// TODO Auto-generated method stub
		Optional<Hotel> op = hotelRepository.findById(id);
		if(op.isPresent()) {
			ManagerDTO md = manToDto(op.get().getManager());
			return md;
		}
		return null;
	}

	@Override
	public String deleteManagerById(int id) {
		// TODO Auto-generated method stub
		managerRepository.deleteById(id);
		return "manager deleted";
	}

	@Override
	public Manager addNewManager(Manager m) {
		// TODO Auto-generated method stub
		
		return managerRepository.save(m);
	}

	@Override
	public ManagerDTO updateManager(Manager m) {
		// TODO Auto-generated method stub
		Optional<Manager> op = managerRepository.findById(m.getMid());
		
		if(op.isPresent()) {
			Manager m1 = op.get();
			m1.setContactNo(m.getContactNo());
			m1.setName(m.getName());
			return modelMapper.map(managerRepository.save(m1), ManagerDTO.class);
		}
		
		return null;
	}

}
