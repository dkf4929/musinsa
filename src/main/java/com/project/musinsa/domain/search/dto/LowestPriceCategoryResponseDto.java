package com.project.musinsa.domain.search.dto;

import com.project.musinsa.global.utils.CommonUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class LowestPriceCategoryResponseDto {
    @Schema(description = "상품 카테고리", example = "TOP")
    private String itemCategory;

    @Schema(description = "브랜드명", example = "FREI")
    private String brandName;

    @Schema(description = "상품 가격", example = "10,000")
    private String price;

    public static LowestPriceCategoryResponseDto of(String itemCategory, String brandName, Integer price) {
        LowestPriceCategoryResponseDto dto = new LowestPriceCategoryResponseDto();

        dto.itemCategory = itemCategory;
        dto.brandName = brandName;
        dto.price = CommonUtils.formatPrice(price);

        return dto;
    }
}
