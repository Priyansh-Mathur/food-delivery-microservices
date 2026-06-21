package com.fooddelivery.restrauntservice.repository;

import com.fooddelivery.restrauntservice.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByRestrauntId(Long restrauntId);
}
