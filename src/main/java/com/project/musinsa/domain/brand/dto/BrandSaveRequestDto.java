package com.project.musinsa.domain.brand.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class BrandSaveRequestDto {
    @NotBlank
    private String brandName;
}
