package com.project.musinsa.domain.brand.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class BrandUpdateRequestDto {
    @NotNull
    private Long brandId;

    @NotBlank
    private String brandName;
}
