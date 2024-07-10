package com.project.musinsa.domain.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.musinsa.global.utils.CommonUtils;
import lombok.Getter;

import java.util.List;

@Getter
public class LowestPriceBrandResponseDto {
    @JsonProperty("브랜드")
    private String brandName;

    @JsonProperty("카테고리")
    private List<CategoryResponseDto> category;

    @JsonProperty("총액")
    private String totalPrice;

    public static LowestPriceBrandResponseDto of(String brandName, List<CategoryResponseDto> category, Integer totalPrice) {
        LowestPriceBrandResponseDto dto = new LowestPriceBrandResponseDto();

        dto.brandName = brandName;
        dto.category = category;
        dto.totalPrice = CommonUtils.formatPrice(totalPrice);

        return dto;
    }
}
