package com.project.musinsa.domain.brand.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BrandSaveRequestDto {
    @NotBlank(message = "브랜드명을 입력하세요.")
    @Schema(description = "사용자 아이디", example = "FREI")
    private String brandName;
}
