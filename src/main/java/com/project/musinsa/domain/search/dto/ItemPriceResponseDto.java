package com.project.musinsa.domain.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.musinsa.domain.brand.ItemCategory;
import com.project.musinsa.domain.item.Item;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

@Getter
public class ItemPriceResponseDto {
    @JsonProperty("카테고리")
    @Schema(description = "카테고리명", example = "TOP")
    private String itemCategory;

    @JsonProperty("최저가")
    private BrandPriceResponseDto lowestPriceDto;

    @JsonProperty("최고가")
    private BrandPriceResponseDto highestPriceDto;

    public static ItemPriceResponseDto of(ItemCategory itemCategory,
                                          BrandPriceResponseDto lowestPriceDto,
                                          BrandPriceResponseDto highestPriceDto) {
        ItemPriceResponseDto dto = new ItemPriceResponseDto();

        dto.itemCategory = itemCategory.getName();
        dto.lowestPriceDto = lowestPriceDto;
        dto.highestPriceDto = highestPriceDto;

        return dto;
    }
}
