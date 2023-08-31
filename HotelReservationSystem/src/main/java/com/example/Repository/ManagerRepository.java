package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Manager;
import java.util.List;


public interface ManagerRepository extends JpaRepository<Manager, Integer>{

//	public Manager findByname(String name);
	public List<Manager> findByName(String name);
	
}
