package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
