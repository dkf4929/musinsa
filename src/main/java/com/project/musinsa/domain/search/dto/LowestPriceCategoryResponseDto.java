package com.project.musinsa.domain.search.dto;

import com.project.musinsa.global.utils.CommonUtils;
import lombok.Getter;

import java.text.NumberFormat;
import java.util.Locale;

@Getter
public class LowestPriceCategoryResponseDto {
    private String itemCategory;

    private String brandName;

    private String price;

    public static LowestPriceCategoryResponseDto of(String itemCategory, String brandName, Integer price) {
        LowestPriceCategoryResponseDto dto = new LowestPriceCategoryResponseDto();

        dto.itemCategory = itemCategory;
        dto.brandName = brandName;
        dto.price = CommonUtils.formatPrice(price);

        return dto;
    }
}
