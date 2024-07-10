package com.project.musinsa.domain.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.musinsa.domain.item.Item;
import com.project.musinsa.global.utils.CommonUtils;
import lombok.Getter;

@Getter
public class BrandPriceResponseDto {
    @JsonProperty("브랜드")
    private String brandName;

    @JsonProperty("가격")
    private String price;

    public static BrandPriceResponseDto of(String brandName, Integer price) {
        BrandPriceResponseDto dto = new BrandPriceResponseDto();

        dto.brandName = brandName;
        dto.price = CommonUtils.formatPrice(price);

        return dto;
    }
}
