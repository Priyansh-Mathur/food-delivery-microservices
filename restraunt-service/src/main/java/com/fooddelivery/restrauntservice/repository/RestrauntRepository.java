package com.fooddelivery.restrauntservice.repository;

import com.fooddelivery.restrauntservice.entity.Restraunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrauntRepository extends JpaRepository<Restraunt, Long> {
}
