package com.example.Entity.DTO;

import java.util.List;

import com.example.Entity.Reservation;
import com.example.Entity.Review;
import com.example.Entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class HdtoForHotel {

	private int Hid;
    private String name;
    private String place;
    private String Address;
    private long ContactNo;
    private String Email;
    private String PlaceOffers;
    private double CostPerDay;
    private double HourlyCost;
    private String Overview;
    private String BookingType;
    private int NoOfRooms;
    private List<ReviewDTO2> reviews;
    private int overallRating;
    private String about;
    private ManagerDto3 manager;
}
