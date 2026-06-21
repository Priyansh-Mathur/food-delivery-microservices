package com.fooddelivery.restrauntservice.config;

import com.fooddelivery.restrauntservice.entity.MenuItem;
import com.fooddelivery.restrauntservice.entity.Restraunt;
import com.fooddelivery.restrauntservice.repository.MenuItemRepository;
import com.fooddelivery.restrauntservice.repository.RestrauntRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final RestrauntRepository restrauntRepository;
    private final MenuItemRepository menuItemRepository;

    public DataLoader(RestrauntRepository restrauntRepository, MenuItemRepository menuItemRepository) {
        this.restrauntRepository = restrauntRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public void run(String... args) {
        if (restrauntRepository.count() == 0) {
            Restraunt r1 = restrauntRepository.save(new Restraunt("Pizza Palace", "Bhopal", "Italian"));
            Restraunt r2 = restrauntRepository.save(new Restraunt("Biryani House", "Bhopal", "Indian"));

            menuItemRepository.save(new MenuItem(r1.getId(), "Margherita Pizza", new BigDecimal("199"), true));
            menuItemRepository.save(new MenuItem(r1.getId(), "Farmhouse Pizza", new BigDecimal("299"), true));
            menuItemRepository.save(new MenuItem(r2.getId(), "Veg Biryani", new BigDecimal("149"), true));
            menuItemRepository.save(new MenuItem(r2.getId(), "Paneer Biryani", new BigDecimal("229"), true));
        }
    }
}
