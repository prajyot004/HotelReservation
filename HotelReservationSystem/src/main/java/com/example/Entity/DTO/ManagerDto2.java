package com.example.Entity.DTO;

import java.util.List;

import com.example.Entity.Review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto2 {
	private String name;  // Match the entity field name
    
    private int Mid;
    
    private long contactNo;
}
