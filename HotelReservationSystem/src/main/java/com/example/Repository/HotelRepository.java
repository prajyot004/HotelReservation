package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Hotel;
import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	public List<Hotel> findByName(String name);
//	public List<Hotel> findByBookingType(String bookingType);
	List<Hotel> findByBookingType(String type);
	public List<Hotel> findByPlace(String place);

}
