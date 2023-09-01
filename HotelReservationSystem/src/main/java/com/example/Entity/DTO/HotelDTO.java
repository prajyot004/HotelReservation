package com.example.Entity.DTO;

import java.util.List;

import com.example.Entity.Manager;
import com.example.Entity.Review;
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
public class HotelDTO {

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
    private List<ReviewDTOforHotel> reviews;
    private int overallRating;
    private String about;
    @JsonIgnoreProperties("hotel")
    private ManagerDTO manager;
//    private String NameManager;
//    private int ManagerMid;
}
