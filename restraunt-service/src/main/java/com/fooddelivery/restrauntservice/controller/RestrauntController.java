package com.fooddelivery.restrauntservice.controller;

import com.fooddelivery.restrauntservice.entity.MenuItem;
import com.fooddelivery.restrauntservice.entity.Restraunt;
import com.fooddelivery.restrauntservice.repository.MenuItemRepository;
import com.fooddelivery.restrauntservice.repository.RestrauntRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restraunts")
public class RestrauntController {

    private final RestrauntRepository restrauntRepository;
    private final MenuItemRepository menuItemRepository;

    public RestrauntController(RestrauntRepository restrauntRepository, MenuItemRepository menuItemRepository) {
        this.restrauntRepository = restrauntRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @GetMapping
    public List<Restraunt> getAllRestraunts() {
        return restrauntRepository.findAll();
    }

    @GetMapping("/{id}")
    public Restraunt getRestrauntById(@PathVariable Long id) {
        return restrauntRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restraunt not found"));
    }

    @PostMapping
    public Restraunt addRestraunt(@RequestBody Restraunt restraunt) {
        return restrauntRepository.save(restraunt);
    }

    @GetMapping("/{restrauntId}/menu")
    public List<MenuItem> getMenuByRestraunt(@PathVariable Long restrauntId) {
        return menuItemRepository.findByRestrauntId(restrauntId);
    }

    @GetMapping("/menu/{menuItemId}")
    public MenuItem getMenuItem(@PathVariable Long menuItemId) {
        return menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
    }
}
