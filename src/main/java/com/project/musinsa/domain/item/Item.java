package com.project.musinsa.domain.item;

import com.project.musinsa.domain.brand.Brand;
import com.project.musinsa.domain.brand.ItemCategory;
import com.project.musinsa.domain.item.dto.ItemSaveRequestDto;
import com.project.musinsa.domain.item.dto.ItemUpdateRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_category")
    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "fk_brand_to_item"))
    private Brand brand;

    @NotNull
    private Integer price;

    public static Item create(ItemSaveRequestDto requestDto, Brand brand) {
        Item item = new Item();

        item.itemCategory = requestDto.getItemCategory();
        item.brand = brand;
        item.price = requestDto.getPrice();

        return item;
    }

    public void updateItem(ItemUpdateRequestDto requestDto, Brand brand) {
        this.itemCategory = requestDto.getItemCategory();
        this.brand = brand;
        this.price = requestDto.getPrice();
    }
}
