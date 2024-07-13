package com.project.musinsa.domain.item;

import com.project.musinsa.domain.brand.Brand;
import com.project.musinsa.domain.brand.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemCategory(ItemCategory itemCategory);

    List<Item> findByBrand(Brand brand);
}
