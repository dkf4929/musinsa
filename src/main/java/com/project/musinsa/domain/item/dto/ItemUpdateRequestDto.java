package com.project.musinsa.domain.item.dto;

import com.project.musinsa.domain.brand.ItemCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ItemUpdateRequestDto {
    @NotNull
    private Long itemId;

    @NotNull
    private ItemCategory itemCategory;

    @NotNull
    private Long brandId;

    @NotNull
    private Integer price;
}
