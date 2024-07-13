package com.project.musinsa.domain.item.dto;

import com.project.musinsa.domain.brand.dto.BrandResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ItemResponseDto {
    //    @JsonIgnore
    @Schema(description = "품목 ID", example = "TOP")
    private Long id;

    @Schema(description = "카테고리", example = "상의")
    private String category;

    @Schema(description = "브랜드")
    private BrandResponseDto brand;

    @Schema(description = "가격", example = "10,000")
    private Integer price;
}
