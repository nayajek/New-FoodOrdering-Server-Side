package com.foodorder.repositories;

import com.foodorder.models.Menu_Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<Menu_Items, Long> {
}
