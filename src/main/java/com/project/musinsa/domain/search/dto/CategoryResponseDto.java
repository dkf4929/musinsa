package com.project.musinsa.domain.search.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.musinsa.global.utils.CommonUtils;
import lombok.Getter;

@Getter
public class CategoryResponseDto {
    @JsonProperty("카테고리")
    private String categoryName;
    @JsonProperty("가격")
    private String price;

    @JsonIgnore
    private Integer sortNumber;

    public static CategoryResponseDto of(String categoryName, Integer price, Integer sortNumber) {
        CategoryResponseDto dto = new CategoryResponseDto();

        dto.categoryName = categoryName;
        dto.price = CommonUtils.formatPrice(price);
        dto.sortNumber = sortNumber;

        return dto;
    }
}
