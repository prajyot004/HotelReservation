package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
